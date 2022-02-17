/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.NewsCom;

import Entities.News;
import Service.ServiceNews;
import com.jfoenix.controls.JFXTextArea;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author guest
 */
public class DetailsActualitesController implements Initializable {

    @FXML
    private JFXTextArea news;
    @FXML
    private ImageView imagenews;
    @FXML
    private JFXTextArea titre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        news.setEditable(false);

        titre.setEditable(false);


        // TODO
    }    
    public void AffichNewsDet2(News n){
        ServiceNews sn = new ServiceNews();
        n = sn.AfficherNewsDetails(n.getId());
       
        news.setText(n.getContenu());
                titre.setText(n.getTitre());     
        
                 new animatefx.animation.ZoomInUp(news).play();



        
        String path = n.getURLImg();
        
        BufferedImage BfImg = null;
        try {
 
                URL url=new URL(path);
                BfImg=ImageIO.read(url);
     
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
        imagenews.setImage(wr);
      new animatefx.animation.ZoomInUp(imagenews).play();
    
}

    @FXML
    private void Retour(ActionEvent event) {
            Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show(); 
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     
    }
    }

    

