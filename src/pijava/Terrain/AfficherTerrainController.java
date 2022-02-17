/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Terrain;

import Entities.Terrain;
import Entities.Utilisateur;
import Service.ServiceTerrain;
import Service.ServiceUtilisateur;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import pijava.AdminUser.BackUserListController;
import pijava.AdminUser.ModifUserAdminController;
import pijava.CoachBack.AdminDemandeCoachController;
import pijava.CoachBack.AdminListeCoachController;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class AfficherTerrainController implements Initializable {

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
    @FXML
    private ImageView ProfilIMG;
    @FXML
    private Label UsernameADMIN;
    @FXML
    private ListView<Terrain> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
        // TODO
        
        AffichList();
    }    
    
    
    public void AffichList() {
        
        ServiceTerrain ST = new ServiceTerrain();
        // Simple interface
        
      

        // Create some sample Users
        ObservableList<Terrain> TerrainList = ST.AffichTerrain();
        

        

        // We need to create a new CellFactory so we can display our layout for each individual user
        listView.setCellFactory((Callback<ListView<Terrain>, ListCell<Terrain>>) param -> {
            return new ListCell<Terrain>() {
                @Override
                protected void updateItem(Terrain terr, boolean empty) {
                    super.updateItem(terr, empty);

                    if (terr == null || empty) {
                        setText(null);
                    } else {
                       
                        HBox Hbx = new HBox(10);
                        Hbx.setAlignment(Pos.CENTER_LEFT);
                        Hbx.setPadding(new Insets(5, 10, 5, 10));
                        
                        // Image du terrain 
                        String path = terr.getURLImg();
        
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
                         ImageView TerrIMG = new ImageView();
                      TerrIMG.setFitHeight(150);
                      TerrIMG.setFitWidth(150);
                         TerrIMG.setImage(wr);
                         Hbx.getChildren().add(TerrIMG);
                        
                       
                        //
                      
                        
                       Label terrLabel = new Label( "  Terrain : "+terr.getNomT() + "\n \n  Adresse : " +terr.getAdresse()+ "\n \n  Sport : " +terr.getType_sport() + "\n \n  Numero : " +terr.getNumTel() );
                      
                      
                         terrLabel.setMinWidth(100);
                        terrLabel.setMinHeight(100);
                        Hbx.getChildren().add(terrLabel);
                        terrLabel.setCursor(Cursor.HAND);
                    //
                    
                        // I'll add another Region here to expand, pushing the buttons to the right
                        Region region = new Region();
                        HBox.setHgrow(region, Priority.ALWAYS);
                        Hbx.getChildren().add(region);
                        

                        // AJOUT DES BOUTONS 
                        
                        // MODIFICATION 
                        Button ModifBTN = new Button("Modifier");
                        ModifBTN.setOnAction(event -> {
                            // Code modifier
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("ModifTerrain.fxml"));
                        try {
                            loader.load();
                           
                              } catch (IOException ex) {
                            Logger.getLogger(AfficherTerrainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ModifTerrainController MTC = loader.getController();
                        MTC.DetailTerrain(terr);
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
                           
                        });
                        
                        // SUPPRESSION 
                        Button SuppBTN = new Button("Supprimer");
                        SuppBTN.setOnAction(event -> {
                            //Confirmation 
                              Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation");
                            alert.setHeaderText(null);
                            alert.setContentText("Voulez-vous vraiment supprimer cet utilisateur ? ");

                        Optional <ButtonType> action = alert.showAndWait();
                            
                            if (action.get()== ButtonType.OK) {
                          ST.SupprTerrain(terr);
                          AffichList();
                            }
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
        listView.setItems(TerrainList);

        

       
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
