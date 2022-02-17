/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entities.Reclamation;
import Entities.Utilisateur;
import Services.IServiceReclamation;
import Utils.MaConnexion;

import java.io.InputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.time.LocalDate.now;

/**
 *
 * @author 21699
 */
public class ServiceReclamation implements IServiceReclamation{

   Connection cnx ;
  
   

    public ServiceReclamation() {
        cnx= MaConnexion.getInstance().getConnection();
    }

    @Override
    public void AddReclamation(Reclamation r) {

        String query = "INSERT INTO `reclamation`(UserRec, IDUser,Objet, Message,Image,`DateAjout`) VALUES (?,?,?,?,?,'"+now()+"')";
        
        // Try catch pour SQL
        try {
           PreparedStatement ajout = cnx.prepareStatement(query);
           
        
          
           ajout.setString(1, r.getUserRec());
           ajout.setInt(2,r.getIDUser());
           ajout.setString(3, r.getObjet());
           ajout.setString(4, r.getMessage());
           
         
           ajout.setString(5,r.getURLImg());
           ajout.executeUpdate();
           System.out.println("Reclamation envoyé");
           
       
       
       } catch (SQLException  e) {
           System.out.println("Reclamation non envoyé");
           System.out.println(e.getMessage());
       }
        
    }
    

    @Override
    public ObservableList<Reclamation> AfficherReclamation() {
        ObservableList<Reclamation>Reclamations = FXCollections.observableArrayList();

        String query = "Select * from `reclamation`";
        try  {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);

            while(rst.next()) {
                Reclamation R= new Reclamation();
                R.setIDRec(rst.getInt("IDRec")); // colonne
                R.setIDUser(rst.getInt("IDUser"));
                R.setUserRec(rst.getString("UserRec"));
                R.setObjet(rst.getString("Objet"));
                R.setMessage(rst.getString("Message"));
                
                InputStream is = rst.getBinaryStream("Image");
         
                R.setDateAjout(rst.getDate("DateAjout"));

                Reclamations.add(R);
            }


        } catch(Exception e){
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,e);
        }
        return Reclamations;
    }
    
    
    @Override
    public Reclamation AfficherRecDetails(int id) {
    
      String query = "SELECT * from reclamation WHERE IDRec="+id+"";
        
        Reclamation r = new Reclamation();
       try {
           Statement stm = cnx.createStatement();
           ResultSet rst = stm.executeQuery(query);
           while(rst.next()) {
           r.setIDRec(rst.getInt("IDRec"));
           r.setIDUser(rst.getInt("IDUser"));
           r.setUserRec(rst.getString("UserRec"));
           r.setObjet(rst.getString("Objet"));
           r.setMessage(rst.getString("Message"));
           r.setDateAjout(rst.getDate("DateAjout"));
           r.setURLImg(rst.getString("Image"));
           
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
       }
            
           return r; 
        
    }

    @Override
    public void ModifierReclamation(Reclamation r) {
        
        String query = "UPDATE reclamation SET Objet ='" +r.getObjet()+"',Message = '"+r.getMessage()+"' WHERE IDrec =" +r.getIDRec()+"";
        try {

            Statement stm = cnx.createStatement();
            stm.executeUpdate(query);

        } catch(SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void SupprimerReclamation(Reclamation r) {
        String query="Delete FROM reclamation WHERE IDRec="+r.getIDRec()+"";
        try {

            Statement stm = cnx.createStatement();
            stm.executeUpdate(query);

        } catch(SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public Utilisateur InfoReclameur(int IDrec) {
        Utilisateur U = new Utilisateur();
      
        String query = "Select * from utilisateur u inner join reclamation r on r.IDUser = u.ID WHERE r.IDRec =" +IDrec+"";
        
        
        try  {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);

           
                 while(rst.next()) {
                     
                U.setId(rst.getInt("ID"));
                U.setUsername(rst.getString("Username"));
                U.setEmail(rst.getString("Email"));
                U.setNom(rst.getString("Nom"));
                
                U.setAge(rst.getInt("Age"));
                U.setSexe(rst.getString("Sexe"));
                U.setNumTel(rst.getInt("NumTel"));
                U.setDateCreation(rst.getDate("DateCreation"));
                U.setURLImg(rst.getString("Image"));

                 }
            


        } catch(Exception e){
                Logger.getLogger(ServiceFriend.class.getName()).log(Level.SEVERE,null,e);
        }
    
        return U ;
    }
    
}
