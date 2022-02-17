/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Terrain;

import Entities.Terrain;
import Service.ServiceTerrain;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class ModifTerrainController implements Initializable {

    @FXML
    private TextField tfNomt;
    @FXML
    private TextField tfAdr;
    @FXML
    private ComboBox<String> TypeSport;
    @FXML
    private Button SaveButton;
    @FXML
    private Label tfidedit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // insertion des sports dans combox 
              ObservableList<String> list =FXCollections.observableArrayList
        ("TENNIS","BASKETBALL","FOOTBALL","VOLLEYBALL","BASEBALL","RUGBY","HANDBALL");
        
        TypeSport.setItems(list);
             //
        // TODO
    }    
    
    
    public void DetailTerrain(Terrain t) {
        ServiceTerrain ST = new ServiceTerrain();
        t=ST.DetailTerrain(t.getId());
        
        tfNomt.setText(t.getNomT());
        tfidedit.setText(Integer.toString(t.getId()));
        tfAdr.setText(t.getAdresse());
      //  TypeSport.setSelectionModel(t.getType_sport());
    }
          

    @FXML
    private void ModifOnAction(ActionEvent event) {
         Terrain t = new Terrain();
           ServiceTerrain st= new ServiceTerrain();
          int IDValue=Integer.parseInt(tfidedit.getText());
           t.setId(IDValue);
           
          String type_sport=TypeSport.getSelectionModel().getSelectedItem();
         String nom=tfNomt.getText();
     String adresse=tfAdr.getText();
        
   //  String ressources=tfressources.getText();
      t.setNomT(nom);
      t.setAdresse(adresse);
    //  t.setRessources(ressources);
      t.setType_sport(type_sport);

       st.ModifTerrain(t);
    }
    
}
