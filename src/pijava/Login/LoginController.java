/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Login;

import Entities.Utilisateur;
import Service.ServiceUtilisateur;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Utils.UserSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pijava.Login.Password.ForgotPasswordController;
/**
 * FXML Controller class
 *
 * @author 21699
 */
public class LoginController implements Initializable {

    @FXML
    private ImageView LogoImageView;
    @FXML
    private ImageView LockImageView;
    @FXML
    private TextField tfUsername;
    @FXML
    private Button LoginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private Label ForgotpwLabel;
    @FXML
    private PasswordField pfPw;
    @FXML
    private Label InscriLabel;

    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File LogoFile = new File("image/logo.png");
        Image LogoImage = new Image(LogoFile.toURI().toString());
        LogoImageView.setImage(LogoImage);

        File LockFile = new File("image/bluelock.png");
        Image LockImage = new Image(LockFile.toURI().toString());
        LockImageView.setImage(LockImage);
        
    }


    @FXML
    public void loginButtonOnAction(ActionEvent event){

        ServiceUtilisateur su = new ServiceUtilisateur();
        
       
        
        String user = tfUsername.getText();
        String pass = pfPw.getText();
        
       
        
        //
        if (user.length()==0 || pass.length()==0) {
        System.out.println("Veuillez saisir vos informations");
    }
        else
        {
            boolean exist = su.ValidateLogin(user,pass);
            if (exist==false) {
                loginMessageLabel.setText("Veuillez verifier les champs");
                
                // recursivité
                loginButtonOnAction(event);
            }
            else {
           
                // recuperer les infos du user
                
                 //user session info 
                 
                 Utilisateur u = su.SessionDetails(user);
        
            
               UserSession US = UserSession.getInstance(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getNom(),u.getAge(),u.getSexe(),u.getAuth(),u.getURLImg(),u.getNumTel(),u.getNotif());
                System.out.println("bienvenue");
               
               
                // redirection vers la page d'accueil 
                
                 Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("Accueil.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
                    
}
        }
        

    }

    @FXML
    private void ForgotPwClick(MouseEvent event) {
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("Password/ForgotPassword.fxml"));
        try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    ForgotPasswordController FPC = loader.getController();
                    
                    
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
                    
    }

    @FXML
    private void InscriClick(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/Inscription/Inscription.fxml"));
        try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }
}
