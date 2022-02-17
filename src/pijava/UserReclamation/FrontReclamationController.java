/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.UserReclamation;

import Entities.Reclamation;
import Service.ServiceReclamation;
import Utils.UserSession;
import java.awt.Desktop;
import java.io.File;
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
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;




/**
 * FXML Controller class
 *
 * @author 21699
 */
public class FrontReclamationController implements Initializable {

    @FXML
    private TextField tfObjet;
    @FXML
    private TextField tfMsg;
    @FXML
    private Button EnvoiButton;
    @FXML
    private Label ConfirmLabel;
    @FXML
    private Button imgButton;
    @FXML
    private TextArea ImgPath;

    File file ;
    private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Button AnnulButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Reclamer();
    } 

    
    
    private void Reclamer() 
    {
        ServiceReclamation SR = new ServiceReclamation();
        Reclamation r = new Reclamation();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
      
        imgButton.setOnAction((ActionEvent event) -> {
            file = fileChooser.showOpenDialog(imgButton.getScene().getWindow());
            String path = file.getAbsolutePath();
            ImgPath.setText(path);
        //   String From  = path ;
           
            path = path.substring(21,path.length());
            
          //  String To = "C:\\wamp64\\www\\PiJava\\" + path;
            
            
            path = "http://localhost/PiJava/" + path ;
            
            r.setURLImg(path);
        });
            //Action sur Boutton annuler 
             AnnulButton.setOnAction((ActionEvent e) -> {
                 
             
             // redirection vers la page d'accueil
             
             Node node = (Node) e.getSource();
             Stage stage = (Stage) node.getScene().getWindow();
             FXMLLoader loader = new FXMLLoader ();
             loader.setLocation(getClass().getResource("/pijava/Login/Accueil.fxml"));
             try {
                 loader.load();
                 
                 
             } catch (IOException ex) {
                 Logger.getLogger(FrontReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println("failed to load");
                 System.out.println(ex); 
             }
             Parent parent = loader.getRoot();
             stage.setScene(new Scene(parent));
             stage.show();
             
             
        });
        
        
            // Action sur boutton Envoyer 
         EnvoiButton.setOnAction((ActionEvent event) -> {
              String Obj = tfObjet.getText();
        String Msg = tfMsg.getText();
        
        if (Obj.length()==0 || Msg.length()==0) 
        {
            Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Alerte");
                alert.setHeaderText("");
                alert.setContentText("Veuillez remplir les champs ");

                alert.showAndWait();
        }
        else {
            
        r.setIDUser(UserSession.getID());
         r.setUserRec(UserSession.getUsername());
        r.setObjet(Obj);
        r.setMessage(Msg);
             SR.AddReclamation(r);
             // redirection vers la page d'accueil
             
             Node node = (Node) event.getSource();
             Stage stage = (Stage) node.getScene().getWindow();
             FXMLLoader loader = new FXMLLoader ();
             loader.setLocation(getClass().getResource("/pijava/Login/Accueil.fxml"));
             try {
                 loader.load();
                 
                 
             } catch (IOException ex) {
                 Logger.getLogger(FrontReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println("failed to load");
                 System.out.println(ex); 
             }
             Parent parent = loader.getRoot();
             stage.setScene(new Scene(parent));
             stage.show();
             
             Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Reclamation");
                alert.setHeaderText(null);
                alert.setContentText("Votre reclamation a été envoyé !");

                alert.showAndWait();
        }
        });
    }
    }



   
