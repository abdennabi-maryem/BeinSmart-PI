/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Utilisateur;
import Services.IServiceUtilisateur;
import Utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.LocalDate.now;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 21699
 */
public class ServiceUtilisateur implements IServiceUtilisateur {
    Connection cnx ;

    public ServiceUtilisateur() {
        cnx= MaConnexion.getInstance().getConnection();
    }


    // FONCTION AJOUTER  UTILISATEUR
    @Override
    public void AddUser(Utilisateur u)  {

       String query = "INSERT INTO `utilisateur`(`Username`, `Password`, `Email`,`DateCreation`,`notif`,`Nom`,`NumTel`,`Age`,`Sexe`) VALUES ('" +u.getUsername() +"','" + u.getPassword() +"','" + u.getEmail() +"','"+now()+"','" + u.getNotif()+"','"+u.getNom()+"','"+u.getNumTel()+"','"+u.getAge()+"','"+u.getSexe()+"')"; 
       try {

            Statement stm = cnx.createStatement();

            stm.executeUpdate(query);
            System.out.println("Utilisateur ajouté");
                 

        } catch(SQLException ex) {
            System.out.println("ajout echoué " + ex.getMessage());

            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

   // VERIFIER L EXISTANCE DU LOGIN ET MOT DE PASSE
    @Override
    public boolean ValidateLogin(String User,String Pw)
    {
        

        //chercher l'utilisateur avec username et password
        String LoginVerif = "SELECT count(1) FROM utilisateur WHERE Username= '" +User + "'AND PASSWORD ='" +Pw +"'";
        try {
            Statement stm = cnx.createStatement();
            ResultSet queryResult = stm.executeQuery(LoginVerif);

            // verifier et afficher si l'utilisateur existe
            while (queryResult.next()) {
                if (queryResult.getInt(1) != 1) {
                    return false ;
                }
            }

        } catch(Exception e) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,e);
        }
        return true ;
    }
    
    
    //verifier si le username existe lors de l'inscription
    @Override 
    public boolean ValidateUsername(String user){
        String UserVerif = "SELECT count(1) FROM utilisateur WHERE Username = '"+user+"' ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet queryResult = stm.executeQuery(UserVerif);

            // verifier et afficher si username existe
            while (queryResult.next()) {
                if (queryResult.getInt(1) != 1) {
                    return true ;
                }
            }

        } catch(Exception e) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }
    
    //verifier si l'email existe deja lors de l'inscription 
    @Override 
    public boolean ValidateEmail(String mail) {
        String EmailVerif = "SELECT count(1) FROM utilisateur WHERE Email = '"+mail+"' ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet queryResult = stm.executeQuery(EmailVerif);

            // verifier et afficher si l'email existe
            while (queryResult.next()) {
                if (queryResult.getInt(1) != 1) {
                    return true ;
                }
            }

        } catch(Exception e) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }

    @Override
    public ObservableList<Utilisateur> AfficherUser() {
        ObservableList<Utilisateur>Utilisateurs = FXCollections.observableArrayList();

        String query = "Select * from `utilisateur`";
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
                U.setDateCreation(rst.getDate("DateCreation"));
                U.setURLImg(rst.getString("Image"));
                

                Utilisateurs.add(U);
            }


        } catch(Exception e){
                Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,e);
        }
        return Utilisateurs ;
    }

    // POUR L'ADMIN : 
     @Override
    public void ModifierUser(Utilisateur u) {

       String query = "UPDATE utilisateur SET Username ='" +u.getUsername()+"',Nom ='" +u.getNom()+"' WHERE ID =" +u.getId()+"";
      
        try {
         Statement    stm = cnx.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Update done");
      
      
     


    }
    
    @Override
    public void ModifierProfil(Utilisateur u) {

       
     
       String query = "UPDATE utilisateur SET Age ='" +u.getAge()+"',Image ='"+u.getURLImg()+"' WHERE ID =" +u.getId()+"";
      
       
        try {
         Statement    stm = cnx.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Update done");
      
      
      /*  try {
           PreparedStatement Modif = cnx.prepareStatement(query);
           Modif.setString(1, u.getNom());
           Modif.setString(2, u.getPrenom());
           Modif.setString(3, u.getEmail());
           
         //  Modif.setString(4,u.getURLImg());
           Modif.setInt(4,u.getId());
           Modif.executeUpdate();

        } catch(SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,ex);
        }*/


    }

     @Override
    public void ModifierCompte(Utilisateur u) {

       
     
       String query = "UPDATE utilisateur SET Username ='" +u.getUsername()+"',Nom ='" +u.getNom()+"',NumTel ='" +u.getNumTel()+"' WHERE ID =" +u.getId()+"";
      
       
        try {
         Statement    stm = cnx.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Update done");
      
    }
    
    @Override
    public void SupprimerUser(Utilisateur u) {
        String query="Delete FROM utilisateur WHERE ID="+u.getId()+"";
        try {

            Statement stm = cnx.createStatement();
            stm.executeUpdate(query);

        } catch(SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
   

    @Override
    public Utilisateur AfficherUserDetails(int id) {
           String query = "SELECT * from utilisateur WHERE ID="+id+"";
        
        Utilisateur u = new Utilisateur();
       try {
           Statement stm = cnx.createStatement();
           ResultSet rst = stm.executeQuery(query);
           while(rst.next()) {
           u.setId(rst.getInt("ID"));
           u.setUsername(rst.getString("Username"));
           u.setEmail(rst.getString("Email"));
           u.setNom(rst.getString("Nom"));
           u.setURLImg(rst.getString("Image"));
           u.setDateCreation(rst.getDate("DateCreation"));
           u.setAge(rst.getInt("Age"));
           u.setSexe(rst.getString("Sexe"));
           u.setNumTel(rst.getInt("Numtel"));
           
           
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
       }
            
           return u; 
        
    }
    
    
   // details d'une session pour la connexion/session
     @Override
    public Utilisateur SessionDetails(String username) {
           String query = "SELECT * from utilisateur WHERE Username='"+username+"'";
        
        Utilisateur u = new Utilisateur();
       try {
           Statement stm = cnx.createStatement();
           ResultSet rst = stm.executeQuery(query);
           while(rst.next()) {
           u.setId(rst.getInt("ID"));
           u.setUsername(rst.getString("Username"));
           u.setPassword(rst.getString("Password"));
           u.setEmail(rst.getString("Email"));
           u.setNom(rst.getString("Nom"));
           u.setNumTel(rst.getInt("NumTel"));
           u.setAge(rst.getInt("Age"));
           u.setSexe(rst.getString("Sexe"));
           u.setAuth(rst.getInt("Auth"));
           u.setURLImg(rst.getString("Image"));
           u.setNotif(rst.getInt("notif"));
           
           
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
       }
            
           return u; 
        
    }
    
    
     // mot  de passe oublié avec mail 
    
    
            // generer un code pour l'envoyer 
    @Override
    public Utilisateur CodeConf(String email) {
      
      Random rand = new Random();
      int code = rand.nextInt(999999);
      
        
        
         String query = "SELECT * from utilisateur WHERE Email='"+email+"'";
         String query2 = "UPDATE utilisateur SET Code ='" +code+"' WHERE Email ='" +email+"'";
    
        
        Utilisateur u = new Utilisateur();
       try {
           Statement stm = cnx.createStatement();
           stm.executeUpdate(query2);
           
           ResultSet rst = stm.executeQuery(query);
           
           while(rst.next()) {
           
           u.setUsername(rst.getString("Username"));
           u.setCode(rst.getInt("Code"));
           
           
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
       }
            
           return u; 
    }
    
    @Override 
    public boolean VerifCode(String email,int Code ) {
        String query = "SELECT * from utilisateur WHERE Email='"+email+"'";
        try {
           Statement stm = cnx.createStatement();
           ResultSet rst = stm.executeQuery(query);
           
           while(rst.next()) {
           if (rst.getInt("Code")==Code)
           {
               return true ;
           }
        
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
       }
         return false ;   

}
    
    @Override 
    public void NewPw(String email , String pw) {
        
      String query="update utilisateur set Password='"+pw+"' where Email='"+email+"' ";
      
      try {

            Statement stm = cnx.createStatement();

            stm.executeUpdate(query);
            System.out.println("Mot de passe changé ");
                 

        } catch(SQLException ex) {
            System.out.println("Echec" );
            System.out.println(ex);
        }
    }
    
    
    
    
    
    // Notification coach 
    
     @Override
    public void Notification(int id,int n) {
        
       
        
        
        String query = "UPDATE utilisateur SET notif ='" +n+"'WHERE  ID="+id+"";
        
        
         try {
         Statement    stm = cnx.createStatement();
             
            stm.executeUpdate(query);
         
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
