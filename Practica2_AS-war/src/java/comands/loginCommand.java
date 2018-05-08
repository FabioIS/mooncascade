/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1996f
 */
public class loginCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if(password.equals("1234")){
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            forward("/ListSong.jsp");
        }else{
            forward("/index.jsp");
        }
    }  
}
