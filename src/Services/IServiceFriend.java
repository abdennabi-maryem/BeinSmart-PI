/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Friend;
import Entities.Utilisateur;
import javafx.collections.ObservableList;

/**
 *
 * @author 21699
 */
public interface IServiceFriend {
    public void Addfriend(Friend F);
    
    public ObservableList<Utilisateur> AfficherAmis(int IdU);
    public ObservableList<Utilisateur> AfficherDemande(int IdU);
    public void SupprimerAmis(Friend F);
        
    public void AccepterAmis(Friend F);
    
    public boolean Friendship(int ID1 , int ID2); 

}
