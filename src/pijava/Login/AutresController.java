/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Login;

import Utils.UserSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class AutresController implements Initializable {

    @FXML
    private ImageView LogoIMG;
    @FXML
    private ImageView ProfilIMG;
    @FXML
    private Label UsernameHOME;
    @FXML
    private ImageView CoachIMG;
    @FXML
    private ImageView AccueilIMG;
    @FXML
    private ImageView ArbitreIMG;
    @FXML
    private ImageView GymIMG;
    @FXML
    private ImageView TerrainIMG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File Coachfile = new File("image/CoachIcon.png");
        Image CoachIcon = new Image(Coachfile.toURI().toString());
        CoachIMG.setImage(CoachIcon);
        
        File AccueilFile = new File("image/RAccueilIcon.png");
        Image AccueilIcon = new Image(AccueilFile.toURI().toString());
        AccueilIMG.setImage(AccueilIcon);
        
        File UserIconFile = new File("image/UserIcon.png");
        Image UserIcon = new Image(UserIconFile.toURI().toString());
        ProfilIMG.setImage(UserIcon);
        
        File TerrainFile = new File("image/TerrainIcon.png");
        Image TerrainIcon = new Image(TerrainFile.toURI().toString());
        TerrainIMG.setImage(TerrainIcon);
        
        File GymFile = new File("image/GymIcon.png");
        Image GymIcon = new Image(GymFile.toURI().toString());
        GymIMG.setImage(GymIcon);
        
        File ArbitreFile = new File("image/ArbitreIcon.png");
        Image ArbitreIcon = new Image(ArbitreFile.toURI().toString());
        ArbitreIMG.setImage(ArbitreIcon);
        
         File LogoFile = new File("image/logo.png");
        Image LogoIcon = new Image(LogoFile.toURI().toString());
        LogoIMG.setImage(LogoIcon);
        
       
        UsernameHOME.setText(UserSession.getUsername());
        
    }    

    @FXML
    private void CoachClick(MouseEvent event) {
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
    loader.setLocation(getClass().getResource("/pijava/CoachFront/AccueilCoach.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AutresController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
      
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    private void AccueilClick(MouseEvent event) {
          Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("Accueil.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AutresController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
      
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @FXML
    private void TerrainClick(MouseEvent event) {
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("/pijava/Terrain/AfficherTerrainFront.fxml"));
        try {
        loader.load();

        } catch (IOException ex) {
        Logger.getLogger(AutresController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("failed to load");
        System.out.println(ex);
        }
      
        Parent parent = loader.getRoot();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    
}
