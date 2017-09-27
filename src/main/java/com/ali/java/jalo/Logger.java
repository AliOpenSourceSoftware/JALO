package com.ali.java.jalo;

  
import java.util.Vector;   
import java.util.logging.Level; 
	
public class Logger { 
	public static java.util.logging.Logger logger =   java.util.logging.Logger.getLogger(Logger.class.getCanonicalName());

	public Logger() {
		super();
	}

	public static boolean isInit = false;
	public static void initializeLogging() {
	 
		if(!isInit){
			System.out.println("Initilizing logger"); 
			LoggerHandler handler = new LoggerHandler(null); 
			Vector<Level> acceptableLevels = new Vector<Level>();
			acceptableLevels.add(Level.INFO);
			acceptableLevels.add(Level.SEVERE);
			java.util.logging.Filter filter  = new  Filter(acceptableLevels); 
			Formatter formatter = new Formatter(); 
			handler.setFilter(filter);
			handler.setFormatter(formatter);  
			logger.addHandler(handler); 
			logger.setUseParentHandlers(true); 
			try{ System.out.println("Logger initilaized");}catch(Exception e) {}; 
			isInit = true;
		}else{
			try{ System.out.println("Already initilaized");}catch(Exception e) {};
		} 
	}

	/**
	 * Info logging method
	 * @param msg
	 */
	public  void  infop(String msg){
		 logger.log(Level.INFO ,msg); 
	}
	
	/**  
	 * Static info logging 
	 * @param msg
	 */
	public static void  info(String msg){
		 logger.log(Level.INFO ,msg); 
	}
	
	/**
	 * Static warning log
	 * @param msg
	 */
	public void  warning(String msg){ 
		logger.log(Level.WARNING, msg);
	}
	
	/**
	 * Static Warning log
	 * @param msg
	 */
	public static void  warningp(String msg){ 
		logger.log(Level.WARNING, msg);
	}
	
	/**
	 * error log
	 * @param msg
	 */
	public static void  error(String msg){
		logger.severe(msg);	
	}
	
	/**
	 * Static error log
	 * @param msg
	 */
	public void  errorp(String msg){
		logger.severe(msg);	
	}
	
	public  static void  logSevre(Object o,String method, String msg){
		try {
			
			if(o ==null)
				logger.logp(Level.SEVERE,method, msg, msg);
			logger.logp(Level.SEVERE,o.getClass().toString(),method, msg);
		}catch(NullPointerException e) {
			logger.logp(Level.SEVERE,method, msg, msg);
		}
		
	}  

	public static java.util.logging.Logger getLogger(String string) {
		return java.util.logging.Logger.getLogger(string);
	}

	public static void logp(Level level, String msg) {
		logger.logp(level, null,null, msg);
		
	}

}
