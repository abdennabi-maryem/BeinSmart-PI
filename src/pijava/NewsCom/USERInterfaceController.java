/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.NewsCom;

import Entities.News;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author guest
 */
public class USERInterfaceController implements Initializable {

    @FXML
    private JFXButton btnFoot;
    @FXML
    private JFXButton btnVoley;
    @FXML
    private JFXButton btnRugby;
    @FXML
    private JFXButton btnTennis;
    @FXML
    private JFXButton btnBasket;
    @FXML
    private JFXButton btnHand;
 
    @FXML
    private JFXButton btnHand1;
    private TableColumn<News,Integer> ColNbReacts;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

 
    }   


    @FXML
    private void FootNews(ActionEvent event) {
   Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("FootNews.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(USERInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
        
    }
   

    @FXML
    private void TennisNews(ActionEvent event) {
 Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("TennisNews.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(USERInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
        
    }

    @FXML
    private void VolleyNews(ActionEvent event) {
Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("VolleyNews.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(USERInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
                        
    }
    

    @FXML
    private void RugbyNews(ActionEvent event) {
Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("RugbyNews.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(USERInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
    }

    @FXML
    private void BasketNews(ActionEvent event) {
Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("BasketBallNews.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(USERInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
    }

    @FXML
    private void HandNews(ActionEvent event) {
Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("HandNews.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(USERInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
                        
    }

    @FXML
    private void BaseballNews(ActionEvent event) {
Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("BaseBallNews.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(USERInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
    }
        

        
    
     
   
         }
       
         
                 
       
    
        

