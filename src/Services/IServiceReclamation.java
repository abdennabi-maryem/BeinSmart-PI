/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reclamation;
import Entities.Utilisateur;

import javafx.collections.ObservableList;


/**
 *
 * @author 21699
 */
public interface IServiceReclamation {
    public void AddReclamation(Reclamation r);
    public ObservableList<Reclamation> AfficherReclamation();
    public void ModifierReclamation(Reclamation r);
    public void SupprimerReclamation(Reclamation r);
    public Reclamation AfficherRecDetails(int id);
    
    public Utilisateur InfoReclameur(int IDRec);
}
