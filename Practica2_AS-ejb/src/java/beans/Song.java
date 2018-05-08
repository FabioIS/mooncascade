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
public class Song {

    private String artist;
    private String tittle;
    private int id;
    int price;

    private Stadistics stadistics;

    private LogBean log;

    public Song() {
    }

    public int getId() throws NamingException {
        log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
        log.writeLog("Song", "getId");
        return id;
    }

    public int getPrice() throws NamingException {
        log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
        log.writeLog("Song", "getPrice");
        return price;
    }

    public Song(String artist, String tittle, int id, int price) throws NamingException {
        stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
        stadistics.addSong();
        this.artist = artist;
        this.tittle = tittle;
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        try {
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            log.writeLog("Song", "toString");
        } catch (NamingException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tittle;
    }

    @PostConstruct
    public void postConstruct() {
        try {
            stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
            stadistics.addSong();
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            log.writeLog("Song", "postContruct");
        } catch (NamingException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("PostConstruct");
    }

    public String getArtist() throws NamingException {
        log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
        log.writeLog("Song", "getArtist");
        return artist;
    }

    public void setArtist(String artist) throws NamingException {
        log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
        log.writeLog("Song", "setArtist");
        this.artist = artist;
    }

    public String getTittle() throws NamingException {
        log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
        log.writeLog("Song", "getTittle");
        return tittle;

    }

    public void setTittle(String tittle) throws NamingException {
        log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
        log.writeLog("Song", "setTittle");
        this.tittle = tittle;
    }

    public boolean equals(Song two) throws NamingException {
        log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
        log.writeLog("Song", "equals");
        return (this.getArtist().equals(two.getArtist())
                && this.getTittle().equals(two.getTittle()));
    }

    @PreDestroy
    public void preDestroy() {
        try {
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            log.writeLog("Song", "preDestroy");
            System.out.println("PreDestroy");
        } catch (NamingException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostActivate
    public void PostActive() {
        try {
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            log.writeLog("Song", "PostActivate");
            System.out.println("PostActivate");
        } catch (NamingException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Remove
    public void remove() {
        try {
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            log.writeLog("Song", "remove");
            System.out.println("Remove");
        } catch (NamingException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
