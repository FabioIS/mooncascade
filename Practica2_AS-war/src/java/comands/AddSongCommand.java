/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comands;

import beans.Album;
import beans.Cart;
import beans.CreditCard;
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
public class AddSongCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            HttpSession session = request.getSession();
            CreditCard card = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/CreditCard");
            if (card.verifyWrong(request.getParameter("cardNumber")) == false) {
                request.setAttribute("error", "wrongCard");
                forward("/Payment.jsp");
            }
            Album myAlbum = (Album) session.getAttribute("Album");
            if (myAlbum == null) {
                myAlbum = lookupAlbumBean();
            }
            Cart myCart = (Cart) session.getAttribute("Cart");
            for (int i = 0; i < myCart.size(); i++) {
                myAlbum.addSong(myCart.getSong(i));

            }
            myCart.empty();
            session.setAttribute("Album", myAlbum);
            forward("/MyAlbum.jsp");
        } catch (ServletException | IOException | NamingException ex) {
            Logger.getLogger(AddSongCommand.class.getName()).log(Level.SEVERE, null, ex);
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
