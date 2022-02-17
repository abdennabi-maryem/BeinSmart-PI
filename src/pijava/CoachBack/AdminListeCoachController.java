/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.CoachBack;

import Entities.Coach;
import Service.ServiceCoach;
import Utils.UserSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
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
import pijava.AdminUser.BackUserListController;
import pijava.UsersFront.UserProfilController;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class AdminListeCoachController implements Initializable {

    @FXML
    private Label UsernameADMIN;
    @FXML
    private ListView<Coach> listView;
    @FXML
    private VBox Vbx;
    @FXML
    private ImageView ProfilIMG;
    @FXML
    private ImageView MatchIMG;
    @FXML
    private ImageView UserIMG;
    @FXML
    private ImageView NewsIMG;
    @FXML
    private ImageView EventIMG;
    @FXML
    private ImageView RecIMG;
    @FXML
    private ImageView TerrainIMG;
    @FXML
    private ImageView CoachIMG;
    @FXML
    private ImageView ArbitreIMG;
    @FXML
    private ImageView GymIMG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File UserIconFile = new File("image/UserIcon.png");
        Image UserIcon = new Image(UserIconFile.toURI().toString());
        ProfilIMG.setImage(UserIcon);
        UsernameADMIN.setText(UserSession.getUsername());
        
        
        
       
        
        File MatchFile = new File("image/MatchTXT.png");
        Image MatchIcon = new Image(MatchFile.toURI().toString());
        MatchIMG.setImage(MatchIcon);
        
       
        UserIMG.setImage(UserIcon);
        
         File NewsFile = new File("image/NewsTXT.png");
        Image NewsIcon = new Image(NewsFile.toURI().toString());
        NewsIMG.setImage(NewsIcon);
        
         File EventFile = new File("image/EventTXT.png");
        Image EventIcon = new Image(EventFile.toURI().toString());
        EventIMG.setImage(EventIcon);
        
        File RecFile = new File("image/RecTXT.png");
        Image RecIcon = new Image(RecFile.toURI().toString());
        RecIMG.setImage(RecIcon);
        
        File TerrainFile = new File("image/Terrain.png");
        Image TerrainIcon = new Image(TerrainFile.toURI().toString());
        TerrainIMG.setImage(TerrainIcon);
        
        File CoachFile = new File("image/CoachIcon.png");
        Image CoachIcon = new Image(CoachFile.toURI().toString());
        CoachIMG.setImage(CoachIcon);
        
        File ArbitreFile = new File("image/ArbitreIcon.png");
        Image ArbitreIcon = new Image(ArbitreFile.toURI().toString());
        ArbitreIMG.setImage(ArbitreIcon);
        
        File GymFile = new File("image/GymIcon.png");
        Image GymIcon = new Image(GymFile.toURI().toString());
        GymIMG.setImage(GymIcon);
        
        AffichList();
    }    

    
     public void AffichList() {
        
        ServiceCoach SC = new ServiceCoach();
        // Simple interface
        
        Vbx.setPadding(new Insets(10));
        Vbx.setAlignment(Pos.CENTER);

        // Create some sample Users
        ObservableList<Coach> coachList = SC.AfficherListCoach();
        

        

        // We need to create a new CellFactory so we can display our layout for each individual user
        listView.setCellFactory((Callback<ListView<Coach>, ListCell<Coach>>) param -> {
            return new ListCell<Coach>() {
                @Override
                protected void updateItem(Coach c, boolean empty) {
                    super.updateItem(c, empty);

                    if (c == null || empty) {
                        setText(null);
                    } else {
                       
                        HBox Hbx = new HBox(10);
                        Hbx.setAlignment(Pos.CENTER_LEFT);
                        Hbx.setPadding(new Insets(5, 10, 5, 10));
                        
                   
                       // Profil pic image 
                       
                                   String path = c.getURLImg();
        
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
                       Label UserLabel = new Label( c.getUsername() +"\n Filiere : " +c.getFiliere() +"\n Experience : " +c.getAnExp() +" ans \n Region : " +c.getRegion() );
                      
                      // Username Label
                      
                       
                         UserLabel.setMinWidth(100);
                        UserLabel.setMinHeight(100);
                        Hbx.getChildren().add(UserLabel);
                        UserLabel.setCursor(Cursor.HAND);
                        
                        UserLabel.setOnMouseClicked((mouseEvent)-> {
                            System.out.println(c);
                             Node node = (Node) mouseEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/CoachBack/ResumeCoach.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    
                     
                     ResumeCoachController RCC = loader.getController();
                     RCC.ResumeCoach(c);
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
                        
                        
                        
                        // SUPPRESSION 
                        Button SuppBTN = new Button("Supprimer");
                        SuppBTN.setOnAction(event -> {
                            //Confirmation 
                              Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation");
                            alert.setHeaderText(null);
                            alert.setContentText("Voulez-vous vraiment supprimer ce Coach ? ");

                        Optional <ButtonType> action = alert.showAndWait();
                            
                            if (action.get()== ButtonType.OK) {
                          SC.SupprimerCoach(c);
                          AffichList();
                            }
                        });
                        Hbx.getChildren().add(SuppBTN);

                        // Finally, set our cell to display the  HBox
                        setText(null);
                        setGraphic(Hbx);
                    }

                }
            };

        });

        // Set our users to display in the ListView
        listView.setItems(coachList);

        Vbx.getChildren().add(listView);
    } 
    
   @FXML
     private void UserControlOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/AdminUser/BackUserList.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void RecControlOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/AdminReclamation/BackReclamation.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void DashboardOnAction(ActionEvent event) {
            // direction interface admin 
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/AdminInterface/AdminInterface.fxml"));
        try {
        loader.load();


        } catch (IOException ex) {
        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    private void CoachControlOnAction(ActionEvent event) {
        Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("BackMenuCoach.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void RetourCoachOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("BackMenuCoach.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminDemandeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }
    
    @FXML
    private void NewsControlOnAction(ActionEvent event) {
        Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/NewsCom/FXMLNews0.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }
}
