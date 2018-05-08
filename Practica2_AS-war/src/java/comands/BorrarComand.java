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
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
public class BorrarComand extends FrontCommand{

    SongList catalog = lookupSongListBean();
    @Override
    public void process() {
        //Artist art = Artist.find(request.getParameter("name"));
        //request.setAttribute("helper",new ArtistHelper(art));
        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));
            Song vieja = catalog.getById(id);
            switch (request.getParameter("task")) {
                case "fav":
                    Album favAlbum = (Album) session.getAttribute("Favourite");
                    favAlbum.deleteSong(vieja);
                    session.setAttribute("Favourite", favAlbum);
                    forward("/FavAlbum.jsp");
                    break;
                case "car":
                    Cart myCart = (Cart) session.getAttribute("Cart");
                    myCart.deleteSong(vieja);
                    session.setAttribute("Cart", myCart);
                    forward("/MyCart.jsp");
                    break;
                default:
                    Album myAlbum =(Album) session.getAttribute("Album");
                    myAlbum.deleteSong(vieja);
                    session.setAttribute("Album", myAlbum);
                    forward("/MyAlbum.jsp");
                    break;
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddSongCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(BorrarComand.class.getName()).log(Level.SEVERE, null, ex);
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
}
