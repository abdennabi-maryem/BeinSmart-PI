/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Terrain;

import Entities.Terrain;
import Utils.MaConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class StatController implements Initializable {

   
    @FXML
    private Button btn;
    @FXML
    private Button btn1;
    @FXML
    private BarChart<String, Double> chart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Retour(ActionEvent event) {
 Parent root = null;
        try {
//            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            root = FXMLLoader.load(getClass().getResource("GestionTerrains.fxml"));
//root = FXMLLoader.load(getClass().getResource("USERInterface.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show(); 
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void count(){ 
        try {
       Terrain t=new Terrain();
       
        // String rqt=  "SELECT nomT,COUNT(nomT) FROM terrain";
        /* String rqt="SELECT DISTINCT nomT,\n" +
"  COUNT(nomT) AS count,\n" +
"  FROM terrain\n" +
"  GROUP BY nomT";*/
        String rqt="SELECT nomT,COUNT(*) FROM terrain GROUP BY nomT";
                      PreparedStatement pst = MaConnexion.getInstance().getConnection().prepareStatement(rqt);

            ResultSet rs =  pst.executeQuery(rqt);
            rs.next();
         int count =rs.getInt(1);
            String req="INSERT INTO `terrain``count` VALUES " +rqt;
         // String req="INSERT INTO `terrain``count` VALUES " +count;
         ResultSet rst=pst.executeQuery(req);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
}   
    
    @FXML
    private void afficherchart(ActionEvent event) {
          
        try {
                        Terrain t=new Terrain();

          //  String requete="SELECT DISTINCT nomT, COUNT(nomT) AS count, FROM terrain GROUP BY nomT
          
          
          String requete="INSERT INTO countterrain(count)VALUES((SELECT COUNT(DISTINCT nomT) FROM terrain))";
          
          
          //String req="INSERT INTO `terrain``count` VALUES " +requete;
            XYChart.Series<String,Double> series=new XYChart.Series<>();
            
            //execute querry and store it in resulttest
            PreparedStatement pst = MaConnexion.getInstance().getConnection().prepareStatement(requete);
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                
                
                series.getData().add(new XYChart.Data<>(rs.getString("nomT"),rs.getDouble("count")));
               
                chart.getData().add(series);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
