/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Terrain;
import Services.ITerrain;
import Utils.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author lenovo
 */
public class ServiceTerrain implements ITerrain{
    Connection cnx;

    public ServiceTerrain() {
                cnx=MaConnexion.getInstance().getConnection();

    }


    @Override
    public void AjoutTerrain(Terrain t) {
try {
            Statement stm =cnx.createStatement();
            String query="INSERT INTO `terrain`( `nomT`, `Adresse`, `type_sport`, `ressources`,`Image`,`NumTel`,`count`)   VALUES ('"+t.getNomT()+"','" +t.getAdresse()+"','" +t.getType_sport()+"','" +t.getRessources()+"','" +t.getURLImg()+"','" +t.getNumTel()+"','" +t.getCount()+"')";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    
    @Override
    public ObservableList<Terrain> AffichTerrain() {
 ObservableList<Terrain> Terrains = FXCollections.observableArrayList();

        try {
            Statement stm =cnx.createStatement();
            String query="SELECT * FROM `terrain`  ";

            ResultSet rst =stm.executeQuery(query);
            while (rst.next())
            {
                Terrain t=new Terrain();
                t.setId(rst.getInt("id"));
                t.setNomT(rst.getString("nomT"));
                t.setAdresse(rst.getString("Adresse"));
                t.setType_sport(rst.getString("type_sport"));
                t.setNumTel(rst.getInt("NumTel"));
                t.setURLImg(rst.getString("Image"));
                t.setRessources(rst.getString("ressources"));
                Terrains.add(t);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
        }
            return Terrains;    }
    
    
    

    @Override
    public void SupprTerrain(Terrain t) {
 try {
                 String query = "DELETE FROM `terrain` WHERE id="+t.getId();
                 PreparedStatement pst = cnx.prepareStatement(query);
                 pst.execute();
             } catch (SQLException ex) {
                 Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
             }     }

    @Override
    public void ModifTerrain(Terrain t) {
try {   
String query ="UPDATE `terrain` SET "
        + "`nomT`='"+t.getNomT()+"',"
                + "`Adresse`='"+t.getAdresse()+"',"
                + "`type_sport`='"+t.getType_sport()+"',"
                + "`NumTel`='"+t.getNumTel()+"',"
                 + "`Image`='"+t.getURLImg()+"',"
                + "`ressources`='"+t.getRessources()+ 
                "'WHERE id="+t.getId();

 PreparedStatement pst = cnx.prepareStatement(query);
               pst.execute();
             } catch (SQLException ex) {
                 Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
             }       }

    @Override
    public Terrain DetailTerrain(int id) {
       String query = "SELECT * from terrain WHERE id="+id+"";
       Terrain t = new Terrain();
        try {
           Statement stm = cnx.createStatement();
           ResultSet rst = stm.executeQuery(query);
           while(rst.next()) {
           t.setId(rst.getInt("id"));
           t.setNomT(rst.getString("nomT"));
           t.setAdresse(rst.getString("Adresse"));
           t.setType_sport(rst.getString("type_sport"));
           t.setRessources(rst.getString("ressources"));
           t.setNumTel(rst.getInt("NumTel"));
           t.setURLImg(rst.getString("Image"));
           
           
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ServiceTerrain.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return t;
    }
    
    
    
    
    
  
 }



