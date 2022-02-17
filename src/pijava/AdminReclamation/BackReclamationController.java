/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.AdminReclamation;

import Entities.Reclamation;

import Service.ServiceReclamation;
import Utils.UserSession;
import java.io.File;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import pijava.AdminInterface.AdminInterfaceController;





/**
 * FXML Controller class
 *
 * @author 21699
 */
public class BackReclamationController implements Initializable {

    @FXML
    private Label UsernameADMIN;
    @FXML
    private ListView<Reclamation> listView;
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



   
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
             UsernameADMIN.setText(UserSession.getUsername());
        
        File UserIconFile = new File("image/UserIcon.png");
        Image UserIcon = new Image(UserIconFile.toURI().toString());
        ProfilIMG.setImage(UserIcon);
        
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
            AffichRec();
    }
   
    
      public void   AffichRec(){
        
        ServiceReclamation SR = new ServiceReclamation();
       
        // Simple interface
        
        Vbx.setPadding(new Insets(10));
        Vbx.setAlignment(Pos.CENTER);

        // Create some sample Users
        ObservableList<Reclamation> recList = SR.AfficherReclamation();
        

        

        // We need to create a new CellFactory so we can display our layout for each individual user
        listView.setCellFactory((Callback<ListView<Reclamation>, ListCell<Reclamation>>) param -> {
            return new ListCell<Reclamation>() {
                @Override
                protected void updateItem(Reclamation rec, boolean empty) {
                    super.updateItem(rec, empty);

                    if (rec == null || empty) {
                        setText(null);
                    } else {
                       
                        HBox Hbx = new HBox(10);
                        Hbx.setAlignment(Pos.CENTER_LEFT);
                        Hbx.setPadding(new Insets(5, 10, 5, 10));
                        
                   
                    /*
                        
                         System.out.println(SR.InfoReclameur(32).getId());
                     System.out.println(SR.InfoReclameur(32).getUsername());
                     System.out.println(SR.InfoReclameur(32).getEmail());
                    */
                    
                        String UserRec = SR.InfoReclameur(rec.getIDRec()).getUsername(); // username du reclameur 
                     // Label  
                    
                        Label recLabel = new Label(rec.getObjet() + "\n  Par : "  +UserRec + "\n  Le : " +rec.getDateAjout());
                        recLabel.setMinWidth(100);
                        recLabel.setMinHeight(100);
                        Hbx.getChildren().add(recLabel);
                        recLabel.setCursor(Cursor.HAND);
                    //
                    
                        // I'll add another Region here to expand, pushing the buttons to the right
                        Region region = new Region();
                        HBox.setHgrow(region, Priority.ALWAYS);
                        Hbx.getChildren().add(region);
                        

                        // AJOUT DES BOUTONS 
                        
                        // MODIFICATION 
                        Button ModifBTN = new Button("Voir");
                        ModifBTN.setOnAction(event -> {
                            // Code pour details
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("RecDetaille.fxml"));
                        try {
                            loader.load();
                           
                              } catch (IOException ex) {
                            Logger.getLogger(BackReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        RecDetailleController RDC = loader.getController();
                        RDC.AffichRecDet2(rec);
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
                           
                        });
                        
                        // SUPPRESSION 
                        Button SuppBTN = new Button("Supprimer");
                        SuppBTN.setOnAction(event -> {
                            // Code supprimer
                          SR.SupprimerReclamation(rec);
                           AffichRec();
                        });
                        Hbx.getChildren().addAll(ModifBTN, SuppBTN);

                        // Finally, set our cell to display the  HBox
                        setText(null);
                        setGraphic(Hbx);
                    }

                }
            };

        });

        // Set our users to display in the ListView
        listView.setItems(recList);

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
                        Logger.getLogger(BackReclamationController.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(BackReclamationController.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(BackReclamationController.class.getName()).log(Level.SEVERE, null, ex);
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
                loader.setLocation(getClass().getResource("/pijava/CoachBack/BackMenuCoach.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(BackReclamationController.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(BackReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }
}
