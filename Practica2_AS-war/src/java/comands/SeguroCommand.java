/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author 1996f
 */
public class SeguroCommand extends FrontCommand{
    @Override
    public void process() {
        try {
            forward("/Seguro.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddSongCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
