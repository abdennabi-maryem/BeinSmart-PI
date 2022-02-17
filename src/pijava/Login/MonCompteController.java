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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author 21699
 */
public class MonCompteController implements Initializable {

    @FXML
    private Button SaveButton;
    @FXML
    private Label IdLabel;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfUser;
    @FXML
    private Label PwLabel;
    @FXML
    private Label MailLabel;

    
    ServiceUtilisateur SU = new ServiceUtilisateur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AffichUserDet();
    }    

    
    public void AffichUserDet(){
        
        
        IdLabel.setText(Integer.toString(UserSession.getID()));
        //Affichage des données 
        tfUser.setText(UserSession.getUsername());
     
        tfNom.setText(UserSession.getNom());
        tfNum.setText(Integer.toString(UserSession.getNumTel()));
        MailLabel.setText(UserSession.getEmail());
        
        // modification 
        
        
        
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
                        Logger.getLogger(MonCompteController.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(MonCompteController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void SaveButtonOnAction(ActionEvent event) {
        
         Utilisateur u = new Utilisateur();
        
         // on recupere l'id
         u.setId(Integer.parseInt(IdLabel.getText()));
         
        // recuperer username 
         u.setUsername(tfUser.getText());
         
         // recuperer nom
        u.setNom(tfNom.getText());
        
        // Tel 
        u.setNumTel(Integer.parseInt(tfNum.getText()));
        
        
           SU.ModifierCompte(u);
           
            int ID = UserSession.getID();
                           String  Username = u.getUsername();    
                           String password = UserSession.getPassword();
                           String Email =  UserSession.getEmail();
                           String Nom = u.getNom();
                           int Age = UserSession.getAge();
                           String Sexe = UserSession.getSexe();
                           int Auth = UserSession.getAuth();
                           int NumTel = u.getNumTel();
                           String UrlImg = UserSession.getURLImg();
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
                        Logger.getLogger(MonCompteController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show();
      
           
        
            System.out.println(u.getNom());
            System.out.println(u.getNumTel());
                           
                           
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
                        Logger.getLogger(MonCompteController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }
    
}
