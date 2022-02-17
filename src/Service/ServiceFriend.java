/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Services.IServiceFriend;
import Entities.Friend;
import Entities.Utilisateur;
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
public class ServiceFriend implements IServiceFriend {
    
      Connection cnx ;

    public ServiceFriend() {
        cnx= MaConnexion.getInstance().getConnection();
    }

    
    // Envoyer une demande d'amis
    @Override
    public void Addfriend(Friend F) {
      
         
       String query = "INSERT INTO `amis`(`FriendID`, `IDUser`) VALUES ('" +F.getIDUser() +"','" + F.getFriendID() +"')"; 
       try {

            Statement stm = cnx.createStatement();

            stm.executeUpdate(query);
         
            System.out.println("Ajouté");
                 

        } catch(SQLException ex) {
            System.out.println("ajout echoué " + ex.getMessage());

            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    //Afficher la liste des amis
    @Override
    public ObservableList<Utilisateur> AfficherAmis(int IdU) {
      ObservableList<Utilisateur>Utilisateurs = FXCollections.observableArrayList();
      
    
       String query = "Select * from utilisateur u inner join amis a on a.FriendID = u.ID WHERE a.IDUser ='" +IdU+"' AND a.Confirmed=1";
        try  {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);

            while(rst.next()) {
                Utilisateur U = new Utilisateur();
                U.setId(rst.getInt("ID"));
                U.setUsername(rst.getString("Username"));
                U.setEmail(rst.getString("Email"));
                U.setNom(rst.getString("Nom"));
                
                U.setAge(rst.getInt("Age"));
                U.setSexe(rst.getString("Sexe"));
                U.setNumTel(rst.getInt("NumTel"));
                U.setDateCreation(rst.getDate("DateCreation"));
                U.setURLImg(rst.getString("Image"));

                Utilisateurs.add(U);
            }


        } catch(Exception e){
                Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,e);
        }
      
      return Utilisateurs ; 
    }

    
    // afficher les demandes amis
    @Override
    public ObservableList<Utilisateur> AfficherDemande(int IdU) {
        ObservableList<Utilisateur>Utilisateurs = FXCollections.observableArrayList();
      
        String query = "Select * from utilisateur u inner join amis a on a.FriendID = u.ID WHERE a.IDUser ='" +IdU+"' AND a.Confirmed=0";
        try  {
            Statement stm = cnx.createStatement();
            ResultSet rst = stm.executeQuery(query);

            while(rst.next()) {
                Utilisateur U = new Utilisateur();
                U.setId(rst.getInt("ID"));
                U.setUsername(rst.getString("Username"));
                U.setEmail(rst.getString("Email"));
                U.setNom(rst.getString("Nom"));
                
                U.setAge(rst.getInt("Age"));
                U.setSexe(rst.getString("Sexe"));
                U.setNumTel(rst.getInt("NumTel"));
                U.setDateCreation(rst.getDate("DateCreation"));
                U.setURLImg(rst.getString("Image"));

                Utilisateurs.add(U);
            }


        } catch(Exception e){
                Logger.getLogger(ServiceFriend.class.getName()).log(Level.SEVERE,null,e);
        }
        
      return Utilisateurs ; 
       
    }
    
    // Supprimer un amis , ou refuser une demande 
    @Override
    public void SupprimerAmis(Friend F) {
        String query="Delete FROM amis WHERE FriendID="+F.getFriendID()+" AND IDUser="+F.getIDUser()+"";
        String query2="Delete FROM amis WHERE IDUser="+F.getFriendID()+" AND FriendID="+F.getIDUser()+"";
        try {

            Statement stm = cnx.createStatement();
            stm.executeUpdate(query);
            stm.executeUpdate(query2);

        } catch(SQLException ex) {
            Logger.getLogger(ServiceFriend.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    
    // Accepter une demande 
    @Override
    public void AccepterAmis(Friend F) {
        String query3 = "INSERT INTO `amis`(`FriendID`, `IDUser`) VALUES ('" +F.getIDUser() +"','" + F.getFriendID() +"')"; 
        
        
        String query = "UPDATE amis SET Confirmed ='" +1+"'WHERE  FriendID="+F.getFriendID()+" AND IDUser="+F.getIDUser()+"";
        String query2 = "UPDATE amis SET Confirmed ='" +1+"'WHERE  IDUser="+F.getFriendID()+" AND FriendID="+F.getIDUser()+"";
        
         try {
         Statement    stm = cnx.createStatement();
             stm.executeUpdate(query3);
            stm.executeUpdate(query);
            stm.executeUpdate(query2);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFriend.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Accepté");
    }

    
    // voir si 2 sont deja amis 
    @Override
    public boolean Friendship(int ID1, int ID2) {
        
        String FriendVerif = "SELECT count(1) FROM amis WHERE IDUser = '"+ID1+"' AND FriendID = '"+ID2+"' ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet queryResult = stm.executeQuery(FriendVerif);

            // verifier et afficher si l'email existe
            while (queryResult.next()) {
                if (queryResult.getInt(1) != 1) {
                    return true ;
                }
            }

        } catch(Exception e) {
            Logger.getLogger(ServiceFriend.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return false ;
    }
    
    
}
