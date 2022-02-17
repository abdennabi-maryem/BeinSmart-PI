/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.NewsCom;

import Entities.News;
import Service.ServiceNews;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
 * @author essia
 */
public class ListNewsController implements Initializable {

    @FXML
    private JFXListView<News> listView;
    @FXML
    private VBox vBox;
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
// les bouttons de la navigation a gauche 
        
        
        
        File UserIconFile = new File("image/UserIcon.png");
        Image UserIcon = new Image(UserIconFile.toURI().toString());
        
        
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
        
        //
        
        
        // TODO
                                AffichList();

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
                               Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
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
                               Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
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
               Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
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
                               Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
                               System.out.println("failed to load");
                               System.out.println(ex);
                           }

                           Parent parent = loader.getRoot();
                           stage.setScene(new Scene(parent));
                           stage.show(); 
           }

    public void AffichList() {
        
        ServiceNews sn = new ServiceNews();
        
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);

        ObservableList<News> NewsList = sn.AfficherNews();
        listView.setStyle("  -fx-selection-bar: #90ee90 ; -fx-border-color:#90ee90");
        listView.setCellFactory((Callback<ListView<News>, ListCell<News>>) param -> {
            return new ListCell<News>() {
                @Override
                protected void updateItem(News n, boolean empty) {
                    super.updateItem(n, empty);

                    if (n == null || empty) {
                        setText(null);
                    } else {
                       
                        HBox Hbx = new HBox(100);
                       
   Label ts= new Label(n.getTypeSport());
                         ts.setMinWidth(100);
                        ts.setMinHeight(100);
                        Hbx.getChildren().add(ts);
                        ts.setCursor(Cursor.HAND);
                        //imageNews
                       String path =n.getURLImg();
                                        BufferedImage BfImg = null;
                         try {

                                URL url= new URL(path);
                                BfImg= ImageIO.read(url);
                                
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
                         ImageView NewsImage = new ImageView();
                      NewsImage.setFitHeight(150);
                      NewsImage.setFitWidth(300);
                         NewsImage.setImage(wr);
                         Hbx.getChildren().add(NewsImage);
                         
                       Label NewsLabel = new Label(n.getTitre());
                         NewsLabel.setMinWidth(100);
                        NewsLabel.setMinHeight(100);
                        Hbx.getChildren().add(NewsLabel);
                        NewsLabel.setCursor(Cursor.HAND);

                          Label Contenu= new Label(n.getContenu());
                         Contenu.setMinWidth(100);
                        Contenu.setMinHeight(100);
                        Hbx.getChildren().add(Contenu);
                        Contenu.setCursor(Cursor.HAND);
                         Hbx.setAlignment(Pos.CENTER_LEFT);
                        Hbx.setPadding(new Insets(5, 10, 5, 10));
 Label reacts= new Label(String.valueOf(n.getNbreacts())+" Likes");
                         reacts.setMinWidth(100);
                        reacts.setMinHeight(100);
                        Hbx.getChildren().add(reacts);
                        reacts.setCursor(Cursor.HAND);
//                        Contenu.setStyle("-fx-text-fill: #90ee90 ;-fx-font-weight: bold;");
//
                        Region region = new Region();
                        HBox.setHgrow(region, Priority.ALWAYS);
                        Hbx.getChildren().add(region);
                        
                        JFXButton Détails = new JFXButton("Modifier");
                        Détails.setStyle("-fx-background-color:  #90ee90; ");
                        
                        Détails.setOnAction(event -> {
                           
                            FXMLLoader loader = new FXMLLoader ();
                            
                            loader.setLocation(getClass().getResource("ModificationNews.fxml"));
                        try {
                            loader.load();
                           
                              } catch (IOException ex) {
                            Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        ModificationNewsController cc = loader.getController();
                        cc.AffichNewsDet(n);    
                        System.out.println(n.getId());

            
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
                           
                        });
                            Button Supp = new Button("Supprimer");
                                                    Supp.setStyle("-fx-background-color:  #90ee90; ");

                                                   Supp.setOnAction(event -> {
                                                     sn.SupprimerNews(n);
                                                     AffichList();});

                           Hbx.getChildren().addAll(Détails,Supp);
                        setText(null);
                        setGraphic(Hbx);
                    }

                }
            };

        });

        listView.setItems(NewsList);

        vBox.getChildren().add(listView);

       
    }

    @FXML
    private void NewsControlOnAction(ActionEvent event) {
    }

    @FXML
    private void Retour(ActionEvent event) {
        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                        
                            loader.setLocation(getClass().getResource("FXMLNews0.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
    }

    @FXML
    private void Actualiser(ActionEvent event) {
        AffichList();
    }




    
}
