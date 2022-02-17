/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Commentaire;
import Entities.News;
import javafx.collections.ObservableList;

/**
 *
 * @author guest
 */
public interface InterfaceServicesCommentaires {
    public void AjouterCommentaire(Commentaire c,int idN);
    public ObservableList<Commentaire> AfficherCommentaire(int idN);
    public void SupprimerCommentaire(Commentaire c);
    public void ModifierCommentaire(Commentaire c);
   
    
}
