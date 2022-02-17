/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import javafx.scene.image.Image;

/**
 *
 * @author guest
 */
public class News {
    private int id;
    private String Titre,Contenu,TypeSport;
    private Date date;
    private String URLImg;
    private int nbreacts;
    public News() {
    }

    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   

    public String getTitre() {
        return Titre;
    }
    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }
     public String getContenu() {
        return Contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypeSport() {
        return TypeSport;
    }

    public void setTypeSport(String TypeSport) {
        this.TypeSport = TypeSport;
    }
private File file;

    public String getURLImg() {
        return URLImg;
    }

    public void setURLImg(String URLImg) {
        this.URLImg = URLImg;
    }

    public int getNbreacts() {
        return nbreacts;
    }

    public void setNbreacts(int nbreacts) {
        this.nbreacts = nbreacts;
    }
  
    
 
     
    

    @Override
    public String toString() {
        return   Titre + "\n "+ Contenu +"\n";
    }
    
    
    
    
    
    
}
