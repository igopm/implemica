package com.mi.implemica.task2;

import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by West on 26.05.2017.
 */
public class LoggerHelper {
    Hashtable<String, Logger> tableLoger = new Hashtable<String, Logger>();

    public static Logger createFileLoger(String nameLogger, String nameFile) {
        assert (nameLogger != null) : "Name of logger is empty";
        assert (nameFile != null) : "Name of file is empty";

        Logger log = null;
        try {
            FileHandler hand = new FileHandler(nameFile);
            hand.setFormatter(new SimpleFormatter());
            log = Logger.getLogger(nameLogger);
            log.addHandler(hand);
        } catch (IOException ex) {
            Logger.getLogger(LoggerHelper.class.getName()).
                    log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.err);
        } catch (SecurityException ex) {
            ex.printStackTrace(System.err);
        }
        return log;
    }
}