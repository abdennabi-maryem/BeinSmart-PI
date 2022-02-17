/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Inscription;

import Entities.Utilisateur;
import Service.ServiceUtilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 21699
 */
public class InscriptionController implements Initializable {
    
    @FXML
    private TextField tfUsername ;
    @FXML
    private PasswordField pfPw;
    @FXML
    private TextField  tfEmail;
    @FXML
    private Button registerButton;
    @FXML
    private Label CnxLabel;
    @FXML
    private Label MailLabel;
    @FXML
    private Label UserLabel;
    @FXML
    private Label PwLabel;
    @FXML
    private ImageView LogoImageView;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfAge;
    @FXML
    private ComboBox<String> Sexe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File LogoFile = new File("image/logo.png");
        Image LogoImage = new Image(LogoFile.toURI().toString());
        LogoImageView.setImage(LogoImage);
        Sinscrire();
    }


    // Lecture du formulaire et ajout de l'utilisateur
    
    public void Sinscrire(){
        
        
        
        ObservableList<String> list =FXCollections.observableArrayList
        ("Homme","Femme");
        
        Sexe.setItems(list);
        
          
        
        registerButton.setOnAction((ActionEvent event)-> {
            
        ServiceUtilisateur su = new ServiceUtilisateur();
        Utilisateur u = new Utilisateur();
        
        String UserSaisi = tfUsername.getText();
        String PassSaisi = pfPw.getText();
        String EmailSaisi = tfEmail.getText();
        String NomSaisi = tfNom.getText();
        int AgeSaisi = Integer.parseInt(tfAge.getText());
        int NumSaisi = Integer.parseInt(tfNum.getText());
        
        
        int err = 0 ; //compteur d'erreur
        // controle de saisie sur les infos inscription
        Boolean MailConf = ControlEmail(EmailSaisi);
        
       if (UserSaisi.length()==0) {
           UserLabel.setText("Veuillez saisir un nom d'utilisateur");
          err++;
       }
       else {
           if (su.ValidateUsername(UserSaisi)==false) {
            UserLabel.setText("Nom d'utilisateur existe");
            err++;
           }
       }
       
         
                //controle de mot de passe 
        if (PassSaisi.length()<6) {
            PwLabel.setText("Mot de passe trop court");
            err++;
        }        

        
                // controle de l'email 
                
        //Controle de saisie de l'email (avec @ etc )        
        if (MailConf == false) {
            MailLabel.setText("Veuillez verifier votre mail");
            err++;
        }
        else  {
            
            //verifier si l'email existe deja 
            if (su.ValidateEmail(EmailSaisi)== false) {
                
            MailLabel.setText("Email existe deja");
            err++;
            }
            
           
        }
        if (err > 0) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Inscription");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez verifier les champs");

                alert.showAndWait();
                
               
        }
        else {
            
        
        //On recupere les données saisies
            u.setUsername(UserSaisi);
            u.setPassword(PassSaisi);
            u.setEmail(EmailSaisi);
            u.setNom(NomSaisi);
            u.setAge(AgeSaisi);
            u.setNumTel(NumSaisi);
            u.setSexe(Sexe.getSelectionModel().getSelectedItem().toString());
        // ajout de l'utilisateur
            su.AddUser(u);
            
            
            Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/Login/Login.fxml"));
        try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
        }
    });
    }
    // control de saisi de l'email 
    public boolean ControlEmail(String mail) {
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
    Pattern pattern = Pattern.compile(masque);
    Matcher controler = pattern.matcher(mail);
    if (controler.matches()){
        return true ; 
    }
    else 
        return false ;
        
    }
   

    @FXML
    private void CnxClick(MouseEvent event) {
         
           Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/Login/Login.fxml"));
        try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }
}
