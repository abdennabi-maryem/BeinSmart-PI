/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.AdminReclamation;

import Entities.Reclamation;
import Service.ServiceReclamation;
import java.awt.image.BufferedImage;

import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class RecDetailleController implements Initializable {

   
    @FXML
    private Label ConfirmLabel;
    @FXML
    private Label DateEnvoiLabel;
    
    @FXML
    private ImageView PreuvIMG;
    @FXML
    private Label TaId;
    @FXML
    private Label TaRec;
    @FXML
    private TextArea TaObj;
    @FXML
    private TextArea TaMsg;
    Reclamation r ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
  
     public void AffichRecDet2(Reclamation r){
        ServiceReclamation SR = new ServiceReclamation();
        r = SR.AfficherRecDetails(r.getIDRec());
        
        // details reclameur : 
       String  user = SR.InfoReclameur(r.getIDRec()).getUsername();
       int ID = SR.InfoReclameur(r.getIDRec()).getId();
       
       
        //
        TaId.setText(Integer.toString(r.getIDRec()));
        TaRec.setText(user);
        TaObj.setText(r.getObjet());
        TaMsg.setText(r.getMessage());
        
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String s = formatter.format(r.getDateAjout());
        DateEnvoiLabel.setText("Envoyé le : "+s);
        
        String path = r.getURLImg();
        
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
        
        PreuvIMG.setImage(wr);
        
    }

    @FXML
    private void ModifButtonOnAction(ActionEvent event) {
        ServiceReclamation SR = new ServiceReclamation();
        Reclamation r = new Reclamation();
        r.setIDRec(Integer.parseInt(TaId.getText()));
        r.setObjet(TaObj.getText());
        r.setMessage(TaMsg.getText());
        
        SR.ModifierReclamation(r);
    }
    
}
