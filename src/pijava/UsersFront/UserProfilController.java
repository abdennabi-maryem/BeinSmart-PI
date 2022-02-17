/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.UsersFront;


import Entities.Utilisateur;
import Service.ServiceUtilisateur;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class UserProfilController implements Initializable {

    @FXML
    private ImageView ProfilIMG;
    @FXML
    private Label UserLabel;
    @FXML
    private Label InfoLabel;
    @FXML
    private Label DateLabel;

    
    Utilisateur u ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
     public void AffichUserProfil(Utilisateur u){
        ServiceUtilisateur SU = new ServiceUtilisateur();
        u = SU.AfficherUserDetails(u.getId());
      
        UserLabel.setText(u.getUsername());
        InfoLabel.setText(u.getNom());
        
        
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String s = formatter.format(u.getDateCreation());
        DateLabel.setText("Membre depuis: "+s);
        
        String path = u.getURLImg();
        
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
        
        ProfilIMG.setImage(wr);
        
    }
}
