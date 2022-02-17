/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author 21699
 */
public class Coach extends Utilisateur {
    private int IDC ; 
    private int IDUser;
    private String filiere ; 
    private int AnExp;  // experience en annee 
    private String Region ; 
    private String Proof;
    private int Confirmed ;

    public Coach() {
    }
    
    

    public int getIDC() {
        return IDC;
    }

    public void setIDC(int IDC) {
        this.IDC = IDC;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

   

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getAnExp() {
        return AnExp;
    }

    public void setAnExp(int AnExp) {
        this.AnExp = AnExp;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

   

    

    public int getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(int Confirmed) {
        this.Confirmed = Confirmed;
    }

    public String getProof() {
        return Proof;
    }

    public void setProof(String Proof) {
        this.Proof = Proof;
    }

    @Override
    public String toString() {
        return super.toString()+ "Coach{ " + "IDC=" + IDC + ", IDUser=" + IDUser + ", filiere=" + filiere + ", AnExp=" + AnExp + ", Region=" + Region + ", Proof=" + Proof + ", Confirmed=" + Confirmed + '}';
    }

    
    
    
}
