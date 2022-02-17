/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author lenovo
 */
public class Terrain {
    private int id,count,NumTel;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    private String nomT,Adresse,type_sport,ressources,URLImg;

    public int getNumTel() {
        return NumTel;
    }

    public void setNumTel(int NumTel) {
        this.NumTel = NumTel;
    }

    public String getURLImg() {
        return URLImg;
    }

    public void setURLImg(String URLImg) {
        this.URLImg = URLImg;
    }

   
    

    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getNomT() {
        return nomT;
    }

    public void setNomT(String nomT) {
        this.nomT = nomT;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getType_sport() {
        return type_sport;
    }

    public void setType_sport(String type_sport) {
        this.type_sport = type_sport;
    }

    public String getRessources() {
        return ressources;
    }

    public void setRessources(String ressources) {
        this.ressources = ressources;
    }

    @Override
    public String toString() {
        return "Terrain{" + "id=" + id + ", nomT=" + nomT + ", Adresse=" + Adresse + ", type_sport=" + type_sport + ", ressources=" + ressources + '}';
    }
    
}
