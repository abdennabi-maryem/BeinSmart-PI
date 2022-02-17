/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.NewsCom;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author essia
 */
public class smsSender {
        /**
     * @param args the command line arguments
     */
   // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC5855f26f1d059fcf73911900db0f5647";
    public static final String AUTH_TOKEN =
            "6db5b9f5a4fd8d7471fdc4e58f25e042";


    public void send(String s,String x){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
        Message message = Message 
                .creator(new PhoneNumber("+21650660838"), // to
                        new PhoneNumber("+18649528596"), // from
                       ""+s)
                .create();
  System.out.println("un nouvel article a été ajouté");
        System.out.println(message.getSid());
    
}
    
}
