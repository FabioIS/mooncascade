/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontServlet;

import comands.UnknownCommand;
import beans.LogBean;
import comands.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1996f
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @EJB
    private LogBean log;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        log.writeLog("Servlet", "processResquest");
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();
       
    }

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        try {
            log.writeLog("Servlet", "doGet");
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        try {
            log.writeLog("Servlet", "processResquest");
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    private FrontCommand getCommand(HttpServletRequest request){
        try {
        log.writeLog("Servlet", "processResquest");
        FrontCommand f=(FrontCommand) getCommandClass(request).newInstance();
        return f;
        }catch(IllegalAccessException | InstantiationException | NamingException e) {
           // throw new ApplicationException(e);
        }        
        return null;
    }
private Class getCommandClass(HttpServletRequest request) throws NamingException{
    Class result;
    final String command = "comands."+(String)request.getParameter("command");
    try {
    result = Class.forName(command);
    log.writeLog("Servlet", "processResquest");
    }
    catch(ClassNotFoundException e) {
        result = UnknownCommand.class;
    }
    return result;
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
