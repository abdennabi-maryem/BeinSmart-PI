/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.CoachFront;

import Entities.Coach;
import Service.ServiceCoach;
import Utils.UserSession;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import pijava.Login.LoginController;




/**
 * FXML Controller class
 *
 * @author 21699
 */
public class DemandeCoachController implements Initializable {

    @FXML
    private Button EnvoiButton;
    @FXML
    private Label ConfirmLabel;
    @FXML
    private Button imgButton;
    @FXML
    private TextArea ImgPath;
    @FXML
    private Button AnnulButton;
    @FXML
    private Label FiliereLabel;
    @FXML
    private Label ExpLabel;
    @FXML
    private Label NumLabel;
    
    File file ;
    
    @FXML
    private TextField tfFiliere;
    @FXML
    private TextField tfExp;
    private TextField tfNum;
    @FXML
    private TextField regTf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Candidater();
    }    
    
    private void Candidater() {
        ServiceCoach SC = new ServiceCoach();
        Coach c = new Coach();
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
      
        imgButton.setOnAction((ActionEvent event) -> {
            file = fileChooser.showOpenDialog(imgButton.getScene().getWindow());
            String path = file.getAbsolutePath();
            ImgPath.setText(path);
            
            path = path.substring(21,path.length());
            path = "http://localhost/PiJava/" + path ;
            c.setProof(path);
        });
        
        //Action sur Boutton annuler 
             AnnulButton.setOnAction((ActionEvent e) -> {
                 
             
             // redirection vers la page d'accueil coach
             
             Node node = (Node) e.getSource();
             Stage stage = (Stage) node.getScene().getWindow();
             FXMLLoader loader = new FXMLLoader ();
             loader.setLocation(getClass().getResource("AccueilCoach.fxml"));
             try {
                 loader.load();
                 
                 
             } catch (IOException ex) {
                 System.out.println(ex);
                 System.out.println("failed to load");
                 System.out.println(ex); 
             }
             Parent parent = loader.getRoot();
             stage.setScene(new Scene(parent));
             stage.show();
             
             
        });
             
              // Action sur boutton Envoyer 
         EnvoiButton.setOnAction((ActionEvent event) -> {
              String Fil = tfFiliere.getText();    // Filiere
        String Reg = regTf.getText();        // Numero de telephone
        String Exp = tfExp.getText();       // Experience en ANNEE 
        
        if (Fil.length()==0 || Reg.length()==0 || Exp.length()==0) 
        {
            Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Alerte");
                alert.setHeaderText("");
                alert.setContentText("Veuillez remplir les champs ");

                alert.showAndWait();
        }
        else {
            
       
        c.setIDUser(UserSession.getID());
        c.setFiliere(Fil);
        c.setRegion(Reg);
        c.setAnExp(Integer.parseInt(Exp));
             SC.AddCoach(c);
             // redirection vers l'accueil coach
             
             Node node = (Node) event.getSource();
             Stage stage = (Stage) node.getScene().getWindow();
             FXMLLoader loader = new FXMLLoader ();
             loader.setLocation(getClass().getResource("AccueilCoach.fxml"));
             try {
                 loader.load();
                 
                 
             } catch (IOException ex) {
                 Logger.getLogger(DemandeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println("failed to load");
                 System.out.println(ex); 
             }
             Parent parent = loader.getRoot();
             stage.setScene(new Scene(parent));
             stage.show();
             
             Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Candidature");
                alert.setHeaderText(null);
                alert.setContentText("Votre candidature a été envoyé !");

                alert.showAndWait();
        }
        });
        
        
    }
    
}
