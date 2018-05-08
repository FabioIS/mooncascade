/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Remove;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 1996f
 */
@Stateless
@LocalBean
public class Bill {

    


    private Stadistics stadistics;
   
    private LogBean log;
   
    
    public int calculateTotalPrice(Cart cart) throws NamingException{
        log.writeLog("Bill", "calculateTotalPrice");
        int totalPrice = 0;
        for (int i = 0; i < cart.size(); i++) {
            totalPrice += cart.getSong(i).getPrice();
            
        }
        return totalPrice;
    }
    

    @PostConstruct
    public void postConstruct(){
        try {
            stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
            stadistics.addBill();
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            log.writeLog("Bill", "postContruct");
        } catch (NamingException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("PostConstruct"); 
    }
    
    @PreDestroy
    public void preDestroy(){
        log.writeLog("Bill", "preDestroy");
        System.out.println("PreDestroy");
    }
    
    @PostActivate
    public void PostActive(){
        log.writeLog("Bill", "PostActivate");
        System.out.println("PostActivate");
    }
    
    @Remove
    public void remove(){
        log.writeLog("Bill", "remove");
        System.out.println("Remove");
    }
    
}


