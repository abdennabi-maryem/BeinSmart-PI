/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Coach;
import Entities.Utilisateur;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author 21699
 */
public interface IServiceCoach {
    public void AddCoach(Coach c);
    public void ModifierCoach(Coach c);
    public void SupprimerCoach(Coach c);
    
    public ObservableList<Coach> AfficherListCoach();
    public ObservableList<Coach> AfficherDemande();
    public Coach AfficherDetailsCoach(int IdC);
    
    public void AccepterCoach(Coach c);
}
