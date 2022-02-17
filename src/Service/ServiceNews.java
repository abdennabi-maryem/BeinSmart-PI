/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.News;
import Services.InterfaceServiceNews;
import Utils.MaConnexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;



/**
 *
 * @author guest
 */

public class ServiceNews implements InterfaceServiceNews {
    public ObservableList<News> listeNews = FXCollections.observableArrayList();

    private FileInputStream fis;
    private File file;
    Connection cnx;
    public ServiceNews() {
        cnx=MaConnexion.getInstance().getConnection();
    }
    
 

        public void AjouterNews(News n) {
        try {
//            Statement stm =cnx.createStatement();
//            String query="INSERT INTO `news`(`Contenu`, `Titre`,`Date`,`TypeSport`,`ImageNews`) VALUES ("+'"'+n.getContenu()+'"'+","+'"'+n.getTitre()+'"'+","+'"'+n.getDate()+
//                    '"'+","+'"'+n.getTypeSport()+'"'+","+'"'+n.getImagenews()+'"'+")";
           String query="INSERT INTO `news`(`Contenu`, `Titre`,`Date`,`TypeSport`,`ImageNews`,`nbreacts`) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(query);
         FileChooser fileChooser = new FileChooser();
           String Contenu=n.getContenu();
           String Titre=n.getTitre();
//           Date Date= java.sql.Date(n.getDate());
           String TypeSport=n.getTypeSport();
          pst.setString(1, n.getContenu());
           pst.setString(2, n.getTitre());
           java.util.Date d1 = new java.util.Date();
            java.sql.Date dateToday = new java.sql.Date(d1.getTime());
           pst.setDate(3,dateToday);
           pst.setString(4, n.getTypeSport());
     
           pst.setString(5, n.getURLImg());
           pst.setInt(6, n.getNbreacts());
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);}
       

        }

    @Override
    public ObservableList<News> AfficherNews() {
        
         ObservableList<News> news = FXCollections.observableArrayList();

        try {
            Statement stm =cnx.createStatement();
            String query="select * from `news`";
//SELECT * FROM `news` n INNER JOIN `commentaire` c ON n.id=c.idNews
//                   String query="SELECT * FROM `news` n INNER JOIN `commentaire` c ON "+news
            ResultSet rst =stm.executeQuery(query);
            while (rst.next())
            {
                News n = new News();
               n.setId(rst.getInt("id"));
              n.setDate(rst.getDate("date"));
            n.setTitre((rst.getString("Titre")));
                n.setContenu(rst.getString("Contenu"));
                n.setTypeSport(rst.getString("TypeSport"));
                n.setURLImg(rst.getString("ImageNews"));
                n.setNbreacts(rst.getInt("nbreacts"));
              news.add(n);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        }
            return news;
    }

    
    public void SupprimerNews(News n) {
        try { 
               String query = "delete from `news` where id ="+n.getId();
        PreparedStatement pst = cnx.prepareStatement(query);
          pst.execute();
      } catch (SQLException ex) {
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ModifierNews(News n) {
        try {
//            String query = "UPDATE `news` SET `Contenu`= '"+n.getContenu()+"',`Titre`='"+n.getTitre()+"',`Date`="+n.getDate()+" WHERE id="+n.getId()+"";
//            String query = "UPDATE `news` SET `Contenu`= '"+n.getContenu()+"',`Titre`='"+n.getTitre()+"',`Date`='"+n.getDate()+"',`TypeSport`='"+n.getTypeSport()+"' WHERE id="+n.getId();
String query = "UPDATE `news` SET `Contenu`=?,`Titre`=?,`Date`=?,`ImageNews`=? WHERE id=?";

         
            PreparedStatement pst = cnx.prepareStatement(query);
            pst.setString(1,n.getContenu());
            pst.setString(2,n.getTitre());
            java.util.Date d1 = new java.util.Date();
                        java.sql.Date dateToday = new java.sql.Date(d1.getTime());
            pst.setDate(3, dateToday);
            
            
//            fis = new FileInputStream(file);
//           pst.setBinaryStream(4,(InputStream)fis,(int)file.length());
            
            pst.setString(4, n.getURLImg() );
            pst.setInt(5, n.getId() );
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
//        
        }
        
    }
     public ObservableList<News> AfficherNewsParTypeSport(String TypeSport) {
        

        try {
            Statement stm =cnx.createStatement();
            String query="select * from `news` where TypeSport= "+'"'+TypeSport+'"';
//SELECT * FROM `news` n INNER JOIN `commentaire` c ON n.id=c.idNews
//                   String query="SELECT * FROM `news` n INNER JOIN `commentaire` c ON "+news
            ResultSet rst =stm.executeQuery(query);
            while (rst.next())
            {
                News n=new News();
               n.setId(rst.getInt("id"));
              n.setDate(rst.getDate("date"));
            n.setTitre((rst.getString("Titre")));
                n.setContenu(rst.getString("Contenu"));
                n.setTypeSport(rst.getString("TypeSport"));
                n.setURLImg(rst.getString("ImageNews"));
              listeNews.add(n);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listeNews;
    }
      public News AfficherNewsDetails(int id) {
       // String query ="SELECT  FROM reclamation WHERE IDRec="+r.getIDRec()+"";
       //String query ="SELECT  FROM reclamation WHERE IDRec="+id+"";
      // String query = "SELECT * FROM `reclamation` WHERE `IDRec`="+id;
      
      String query = "SELECT * from News WHERE id="+id+"";
        
        News n= new News();
       try {
           Statement stm = cnx.createStatement();
           ResultSet rst = stm.executeQuery(query);
           while(rst.next()) {
               n.setId(rst.getInt("id"));
               n.setTitre(rst.getString("Titre"));
               n.setContenu(rst.getString("Contenu"));
               n.setTypeSport(rst.getString("TypeSport"));
               n.setURLImg(rst.getString("ImageNews"));
               n.setNbreacts(rst.getInt("nbreacts"));
           
           }
           
       } catch (SQLException ex) { 
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           return n; 
        
    }
@Override
    public void ModifieNbreacts(int nbreacts,News n) {
        try {
//            String query = "UPDATE `news` SET `Contenu`= '"+n.getContenu()+"',`Titre`='"+n.getTitre()+"',`Date`="+n.getDate()+" WHERE id="+n.getId()+"";
//            String query = "UPDATE `news` SET `Contenu`= '"+n.getContenu()+"',`Titre`='"+n.getTitre()+"',`Date`='"+n.getDate()+"',`TypeSport`='"+n.getTypeSport()+"' WHERE id="+n.getId();
String query = "UPDATE `news` SET `nbreacts`=? WHERE id="+n.getId();

         
            PreparedStatement pst = cnx.prepareStatement(query);
                pst.setInt(1,n.getNbreacts());
               
            
            
//            fis = new FileInputStream(file);
//           pst.setBinaryStream(4,(InputStream)fis,(int)file.length());
            
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
//        
        }
    
    
}}
