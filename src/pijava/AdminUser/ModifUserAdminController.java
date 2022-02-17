/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.AdminUser;


import Entities.Utilisateur;

import Service.ServiceUtilisateur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class ModifUserAdminController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button SaveButton;
    @FXML
    private Label IdLabel;
  
    @FXML
    private TextField tfNom;
    private Button FermerButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void AffichUserDet(Utilisateur u){
        ServiceUtilisateur SU = new ServiceUtilisateur();
        u = SU.AfficherUserDetails(u.getId());
        IdLabel.setText(Integer.toString(u.getId()));
        tfUsername.setText(u.getUsername());
        tfEmail.setText(u.getEmail());
        tfNom.setText(u.getNom());
        
        
      
       
        
        
        
        
    }

    @FXML
    private void ModifOnAction(ActionEvent event) {
        
         
        ServiceUtilisateur SU = new ServiceUtilisateur();
        Utilisateur u = new Utilisateur();
        u.setId(Integer.parseInt(IdLabel.getText()));
        u.setUsername(tfUsername.getText());
        u.setEmail(tfEmail.getText());
        u.setNom(tfNom.getText());
    
       // u.setURLImg("");
        
           
 
        SU.ModifierUser(u);
    }
    
}
  
  
