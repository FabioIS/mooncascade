/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Remove;
import javax.ejb.Schedule;
import javax.naming.NamingException;

/**
 *
 * @author 1996f
 */
@Singleton
@LocalBean
public class LogBean {
    
    String log = "";
    String auxLog = "";
    
    public void writeLog(String className, String method){
        log += className + "::" + method + "::" + "\n";
    }
    
    public String getLog(){
        return log;
    }
    
   // @Schedule(second = "*/5", minute = "*", hour = "*")
   /* private void writeLogToFile() throws IOException {
        File file = new File("C:\\Users\\1996f\\OneDrive\\Documentos\\NetBeansProjects\\Practica2_AS\\log.txt");
        BufferedWriter output;
        output = new BufferedWriter(new FileWriter(file));
        output.write(log);
        output.close();
    } */ 
    
    @Schedule(second = "*/5", minute = "*", hour = "*")
    public void blockMoreThanFiveSeconds(){
        if (log.length() == auxLog.length()) {
            this.writeLog("LogBean", "blockMoreThanFiveSeconds");
        } else {
            auxLog = log;
        }
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy");
    }

    @PostActivate
    public void PostActive() {
        System.out.println("PostActivate");
    }

    @Remove
    public void remove() {
        System.out.println("Remove");
    }
    

}
