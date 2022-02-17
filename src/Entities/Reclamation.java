/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author 21699
 */
public class Reclamation {
     private int IDRec;
     private int IDUser;
    private String UserRec;
    private String Objet;
    private String Message;
    private Date DateAjout ;
    private String URLImg;

    public Reclamation() {
    }

    public int getIDRec() {
        return IDRec;
    }

    public void setIDRec(int IDRec) {
        this.IDRec = IDRec;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }
    
    

    public String getUserRec() {
        return UserRec;
    }

    public void setUserRec(String userRec) {
        UserRec = userRec;
    }

    public String getObjet() {
        return Objet;
    }

    public void setObjet(String objet) {
        Objet = objet;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }


    public Date getDateAjout() {
        return DateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        DateAjout = dateAjout;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "IDRec=" + IDRec +
                ", IDUser='" + IDUser + '\'' +
                ", UserRec='" + UserRec + '\'' +
                ", Objet='" + Objet + '\'' +
                ", Message='" + Message + '\'' +
                ", DateAjout=" + DateAjout + '\'' +
                ", URLIMG="+URLImg+
                "}\n";
    }

    public String getURLImg() {
        return URLImg;
    }

    public void setURLImg(String URLImg) {
        this.URLImg = URLImg;
    }
    
}
