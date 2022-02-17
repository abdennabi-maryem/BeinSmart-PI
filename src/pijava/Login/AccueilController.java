/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Login;

import Service.ServiceUtilisateur;
import Utils.UserSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author 21699
 */
public class AccueilController implements Initializable {

    @FXML
    private Button AdminButton;
    @FXML
    private ImageView LogOutIMG;
    @FXML
    private ImageView ProfilIMG;
    @FXML
    private Label UsernameHOME;
    @FXML
    private ImageView MatchIMG;
    @FXML
    private ImageView EventIMG;
    @FXML
    private ImageView NewsIMG;
    @FXML
    private ImageView RecIMG;
    @FXML
    private ImageView AutresIMG;
    @FXML
    private ImageView LogoIMG;
    @FXML
    private Button ModifProfilButton;
    @FXML
    private Button FindButton;
    @FXML
    private Label AmisButton;
    @FXML
    private ImageView SettingsIMG;
    @FXML
    private ImageView FindIMG;

    ServiceUtilisateur SU = new ServiceUtilisateur();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Image du logo 
        File LogoFile = new File("image/logo.png");
        Image LogoIcon = new Image(LogoFile.toURI().toString());
        LogoIMG.setImage(LogoIcon);
        
        // Image de profil 
        File UserIconFile = new File("image/UserIcon.png");
        Image UserIcon = new Image(UserIconFile.toURI().toString());
        ProfilIMG.setImage(UserIcon);
        
        // Image de match 
        File MatchIconFile = new File("image/MatchTXT.png");
        Image MatchIcon = new Image(MatchIconFile.toURI().toString());
        MatchIMG.setImage(MatchIcon);
        
        // Image de news 
        File NewsIconFile = new File("image/NewsTXT.png");
        Image NewsIcon = new Image(NewsIconFile.toURI().toString());
        NewsIMG.setImage(NewsIcon);
        
        // Image de evenement 
        
        File EventIconFile = new File("image/EventTXT.png");
        Image EventIcon = new Image(EventIconFile.toURI().toString());
        EventIMG.setImage(EventIcon);
        
        // Image de reclamation 
        
        File RecIconFile = new File("image/RecTXT.png");
        Image RecIcon = new Image(RecIconFile.toURI().toString());
        RecIMG.setImage(RecIcon);
        
        // Image de autres 
        File AutresIconFile = new File("image/AutresTXT.png");
        Image AutresIcon = new Image(AutresIconFile.toURI().toString());
        AutresIMG.setImage(AutresIcon);
        
        // Image de deconnexion 
        File LogOutIconFile = new File("image/DecoTXT.png");
        Image LogOutIcon = new Image(LogOutIconFile.toURI().toString());
        LogOutIMG.setImage(LogOutIcon);
        
        // Image settings
         File SettingsFile = new File("image/settings-32.png");
        Image SettingsIcon = new Image(SettingsFile.toURI().toString());
        SettingsIMG.setImage(SettingsIcon);
        
        // Image recherche 
         File FindFile = new File("image/search-12-64.png");
        Image FindIcon = new Image(FindFile.toURI().toString());
        FindIMG.setImage(FindIcon);
        
        
        //Username 
        UsernameHOME.setText(UserSession.getUsername());
        
        if (UserSession.getAuth() == 0 ) {
            AdminButton.setVisible(false);
        }
        
        
        // NOTIFICATION  COACH 
        
        // ACCEPTE 
        System.out.println(UserSession.getNotif());
        if (UserSession.getNotif() == 1) {
            // notif accepté 
            Notifications notificationBuilder = Notifications.create()
                    .title("Candidature")
                    .text("Felicitation ! Votre candidature a été accepté")
                    .graphic(null)
                    .hideAfter(Duration.hours(10000))
                    .hideCloseButton()
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            SU.Notification(UserSession.getID(),0);  // on remet valeur notification à 0 
                           int ID = UserSession.getID();
                           String  Username = UserSession.getUsername();    
                           String password = UserSession.getPassword();
                           String Email =  UserSession.getEmail();
                           String Nom = UserSession.getNom();
                           int Age = UserSession.getAge();
                           String Sexe = UserSession.getSexe();
                           int Auth = UserSession.getAuth();
                           int NumTel = UserSession.getNumTel();
                           String UrlImg = UserSession.getURLImg();
                           
                            UserSession US =  UserSession.getInstance(UserSession.getID(),UserSession.getUsername(),UserSession.getPassword(),UserSession.getEmail(),UserSession.getNom(),UserSession.getAge(),UserSession.getSexe(),UserSession.getAuth(),UserSession.getURLImg(),UserSession.getNumTel(),UserSession.getNotif());
                             US.cleanUserSession();
                                     
                           UserSession US2 = UserSession.getInstance(ID, Username, password, Email, Nom, Age, Sexe, Auth, UrlImg,NumTel, 0);
                        }
                    });
            notificationBuilder.show();
        }
        else if (UserSession.getNotif() == 2) {
            // notif refusé 
             Notifications notificationBuilder = Notifications.create()
                    .title("Candidature")
                    .text("Desolé ! Votre candidature a été refusé")
                    .graphic(null)
                    .hideAfter(Duration.hours(10000))
                    .hideCloseButton()
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            SU.Notification(UserSession.getID(),0);
                            
                            int ID = UserSession.getID();
                           String  Username = UserSession.getUsername();    
                           String password = UserSession.getPassword();
                           String Email =  UserSession.getEmail();
                           String Nom = UserSession.getNom();
                           int Age = UserSession.getAge();
                           String Sexe = UserSession.getSexe();
                           int Auth = UserSession.getAuth();
                           int NumTel = UserSession.getNumTel();
                           String UrlImg = UserSession.getURLImg();
                           
                           UserSession US =  UserSession.getInstance(UserSession.getID(),UserSession.getUsername(),UserSession.getPassword(),UserSession.getEmail(),UserSession.getNom(),UserSession.getAge(),UserSession.getSexe(),UserSession.getAuth(),UserSession.getURLImg(),UserSession.getNumTel(),UserSession.getNotif());
                             US.cleanUserSession();
                                     
                           UserSession US2 = UserSession.getInstance(ID, Username, password, Email, Nom, Age, Sexe, Auth, UrlImg,NumTel, 0);
                        }
                    });
            notificationBuilder.show();
        }
        
    }    
            @FXML
        private void AdminButtonOnAction(ActionEvent event) {
            
            // verifier si c'est un admin 
            ServiceUtilisateur SU = new ServiceUtilisateur();
            int UserAuth = UserSession.getAuth();
            
            if (UserAuth ==0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Espace Admin");
                alert.setHeaderText("Acces Interdit");
                alert.setContentText("Desolé , cet espace est reservé aux admins");

                alert.showAndWait();
            }
            
            else {
                
            
            
            
            // direction interface admin 
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/AdminInterface/AdminInterface.fxml"));
        try {
        loader.load();


        } catch (IOException ex) {
        Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
            }
        }

        @FXML
        private void LogOutClick(MouseEvent event) {
            
        // clear user info 
        
  UserSession US =  UserSession.getInstance(UserSession.getID(),UserSession.getUsername(),UserSession.getPassword(),UserSession.getEmail(),UserSession.getNom(),UserSession.getAge(),UserSession.getSexe(),UserSession.getAuth(),UserSession.getURLImg(),UserSession.getNumTel(),UserSession.getNotif());
           
        US.cleanUserSession();
        
        // redirection vers accueil
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("Login.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
       // LoginController LC = loader.getController();
       
        
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();

        }

    @FXML
    private void ModifProfilOnClick(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("ModifierProfil.fxml"));
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

    @FXML
    private void RecImgClick(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/UserReclamation/FrontReclamation.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
      
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    private void FindButtonOnClick(ActionEvent event) {
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/UsersFront/UsersList.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
      
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    private void AmisClicked(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/pijava/Friends/Amis.fxml"));
                        try {
                            loader.load();
                           
                              } catch (IOException ex) {
                            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
        
    }

    @FXML
    private void AutresImgOnClick(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("Autres.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
      
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    private void NewsIMGClick(MouseEvent event) {
        
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/NewsCom/USERInterface.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
      
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }


    
    
}
