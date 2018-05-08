/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comands;

import beans.Album;
import beans.Song;
import beans.SongList;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1996f
 */
public class FavCommand extends FrontCommand {

    SongList catalog;
    
    @Override
    public void process() {
        try {
            HttpSession session = request.getSession();
            Album favAlbum = (Album) session.getAttribute("Favourite");
            if(favAlbum == null){
                favAlbum = lookupAlbumBean();
                session.setAttribute("Favourite", favAlbum);
            }
            
            int id = Integer.parseInt(request.getParameter("id"));
            catalog = lookupSongListBean();
            Song nueva = catalog.getById(id);
            if(favAlbum.contains(nueva)){
                session.setAttribute("error", "repeatFav");
                forward("/MyAlbum.jsp");
            }else{
                favAlbum.addSong(nueva);
            }
            session.setAttribute("Favourite", favAlbum);
            forward("/FavAlbum.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddSongCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FavCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

    private SongList lookupSongListBean() {
        try {
            return (SongList) InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/SongList");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Album lookupAlbumBean() {
        try {
            Context c = new InitialContext();
            return (Album) c.lookup("java:global/Practica2_AS/Practica2_AS-ejb/Album!beans.Album");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
