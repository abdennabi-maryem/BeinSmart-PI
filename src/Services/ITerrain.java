/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Terrain;
import javafx.collections.ObservableList;

/**
 *
 * @author lenovo
 */
public interface ITerrain {
    public void AjoutTerrain (Terrain t);
    
    public ObservableList<Terrain> AffichTerrain();
    public void SupprTerrain(Terrain t);
    public void ModifTerrain(Terrain t);
    public Terrain DetailTerrain(int id);
    
}
