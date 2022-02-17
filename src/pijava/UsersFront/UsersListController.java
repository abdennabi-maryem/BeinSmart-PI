/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.UsersFront;

import Entities.Utilisateur;
import Service.ServiceUtilisateur;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;

import Service.ServiceFriend;
import Entities.Friend;
import Utils.UserSession;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class UsersListController implements Initializable {

    @FXML
    private ListView<Utilisateur> listView;
    @FXML
    private VBox Vbx;
    @FXML
    private TextField SearchTf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AffichList();
    }    
    
     public void AffichList() {
        
        ServiceUtilisateur SU = new ServiceUtilisateur();
        ServiceFriend SF = new ServiceFriend();
        // Simple interface
        
        Vbx.setPadding(new Insets(10));
        Vbx.setAlignment(Pos.CENTER);

        // Create some sample Users
        ObservableList<Utilisateur> usersList = SU.AfficherUser();
        

        

        // We need to create a new CellFactory so we can display our layout for each individual user
        listView.setCellFactory((Callback<ListView<Utilisateur>, ListCell<Utilisateur>>) param -> {
            return new ListCell<Utilisateur>() {
                @Override
                protected void updateItem(Utilisateur user, boolean empty) {
                    super.updateItem(user, empty);

                    if (user == null || empty) {
                        setText(null);
                    } else {
                       
                        HBox Hbx = new HBox(10);
                        Hbx.setAlignment(Pos.CENTER_LEFT);
                        Hbx.setPadding(new Insets(5, 10, 5, 10));
                        
                   
                       // Profil pic image 
                       
                                       String path = user.getURLImg();
        
                                BufferedImage BfImg = null;
                                try {
                                   URL url = new URL(path);
                                    BfImg = ImageIO.read(url);

                         } catch (Exception ex) {
                            System.out.println("Failed to load image");
                            System.out.println(ex);
                         }
                         WritableImage wr = null;
                         if (BfImg != null) {
                             wr = new WritableImage(BfImg.getWidth(), BfImg.getHeight());
                             PixelWriter pw = wr.getPixelWriter();
                             for (int x = 0; x < BfImg.getWidth(); x++) {
                                 for (int y = 0; y < BfImg.getHeight(); y++) {
                                     pw.setArgb(x, y, BfImg.getRGB(x, y));
                                 }
                             }
                         }
                         ImageView ProfilIMG = new ImageView();
                      ProfilIMG.setFitHeight(150);
                      ProfilIMG.setFitWidth(150);
                         ProfilIMG.setImage(wr);
                         Hbx.getChildren().add(ProfilIMG);
                        
                       //
                        
                        
                    // Username + nom Label
                      // Label UserLabel = new Label( user.getUsername() + "\n" +user.getNom() );
                      
                      // Username Label
                      
                       Label UserLabel = new Label(user.getUsername());
                         UserLabel.setMinWidth(100);
                        UserLabel.setMinHeight(100);
                        Hbx.getChildren().add(UserLabel);
                        UserLabel.setCursor(Cursor.HAND);
                        UserLabel.setOnMouseClicked((mouseEvent)-> {
                            Node node = (Node) mouseEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("UserProfil.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    
                     
                     UserProfilController UPC = loader.getController();
                     UPC.AffichUserProfil(user);
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show();
                        });
                    // 
                    
                    
                        // I'll add another Region here to expand, pushing the buttons to the right
                        Region region = new Region();
                        HBox.setHgrow(region, Priority.ALWAYS);
                        Hbx.getChildren().add(region);
                        

                        // AJOUT DES BOUTONS 
                        
                        // Ajouter comme amis 
                        Button AddBTN = new Button("Ajouter");
                        
                        //verifier si ils sont deja amis                                                                                        // ce n'est pas l'utilisateur lui meme
                        if (SF.Friendship(user.getId(),UserSession.getID()) == false || SF.Friendship(UserSession.getID(),user.getId()) == false  || user.getId()==UserSession.getID()) {
                              AddBTN.setVisible(false);
                          }
                        AddBTN.setOnAction(event -> {
                            // Code Ajouter
                           Friend F = new Friend();
                           F.setIDUser(UserSession.getID());
                           F.setFriendID(user.getId());
                           
                           SF.Addfriend(F);
                           
                           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Amis");
                            alert.setHeaderText(null);
                            alert.setContentText("Votre invitation a été envoyé !");

                            alert.showAndWait();
                            AffichList();
                           
                       
                           
                        });
                        
                       
                       
                        Hbx.getChildren().add(AddBTN);

                        // Finally, set our cell to display the  HBox
                        setText(null);
                        setGraphic(Hbx);
                    }

                }
            };

        });

        // Set our users to display in the ListView
        listView.setItems(usersList);

        Vbx.getChildren().add(listView);

       
    }

    @FXML
    private void RetourOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/Login/Accueil.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    
}
