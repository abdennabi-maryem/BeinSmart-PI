/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.CoachBack;

import Entities.Coach;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import Service.ServiceCoach;
import Service.ServiceUtilisateur;
import java.awt.image.BufferedImage;
import java.text.Format;
import java.text.SimpleDateFormat;
import javafx.fxml.FXML;
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
public class ResumeCoachController implements Initializable {

    @FXML
    private ImageView ProfilIMG;
    @FXML
    private Label UserLabel;
    @FXML
    private Label ContactLabel;
    @FXML
    private Label DateLabel;
    @FXML
    private Label NomLabel;
    @FXML
    private Label SAgeLabel;
    @FXML
    private Label FiliereLabel;
    @FXML
    private Label ExpLabel;
    @FXML
    private ImageView ProofIMG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void ResumeCoach(Coach c) {
        
        ServiceCoach SC = new ServiceCoach();
        
        c = SC.AfficherDetailsCoach(c.getIDC());
        
        UserLabel.setText(c.getUsername());
        ContactLabel.setText(Integer.toString(c.getNumTel()) + "\n" + c.getEmail() + "\n" +c.getRegion() ); // Label contient Num Tel , Email , et Region
        
         Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String s = formatter.format(c.getDateCreation());
        DateLabel.setText("Membre depuis: "+s);
        
       NomLabel.setText(c.getNom());
       SAgeLabel.setText(Integer.toString(c.getAge())  +" Ans," +c.getSexe());   // Label contient le sexe et l'age 
       FiliereLabel.setText("Sport : " +c.getFiliere());
       ExpLabel.setText("Experience : "+Integer.toString(c.getAnExp()));
       
       
       // PHOTO DE PROFIL 
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
        
        ProfilIMG.setImage(wr);
       
       //
       
       
       // PHOTO CERTIFICAT 
       String pathProof = c.getProof();
        
        BufferedImage BfImgProof = null;
        try {
           URL urlp = new URL(pathProof);
            BfImgProof = ImageIO.read(urlp);
            
        } catch (Exception ex) {
         
           System.out.println("Failed to load image");
           System.out.println(ex);
        }
        WritableImage wrp = null;
        if (BfImgProof != null) {
            wrp = new WritableImage(BfImgProof.getWidth(), BfImgProof.getHeight());
            PixelWriter pw = wrp.getPixelWriter();
            for (int x = 0; x < BfImgProof.getWidth(); x++) {
                for (int y = 0; y < BfImgProof.getHeight(); y++) {
                    pw.setArgb(x, y, BfImgProof.getRGB(x, y));
                }
            }
        }
        
        ProofIMG.setImage(wrp);
       
       //
       
        
    }
}
