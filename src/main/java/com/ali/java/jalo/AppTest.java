package com.ali.java.jalo;

/**
 * Hello world!
 *
 */
public class AppTest
{
    public static void main( String[] args )
    {
    	Object caller =  new AppTest(); 
    	String msg = "message";
    	String method = "main"; 
    	Logger logger = new Logger();
    	Exception e = new RuntimeException("Runtime Error");
         Logger.init();
         Logger.info("INFO LOG");
         Logger.error("ERROR LOG");
         Logger.severe(AppTest.class,method, "err",e); 
         Logger.error(null, null, "SEVER LOG");
         Logger.info(msg);
         Logger.info( caller,  method, msg+"3");
         Logger.warning(msg+"2");
         Logger.warning(caller,  method,  msg+"1");
         Logger.error(msg+"4");
         Logger.error(caller,  method,  msg+"5");
         Logger.error(caller, method,  msg, e) ;  
         logger.infop(msg);
         logger.infop( caller,  method, msg) ;
         logger.warningp(msg+"W");
         logger.warningp(caller, method,  msg+"X") ;
         logger.errorp(msg);
         logger.errorp(caller, method,  msg)	 ;
         logger.errorp(caller, method,  msg, e);
         
         Logger.info(msg);
         Logger.info( caller,  method, msg)  ;
         Logger.warning(msg);
         Logger.warning(caller,  method,  msg) ;
         Logger.error(msg);
         Logger.error(caller,  method,  msg);
         Logger.error(caller, method,  msg, e) ;

         
         logger.infop(msg);
         logger.infop( caller,  method, msg);
         logger.warningp(msg);
         logger.warningp(caller, method,  msg) ;
         logger.errorp(msg);
         logger.errorp(caller, method,  msg)	; 
         logger.errorp(caller, method,  msg, e) ;
          
    }
    
    
}
