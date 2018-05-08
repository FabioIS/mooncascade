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
public class CreditCard {

    private Stadistics stadistics;

    private LogBean log;

    public boolean verifyWrong(String creditCardNumber) throws NamingException {
        log.writeLog("CreditCard", "verifyWrong");
        if (creditCardNumber != null) {
            if(creditCardNumber.length() == 8) return true;
        }
        return false;
    }

    @PostConstruct
    public void postConstruct() {

        try {
            stadistics = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/Stadistics");
            log = InitialContext.doLookup("java:global/Practica2_AS/Practica2_AS-ejb/LogBean");
            stadistics.addCreditCard();
            log.writeLog("CreditCard", "postContruct");
        } catch (NamingException ex) {
            Logger.getLogger(CreditCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        log.writeLog("CreditCard", "preDestroy");
        System.out.println("PreDestroy");
    }

    @PostActivate
    public void PostActive() {
        log.writeLog("CreditCard", "PostActivate");
        System.out.println("PostActivate");
    }

    @Remove
    public void remove() {
        log.writeLog("CreditCard", "remove");
        System.out.println("Remove");
    }

}
