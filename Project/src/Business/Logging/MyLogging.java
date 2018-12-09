/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logging;

import java.io.IOException;
import java.util.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Charmy
 */
public class MyLogging {
   
    static Logger logger;
    public Handler fileHandler;
    SimpleFormatter plainText;
    
    
     private MyLogging() throws IOException{
        //instance the logger
        logger = Logger.getLogger(MyLogging.class.getName());
        //instance the filehandler
        fileHandler = new FileHandler("myLog.txt",true);
        //instance formatter, set formatting, and handler
        plainText = new SimpleFormatter();
        fileHandler.setFormatter(plainText);
        logger.addHandler(fileHandler);

    }
     private static Logger getLogger(){
    if(logger == null){
        try {
            new MyLogging();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return logger;
}
    public static void log(Level level, String msg){
    getLogger().log(level, msg);
    System.out.println(msg);
    }
}
