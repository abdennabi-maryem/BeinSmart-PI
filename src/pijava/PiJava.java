/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 21699
 */
public class PiJava extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login/Login.fxml"));
       //Parent root = FXMLLoader.load(getClass().getResource("Inscription/Inscription.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("AdminUser/BackUser.fxml"));
       //Parent root = FXMLLoader.load(getClass().getResource("UserReclamation/FrontReclamation.fxml"));
     // Parent root = FXMLLoader.load(getClass().getResource("AdminReclamation/BackReclamation.fxml"));
     //Parent root = FXMLLoader.load(getClass().getResource("Login/Accueil.fxml")); 
    // Parent root = FXMLLoader.load(getClass().getResource("AdminUser/BackUserList.fxml"));
    
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
