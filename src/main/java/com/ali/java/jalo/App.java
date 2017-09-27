package com.ali.java.jalo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         Logger.initializeLogging();
         Logger.info("info");
         Logger.error("Error");
         Logger.logSevre(null, "main", "sever");
         Logger.logSevre(null, null, "sever");
    }
    
    
}
