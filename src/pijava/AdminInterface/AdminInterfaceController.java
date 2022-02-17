/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.AdminInterface;

import Utils.UserSession;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author 21699
 */
public class AdminInterfaceController implements Initializable {

    @FXML
    private Label UsernameADMIN;
    @FXML
    private ImageView ProfilIMG;
    @FXML
    private ImageView MatchIMG;
    @FXML
    private ImageView UserIMG;
    @FXML
    private ImageView NewsIMG;
    @FXML
    private ImageView EventIMG;
    @FXML
    private ImageView RecIMG;
    @FXML
    private ImageView TerrainIMG;
    @FXML
    private ImageView CoachIMG;
    @FXML
    private ImageView ArbitreIMG;
    @FXML
    private ImageView GymIMG;
    @FXML
    private ImageView RetourIMG;
    @FXML
    private ImageView DecoIMG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UsernameADMIN.setText(UserSession.getUsername());
        
        File UserIconFile = new File("image/UserIcon.png");
        Image UserIcon = new Image(UserIconFile.toURI().toString());
        ProfilIMG.setImage(UserIcon);
        
        File MatchFile = new File("image/MatchTXT.png");
        Image MatchIcon = new Image(MatchFile.toURI().toString());
        MatchIMG.setImage(MatchIcon);
        
       
        UserIMG.setImage(UserIcon);
        
         File NewsFile = new File("image/NewsTXT.png");
        Image NewsIcon = new Image(NewsFile.toURI().toString());
        NewsIMG.setImage(NewsIcon);
        
         File EventFile = new File("image/EventTXT.png");
        Image EventIcon = new Image(EventFile.toURI().toString());
        EventIMG.setImage(EventIcon);
        
        File RecFile = new File("image/RecTXT.png");
        Image RecIcon = new Image(RecFile.toURI().toString());
        RecIMG.setImage(RecIcon);
        
        File TerrainFile = new File("image/Terrain.png");
        Image TerrainIcon = new Image(TerrainFile.toURI().toString());
        TerrainIMG.setImage(TerrainIcon);
        
        File CoachFile = new File("image/CoachIcon.png");
        Image CoachIcon = new Image(CoachFile.toURI().toString());
        CoachIMG.setImage(CoachIcon);
        
        File ArbitreFile = new File("image/ArbitreIcon.png");
        Image ArbitreIcon = new Image(ArbitreFile.toURI().toString());
        ArbitreIMG.setImage(ArbitreIcon);
        
        File GymFile = new File("image/GymIcon.png");
        Image GymIcon = new Image(GymFile.toURI().toString());
        GymIMG.setImage(GymIcon);
        
        File RetourFile = new File("image/Go-back-icon.png");
        Image BackIcon = new Image(RetourFile.toURI().toString());
        RetourIMG.setImage(BackIcon);
        
        File DecoFile = new File("image/deconnexion.png");
        Image DecoIcon = new Image(DecoFile.toURI().toString());
        DecoIMG.setImage(DecoIcon);
        
    }    

    @FXML
    private void BackHomeOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/Login/Accueil.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void LogOutOnAction(ActionEvent event) {
         // clear user info 
        
        UserSession US =  UserSession.getInstance(UserSession.getID(),UserSession.getUsername(),UserSession.getPassword(),UserSession.getEmail(),UserSession.getNom(),UserSession.getAge(),UserSession.getSexe(),UserSession.getAuth(),UserSession.getURLImg(),UserSession.getNumTel(),UserSession.getNotif());
           
        US.cleanUserSession();
        
        // redirection vers accueil
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/Login/Login.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
       
        
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
        
    }

    @FXML
    private void UserControlOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/AdminUser/BackUserList.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void RecControlOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/AdminReclamation/BackReclamation.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void DashboardOnAction(ActionEvent event) {
            // direction interface admin 
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("AdminInterface.fxml"));
        try {
        loader.load();


        } catch (IOException ex) {
        Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    private void CoachControlOnAction(ActionEvent event) {
         Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/CoachBack/BackMenuCoach.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void NewsControlOnAction(ActionEvent event) {
        Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/NewsCom/FXMLNews0.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    @FXML
    private void TerrControlOnAction(ActionEvent event) {
        Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/Terrain/Terrain.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
        
    }
    }
    

