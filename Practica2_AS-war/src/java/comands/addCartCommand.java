/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comands;

import beans.Album;
import beans.Cart;
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
public class addCartCommand extends FrontCommand{


    SongList catalog = lookupSongListBean();
    @Override
    public void process() {
        try {
        HttpSession session = request.getSession();
        int id;
        Cart myCart = (Cart) session.getAttribute("Cart");
        Album myAlbum = (Album) session.getAttribute("Album");
        if(myCart == null){
          myCart = lookupCartBean();
        }
        id = Integer.parseInt(request.getParameter("id"));
        Song nueva = catalog.getById(id);
        if(myCart.contains(nueva)){
            session.setAttribute("error", "repeat1");
            forward("/ListSong.jsp");
        }else if(myAlbum != null && myAlbum.contains(nueva)){
            session.setAttribute("error", "repeat");
            forward("/ListSong.jsp");
        }else{
        myCart.addSong(nueva);
        }
        session.setAttribute("Cart", myCart);
        forward("/MyCart.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddSongCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(addCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }  

    private SongList lookupSongListBean() {
        try {
            Context c = new InitialContext();
            return (SongList) c.lookup("java:global/Practica2_AS/Practica2_AS-ejb/SongList");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Cart lookupCartBean() {
        try {
            Context c = new InitialContext();
            return (Cart) c.lookup("java:global/Practica2_AS/Practica2_AS-ejb/Cart!beans.Cart");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
