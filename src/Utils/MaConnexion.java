/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 21699
 */
public class MaConnexion {
    final static String url ="jdbc:mysql://127.0.0.1:3306/pidev";
    final static String LOGIN ="root";
    final static String PASSWORD="";
    static MaConnexion  instance = null;
     private Connection cnx ;
     
     private MaConnexion(){
        try {
            cnx= DriverManager.getConnection(url,LOGIN,PASSWORD);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("pas de connexion");        }}
        
        public static MaConnexion getInstance(){
            
            if (instance==null){
                
                    instance = new MaConnexion();
        }
            return instance;
            
            
        }
        public Connection getConnection(){
            return cnx;
            
        }
    
}
