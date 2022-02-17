/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Utilisateur;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author 21699
 */
public interface IServiceUtilisateur {
    public void AddUser(Utilisateur u);
    public ObservableList<Utilisateur> AfficherUser();
    public void ModifierProfil(Utilisateur u);
    public void ModifierCompte(Utilisateur u);
    public void ModifierUser(Utilisateur u);
    public void SupprimerUser(Utilisateur u);
    
    
    public boolean ValidateLogin(String User,String Pw);
    public boolean ValidateUsername(String user);
    public boolean ValidateEmail(String mail);
    public Utilisateur AfficherUserDetails(int id);
    public Utilisateur SessionDetails(String username) ;
    
    public Utilisateur CodeConf(String email);
    public boolean VerifCode(String email,int Code);
     public void NewPw(String email , String pw);

     // coach notif 
     public void Notification(int id,int n) ;
     
     
     
    //public void SupprimerUser(Utilisateur u);
}
