/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Login.Password;

import Entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import Service.ServiceUtilisateur;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class NewPasswordController implements Initializable {

    @FXML
    private Button SaveButton;
    @FXML
    private Label PassMatchLabel;
    @FXML
    private PasswordField NewPwPf;
    @FXML
    private PasswordField ConfirmPwPf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void Newpw(String Email) {
        ServiceUtilisateur SU = new ServiceUtilisateur();
        
        SaveButton.setOnAction((ActionEvent event)->{
            
        
        if (!NewPwPf.getText().equals(ConfirmPwPf.getText())) {
            PassMatchLabel.setText("les deux mots de passe sont differents");
        }
        else {
            SU.NewPw(Email, NewPwPf.getText());
        }
        });
    }
}
