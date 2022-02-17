/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Login;

import Entities.Utilisateur;
import Service.ServiceUtilisateur;
import Utils.UserSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class ModifierProfilController implements Initializable {

    
    @FXML
    private Button SaveButton;
    @FXML
    private Label IdLabel;
  
    @FXML
    private TextField tfAge;
   
    @FXML
    private ImageView ProfilIMG;
    @FXML
    private Button imgButton;
    @FXML
    private Label UrlLabel;

     ServiceUtilisateur SU = new ServiceUtilisateur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AffichUserDet();
    }    
    
    public void AffichUserDet(){
       
        
        
        //Affichage des données 
       IdLabel.setText(Integer.toString(UserSession.getID()));
     
        tfAge.setText(Integer.toString(UserSession.getAge()));
        
         UrlLabel.setText(UserSession.getURLImg());
        
         String path = UserSession.getURLImg();
        
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
      
       
        
        
       // recuperer l'image 
       
       FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
      
        imgButton.setOnAction((ActionEvent event) -> {
        File  file = fileChooser.showOpenDialog(imgButton.getScene().getWindow());
            String Url = file.getAbsolutePath();
            
            
            Url = Url.substring(21,Url.length());
            Url = "http://localhost/PiJava/" + Url ;
           
            UrlLabel.setText(Url);
           
        });
        //
           
        
        
        
    }
    
    @FXML
    private void SaveButtonOnAction(ActionEvent event) {
        
        // modification 
        
         Utilisateur u = new Utilisateur();
        
        // recuperer l'ID 
         u.setId(Integer.parseInt(IdLabel.getText()));
         
         // recuperer l'age 
        u.setAge(Integer.parseInt(tfAge.getText()));
        
        u.setURLImg(UrlLabel.getText());
        
        SU.ModifierProfil(u);
        
         int ID = UserSession.getID();
                           String  Username = UserSession.getUsername();    
                           String password = UserSession.getPassword();
                           String Email =  UserSession.getEmail();
                           String Nom = UserSession.getNom();
                           int Age = u.getAge();
                           String Sexe = UserSession.getSexe();
                           int Auth = UserSession.getAuth();
                           int NumTel = UserSession.getNumTel();
                           String UrlImg = u.getURLImg();
                           int Notif = UserSession.getNotif();
                           
                            UserSession US =  UserSession.getInstance(UserSession.getID(),UserSession.getUsername(),UserSession.getPassword(),UserSession.getEmail(),UserSession.getNom(),UserSession.getAge(),UserSession.getSexe(),UserSession.getAuth(),UserSession.getURLImg(),UserSession.getNumTel(),UserSession.getNotif());
                             US.cleanUserSession();
                                     
                           US = UserSession.getInstance(ID, Username, password, Email, Nom, Age, Sexe, Auth, UrlImg,NumTel,Notif);
        
        //fermeture
        Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("Accueil.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ModifierProfilController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show();
    }

 
    @FXML
    private void CloseButtonOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("Accueil.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ModifierProfilController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void ProfilButtonOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("ModifierProfil.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ModifierProfilController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show();
    }

    @FXML
    private void CompteButtonOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("MonCompte.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ModifierProfilController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    
    
}
