/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Terrain;

import Entities.Terrain;
import Service.ServiceTerrain;
import java.awt.image.BufferedImage;
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

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class AfficherTerrainFrontController implements Initializable {

    @FXML
    private Button RetourButton;
    @FXML
    private ListView<Terrain> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                        
                       Label terrLabel = new Label( "  Terrain : "+terr.getNomT() + "\n \n  Adresse : " +terr.getAdresse()+ "\n \n  Sport : " +terr.getType_sport() );
                      
                      
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
    private void RetourButtonOnAction(ActionEvent event) {
        Node node = (Node) event.getSource();
             Stage stage = (Stage) node.getScene().getWindow();
             FXMLLoader loader = new FXMLLoader ();
             loader.setLocation(getClass().getResource("/pijava/Login/Autres.fxml"));
             try {
                 loader.load();
                 
                 
             } catch (IOException ex) {
                 System.out.println(ex);
                 System.out.println("failed to load");
                 System.out.println(ex); 
             }
             Parent parent = loader.getRoot();
             stage.setScene(new Scene(parent));
             stage.show();
    }
    
}
