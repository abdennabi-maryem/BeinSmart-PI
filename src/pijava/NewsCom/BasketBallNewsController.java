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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author essia
 */
public class BasketBallNewsController implements Initializable {

   
    
    @FXML
    private JFXListView<News> listViewBasket;
    @FXML
    private VBox vBoxBasket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AffichList();
    }    
public void AffichList() {
        
        ServiceNews sn = new ServiceNews();
        
        vBoxBasket.setPadding(new Insets(10));
        vBoxBasket.setAlignment(Pos.CENTER);

        ObservableList<News> NewsList = sn.AfficherNews();
                                  listViewBasket.setStyle("  -fx-selection-bar: #90ee90 ; -fx-border-color:#90ee90;");

        listViewBasket.setCellFactory((Callback<ListView<News>, ListCell<News>>) param -> {
            return new ListCell<News>() {
                @Override
                protected void updateItem(News n, boolean empty) {
                    super.updateItem(n, empty);

                    if (n == null || empty) {
                        setText(null);
                    } else {
                       
                        HBox Hbx = new HBox(100);
                        Hbx.setAlignment(Pos.CENTER_LEFT);
                        Hbx.setPadding(new Insets(5, 10, 5, 10));

                        //imageNews
                       String path =n.getURLImg();
                       System.out.println(path);
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
                      NewsImage.setFitHeight(300);
                      NewsImage.setFitWidth(500);
                         NewsImage.setImage(wr);
                         Hbx.getChildren().add(NewsImage);
                     
                         Label InfosLabel = new Label("Publié le : "+n.getDate().toString()+"\n \n"+n.getTitre()+"\n \n"+n.getContenu());
                         InfosLabel.setMinWidth(100);
                       InfosLabel.setMinHeight(100);
                                                

                        InfosLabel.setCursor(Cursor.HAND);

                        
                        JFXButton Détails = new JFXButton("Plus de détails");
                        Détails.setStyle("-fx-background-color:  #90ee90; ");
                        
                        Détails.setOnAction(event -> {
                        Parent root = null;

                        
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        NewsHolder holder = NewsHolder.getInstance();
                        holder.setNews(n.getId());
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("FXMLCommentaires.fxml"));
                        try {
                            loader.load();
                           
                              } catch (IOException ex) {
                            Logger.getLogger(FootNewsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        FXMLCommentairesController cc = loader.getController();
                        cc.AffichNewsDet2(n);
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
                           
                        });

                       
                        Hbx.getChildren().addAll(InfosLabel,Détails);
                        setText(null);
                        setGraphic(Hbx);
                    }

                }
            };

        });

        listViewBasket.setItems(sn.AfficherNewsParTypeSport("BASKETBALL"));

        vBoxBasket.getChildren().add(listViewBasket);

       
    }

    @FXML
    private void RETOURACCUEILBASKET(ActionEvent event) {
         Parent root = null;
        try { 
            root = FXMLLoader.load(getClass().getResource("USERInterface.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show(); 
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void Details(MouseEvent event) {
        if (event.getClickCount() == 2 ){
             Parent root = null;
 News n=listViewBasket.getSelectionModel().getSelectedItem();

                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        NewsHolder holder = NewsHolder.getInstance();
                        holder.setNews(n.getId());
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("FXMLCommentaires.fxml"));
                        try {
                            loader.load();
                           
                              } catch (IOException ex) {
                            Logger.getLogger(FootNewsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        FXMLCommentairesController cc = loader.getController();
                        cc.AffichNewsDet2(n);
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
            
        
    }
    }
    
  
}
