/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Login.Password;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class ChangerMDPController implements Initializable {

    @FXML
    private TextField OldPwTf;
    @FXML
    private TextField NewPwTf;
    @FXML
    private TextField CNewPwTf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void CloseButtonOnAction(ActionEvent event) {
    }
    
}
