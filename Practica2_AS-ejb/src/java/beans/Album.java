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
import javax.ejb.EJB;
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
public class Album {

    @EJB
    private Stadistics stadistics;

    private List<Song> lista;
    
    @EJB
    private LogBean log;
    
    
    public void deleteSong(Song vieja) throws NamingException{
        log.writeLog("Album", "deleteSong");
        for (int i = 0; i < lista.size(); i++) {
            if(vieja.equals(lista.get(i))){
                lista.remove(i);
            }
            
        }
    }
    
    public boolean contains(Song target) throws NamingException{
        log.writeLog("Album", "contains");
        for (int i = 0; i < lista.size(); i++) {
            if(target.equals(lista.get(i))){
                return true;
            }
        }
        return false;
    }
   
    public void addSong(Song cancion) throws NamingException{
        log.writeLog("Album", "addSong");
        lista.add(cancion);
    }
    
    public Song getSong(int i) throws NamingException{
        log.writeLog("Album", "getSong");
        return lista.get(i);
    }

    public int size() throws NamingException{
        log.writeLog("Album", "size");
        return lista.size();
    }
    
    @PostConstruct
    public void postConstruct(){
        
        lista = new ArrayList<>();
        stadistics.addAlbum();
        log.writeLog("Album", "postConstruc");
        
        System.out.println("PostConstruct"); 
    }
    
    @PreDestroy
    public void preDestroy(){
        log.writeLog("Album", "preDestroy");
        System.out.println("PreDestroy");
    }
    
    @PostActivate
    public void PostActive(){
        log.writeLog("Album", "PostActivate");
        System.out.println("PostActivate");
    }
    
    @Remove
    public void remove(){
        log.writeLog("Album", "remove");
        System.out.println("Remove");
    }
    
}
