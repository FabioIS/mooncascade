/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Remove;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 1996f
 */
@Stateful
@LocalBean
public class Cart {

    private List <Song> cart;

    private Stadistics stadistics;
    
    private LogBean log;
    
    
    public int size() throws NamingException{
        log.writeLog("Cart", "size");
        return cart.size();
    }
    
    public Song getSong(int i) throws NamingException{
        log.writeLog("Cart", "getSong");
        return cart.get(i);
    }
    
    public void deleteSong(Song vieja) throws NamingException{
        log.writeLog("Cart", "deleteSong");
        for (int i = 0; i < cart.size(); i++) {
            if(vieja.equals(cart.get(i))){
                cart.remove(i);
            }
            
        }
    }
    public boolean contains(Song target) throws NamingException{
        log.writeLog("Cart", "contains");
        for (int i = 0; i < cart.size(); i++) {
            if(target.equals(cart.get(i))){
                return true;
            }
        }
        return false;
    }
    
    public void empty () throws NamingException{
        log.writeLog("Cart", "empty");
        cart.clear();
    }
    
    public void addSong(Song nueva)throws NamingException{
        log.writeLog("Cart", "addSong");
        cart.add(nueva);
    }
    
    @PostConstruct
    public void postConstruct(){
        try {
            stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            stadistics.addCart();
            cart = new ArrayList<>();
            log.writeLog("Cart", "postContruct");
        } catch (NamingException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("PostConstruct"); 
    }
    
    @PreDestroy
    public void preDestroy(){
        log.writeLog("Cart", "preDestroy");
        System.out.println("PreDestroy");
    }
    
    @PostActivate
    public void PostActive(){
        log.writeLog("Cart", "PostActivate");
        System.out.println("PostActivate");
    }
    
    @Remove
    public void remove(){
        log.writeLog("Cart", "remove");
        System.out.println("Remove");
    }
       
}
