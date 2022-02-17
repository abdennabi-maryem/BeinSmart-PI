/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author 21699
 */
public class UserSession {
    private  static UserSession instance=null;
    
    private static int ID ;
    private static String Username;
    private static String Password ; 
    private static String Email ; 
    private static String Nom ;
    private static int Age ;
    private static String Sexe;
    private static  int Auth ; 
    private static String URLImg;
    private static int notif ; 
    private static int NumTel;

  
    private UserSession(int ID ,String Username, String Password, String Email, String Nom,  int Age, String Sexe,int Auth,String URLImg,int NumTel,int notif) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Nom = Nom;
        this.Age = Age;
        this.Sexe = Sexe;
        this.Auth = Auth ;
        this.URLImg = URLImg;
        this.notif = notif ;
        this.NumTel = NumTel;
    }
    
 
    public static UserSession getInstance(int ID ,String Username, String Password, String Email, String Nom,int Age, String Sexe,int Auth,String URLImg,int NumTel,int notif) {
        if(instance == null) {
            instance = new UserSession(ID,Username,Password,Email,Nom,Age,Sexe,Auth,URLImg,NumTel,notif);
        }
        return instance;
    }
    
     public UserSession getInstance() {
        return instance;
    }

    public static String getURLImg() {
        return URLImg;
    }
 
     
    public static String getUsername() {
        return Username;
    }

   public static int getNotif() {
        return notif;
    }
   
      

    public static int getID() {
        return ID;
    }

    public static String getPassword() {
        return Password;
    }

    public static String getEmail() {
        return Email;
    }

    public static String getNom() {
        return Nom;
    }

   

    public static int getAge() {
        return Age;
    }

    public static String getSexe() {
        return Sexe;
    }

    public static int getAuth() {
        return Auth;
    }
         
   public static int getNumTel() {
        return NumTel;
    }
 
    public void cleanUserSession() {
       instance = null;
        
    }
 
  

  /*   @Override
    public String toString() {
        return "UserSession{" + "ID=" + ID  + ", Username=" + Username + ", Password=" +
                Password + ", Email=" + Email + ", Nom=" + Nom + ", Age=" + Age + ", Sexe=" + Sexe + '}';
    }
    */
}
