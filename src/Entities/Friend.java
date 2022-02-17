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
public class Friend {
    private int IDUser ; 
    private int FriendID;
    private int Confirmed;

    public Friend() {
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public int getFriendID() {
        return FriendID;
    }

    public void setFriendID(int FriendID) {
        this.FriendID = FriendID;
    }

    public int getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(int Confirmed) {
        this.Confirmed = Confirmed;
    }

    @Override
    public String toString() {
        return "Friend{" + "IDUser=" + IDUser + ", FriendID=" + FriendID + ", Confirmed=" + Confirmed +
                "}\n";
    }
    
    
}
