/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Coach;
import Services.IServiceCoach;
import Utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author 21699
 */
public class ServiceCoach implements IServiceCoach {
    
        Connection cnx ;

    public ServiceCoach() {
        cnx= MaConnexion.getInstance().getConnection();
    }

    @Override
    public void AddCoach(Coach c) {
         String query = "INSERT INTO `coach`(`IDUser`, `filiere`,`AnExp`,`Region`,`Proof`) VALUES ('" + c.getIDUser() +"','" + c.getFiliere() +"','"+c.getAnExp()+"','"+c.getRegion()+"','"+c.getProof()+"')"; 
       try {

            Statement stm = cnx.createStatement();

            stm.executeUpdate(query);
            System.out.println("Coach ajouté");
                 

        } catch(SQLException ex) {
            System.out.println("ajout echoué " + ex.getMessage());

        }
        
    }

    @Override
    public void ModifierCoach(Coach c) {
          
    }

    @Override
    public void SupprimerCoach(Coach c) {
         String query="Delete FROM coach WHERE IDC="+c.getIDC()+"";
        try {

            Statement stm = cnx.createStatement();
            stm.executeUpdate(query);

        } catch(SQLException ex) {
           
            System.out.println(ex);
        }
    }

    @Override
    public ObservableList<Coach> AfficherListCoach() {
          ObservableList<Coach>Coachs = FXCollections.observableArrayList();

         String query = "Select * from coach LEFT JOIN utilisateur ON coach.IDUser=utilisateur.ID WHERE coach.Confirmed = 1   UNION  Select * from coach RIGHT JOIN utilisateur ON coach.IDUser=utilisateur.ID WHERE coach.Confirmed = 1";
        
        try  {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);

            while(rst.next()) {
                
                  Coach C = new Coach();
               C.setIDC(rst.getInt("IDC"));
               
               C.setIDUser(rst.getInt("IDUser"));
               C.setFiliere(rst.getString("Filiere"));
               C.setAnExp(rst.getInt("AnExp"));
               C.setRegion(rst.getString("Region"));
               C.setProof(rst.getString("Proof"));
               C.setConfirmed(rst.getInt("Confirmed"));
               
                    C.setId(rst.getInt("ID"));
                    C.setUsername(rst.getString("Username"));
                    C.setEmail(rst.getString("Email"));
                    C.setNom(rst.getString("Nom"));
                    C.setNumTel(rst.getInt("NumTel"));
                    C.setAge(rst.getInt("Age"));
                    C.setSexe(rst.getString("Sexe"));
                    C.setDateCreation(rst.getDate("DateCreation"));
                    C.setURLImg(rst.getString("Image"));
               
               
                Coachs.add(C);
            }


        } catch(Exception e){
                Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE,null,e);
        }
        return Coachs ;
    }

    @Override
    public ObservableList<Coach> AfficherDemande() {
        ObservableList<Coach>Coachs = FXCollections.observableArrayList();

        String query = "Select * from coach LEFT JOIN utilisateur ON coach.IDUser=utilisateur.ID WHERE coach.Confirmed = 0   UNION  Select * from coach RIGHT JOIN utilisateur ON coach.IDUser=utilisateur.ID WHERE coach.Confirmed = 0";
        
        try  {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);

            while(rst.next()) {
                
                Coach C = new Coach();
               C.setIDC(rst.getInt("IDC"));
               
               C.setIDUser(rst.getInt("IDUser"));
               C.setFiliere(rst.getString("Filiere"));
               C.setAnExp(rst.getInt("AnExp"));
               C.setRegion(rst.getString("Region"));
               C.setProof(rst.getString("Proof"));
               C.setConfirmed(rst.getInt("Confirmed"));
               
                    C.setId(rst.getInt("ID"));
                    C.setUsername(rst.getString("Username"));
                    C.setEmail(rst.getString("Email"));
                    C.setNom(rst.getString("Nom"));
                     C.setNumTel(rst.getInt("NumTel"));
                    C.setAge(rst.getInt("Age"));
                    C.setSexe(rst.getString("Sexe"));
                    C.setDateCreation(rst.getDate("DateCreation"));
                    C.setURLImg(rst.getString("Image"));
               
               
                Coachs.add(C);
            }


        } catch(Exception e){
                Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE,null,e);
        }
        return Coachs ;
    }

    @Override
    public Coach AfficherDetailsCoach(int IdC) {
        
          String query = "Select * from coach LEFT JOIN utilisateur ON coach.IDUser=utilisateur.ID WHERE coach.IDC  ="+IdC+"  UNION  Select * from coach RIGHT JOIN utilisateur ON coach.IDUser=utilisateur.ID WHERE coach.IDC ="+IdC+"";
        
        Coach c = new Coach();
       try {
           Statement stm = cnx.createStatement();
           ResultSet rst = stm.executeQuery(query);
           while(rst.next()) {
            c.setIDC(rst.getInt("IDC"));
               
               c.setIDUser(rst.getInt("IDUser"));
               c.setFiliere(rst.getString("Filiere"));
               c.setAnExp(rst.getInt("AnExp"));
               c.setRegion(rst.getString("Region"));
               c.setProof(rst.getString("Proof"));
               c.setConfirmed(rst.getInt("Confirmed"));
               
                    c.setId(rst.getInt("ID"));
                    c.setUsername(rst.getString("Username"));
                    c.setEmail(rst.getString("Email"));
                    c.setNom(rst.getString("Nom"));
                    c.setNumTel(rst.getInt("NumTel"));
                    c.setAge(rst.getInt("Age"));
                    c.setSexe(rst.getString("Sexe"));
                    c.setDateCreation(rst.getDate("DateCreation"));
                    c.setURLImg(rst.getString("Image"));
           
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
       }
            
           return c; 
    }

    @Override
    public void AccepterCoach(Coach c) {
        
       
        
        
        String query = "UPDATE coach SET Confirmed ='" +1+"'WHERE  IDC="+c.getIDC()+"";
        
        
         try {
         Statement    stm = cnx.createStatement();
             
            stm.executeUpdate(query);
         
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ajouté");
        
    }
    
}
