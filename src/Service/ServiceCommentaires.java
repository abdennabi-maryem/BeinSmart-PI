/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Commentaire;
import Entities.News;
import Services.InterfaceServicesCommentaires;
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
 * @author guest
 */
public class ServiceCommentaires implements InterfaceServicesCommentaires {
         Connection cnx;
    public ServiceCommentaires() {
        cnx=MaConnexion.getInstance().getConnection();
    }
    @Override
    public void AjouterCommentaire(Commentaire c,int idN) {
        try {
            Statement stm =cnx.createStatement();
            String query="INSERT INTO `commentaire`(`idCommentaire`, `Contenu`, `dateCommentaire`,`idNews`) VALUES ("+'"'+c.getId()+'"'+","+'"'+c.getContenu()+'"'+","+'"'+c.getDate_dajout()+'"'
                  +","+'"'+idN+'"'+")";
           
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
    }
    @Override
    public ObservableList<Commentaire> AfficherCommentaire(int idN) {
       
            ObservableList<Commentaire> Commentaires = FXCollections.observableArrayList();

        try {
            Statement stm =cnx.createStatement();
//           
            String query="SELECT * FROM commentaire where idNews="+idN;
            System.out.println(query);
            ResultSet rst =stm.executeQuery(query);
            while (rst.next())
            {
                Commentaire c = new Commentaire();
                c.setId(rst.getInt("idCommentaire"));
                c.setContenu(rst.getString("Contenu"));
                c.setDate_dajout(rst.getDate("dateCommentaire"));
                
                Commentaires.add(c);
                
              
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        }
            return Commentaires;
    }
    

    @Override
    public void SupprimerCommentaire(Commentaire c) {
             try {
                 String query = "delete from `commentaire` where `idCommentaire`="+c.getId();
                 PreparedStatement pst = cnx.prepareStatement(query);
                 pst.execute();
             } catch (SQLException ex) {
                 Logger.getLogger(ServiceCommentaires.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    @Override
    public void ModifierCommentaire(Commentaire c) {
             try {
                 String query = "UPDATE `commentaire` SET `Contenu`= '"+c.getContenu()+"' WHERE idCommentaire="+c.getId();
                 
                 PreparedStatement pst = cnx.prepareStatement(query);
                 pst.execute();
             } catch (SQLException ex) {
                 Logger.getLogger(ServiceCommentaires.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    
    
}
