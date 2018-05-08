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
public class SongList {

    private List<Song> catalog;

    private Stadistics stadistics;
    
    private LogBean log;

    
    public Song getById(int id) throws NamingException {
        log.writeLog("SongList", "getById");
        for (Song song : catalog) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null;
    }

    public Song get(int i) {
        log.writeLog("SongList", "get");
        return catalog.get(i);
    }

    @PostConstruct
    public void postConstruct() {
        try {
            catalog = new ArrayList<>();
            catalog.add(new Song("Bob Marley", "Three Little Birds", 1, 3));
            catalog.add(new Song("Bruno Mars", "Im yours", 2, 1));
            catalog.add(new Song("Protoje", "Who knows", 3, 2));
            catalog.add(new Song("Green Valley", "Relaja", 4, 5));
            catalog.add(new Song("Bejo", "Poco", 5, 1));
            catalog.add(new Song("Craneo", "Fly Chill", 6, 2));
            catalog.add(new Song("Nathy Peluso", "Summertime", 7, 4));
            stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            stadistics.addSongList();
            log.writeLog("SongList", "postContruct");
            System.out.println("PostConstruct");
        } catch (NamingException ex) {
            Logger.getLogger(SongList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PreDestroy
    public void preDestroy() {
        log.writeLog("SongList", "preDestroy");
        System.out.println("PreDestroy");
    }

    @PostActivate
    public void PostActive() {
        log.writeLog("SongList", "PostActivate");
        System.out.println("PostActivate");
    }

    @Remove
    public void remove() {
        log.writeLog("SongList", "remove");
        System.out.println("Remove");
    }

    public int size() throws NamingException {
        log.writeLog("SongList", "size");
        return catalog.size();
    }

}
