/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.News;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;

/**
 *
 * @author guest
 */
public interface InterfaceServiceNews {
    public void AjouterNews(News n);
    public ObservableList<News> AfficherNews();
    public void SupprimerNews(News n);
    public void ModifierNews(News n);
     public ObservableList<News> AfficherNewsParTypeSport( String TypeSport);
     public void ModifieNbreacts(int nbreacts,  News n);
}
