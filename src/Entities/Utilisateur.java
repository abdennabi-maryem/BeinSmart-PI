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
public class Utilisateur {
     private int id ;
    private String Username;
    private String Password;
    private String Email ;
    private String Nom ;
   
    private String Sexe ;
    private int age ;
    private int NumTel;
    private Date DateCreation ;
    private int Auth;
    private int code ; 
    private String URLImg ; 
    
    private int notif ;
    public Utilisateur() {
    }

    public int getNotif() {
        return notif;
    }

    public void setNotif(int notif) {
        this.notif = notif;
    }

    
    
    public String getURLImg() {
        return URLImg;
    }

    public void setURLImg(String URLImg) {
        this.URLImg = URLImg;
    }

    public int getNumTel() {
        return NumTel;
    }

    public void setNumTel(int NumTel) {
        this.NumTel = NumTel;
    }
    
    

    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        DateCreation = dateCreation;
    }

    public int getAuth() {
        return Auth;
    }

    public void setAuth(int Auth) {
        this.Auth = Auth;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", Username=" + Username + ", Password=" + Password + ", Email=" + Email + ", Nom=" 
                + Nom + ", Sexe=" + Sexe + ", age=" + age + ", DateCreation=" + DateCreation + ", Auth=" + Auth +
                "}\n";
    }
    
    
    
}
