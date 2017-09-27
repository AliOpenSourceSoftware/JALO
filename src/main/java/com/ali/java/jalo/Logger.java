package com.ali.java.jalo;

  
import java.util.Vector;   
import java.util.logging.Level; 
	
public class Logger { 
	public static java.util.logging.Logger jlogger =   java.util.logging.Logger.getLogger(Logger.class.getCanonicalName());
	public static String fileName=null;
	
	public Logger() {
		super();
		init();
	}

	public static boolean isInit = false;
	public static void init() {
	 
		if(!isInit){  
			LoggerHandler handler = new LoggerHandler(fileName); 
			Vector<Level> acceptableLevels = new Vector<Level>();
			acceptableLevels.add(Level.INFO);
			acceptableLevels.add(Level.SEVERE);
			java.util.logging.Filter filter  = new  Filter(acceptableLevels); 
			Formatter formatter = new Formatter(); 
			handler.setFilter(filter);
			handler.setFormatter(formatter);  
			jlogger.addHandler(handler); 
			jlogger.setUseParentHandlers(true);  
			isInit = true;
		} 
	}

	/**
	 * Info logging method
	 * @param msg
	 */
	public  void  infop(String msg){
		jlogger.log(Level.INFO ,msg); 
	}
	/**
	 * Info logging method
	 * @param caller
	 * @param method
	 * @param msg
	 */
	public  void  infop(Object caller, String method,String msg){
		if(caller!=null) {
			jlogger.logp(Level.INFO ,caller.getClass().getCanonicalName(),method,msg);
		}else {
			jlogger.logp(Level.INFO, this.getClass().getCanonicalName(), method, msg);
		}
	}
	 
	/**
	 * Static Info logging method
	 * @param caller
	 * @param method
	 * @param msg
	 */
	public  static void  info(Object caller, String method,String msg){
		if(caller!=null) {
			jlogger.logp(Level.INFO ,caller.getClass().getCanonicalName(),method,msg);
		}else {
			jlogger.logp(Level.INFO, Logger.class.getCanonicalName(), method, msg);
		}
	}
	
	/**  
	 * Static info logging 
	 * @param msg
	 */
	public static void  info(String msg){
		jlogger.log(Level.INFO ,msg); 
	}
	
	/**
	 * warning log
	 * @param msg
	 */
	public void  warningp(String msg){ 
		jlogger.log(Level.WARNING, msg);
	}
	
	/**
	 *  warning log
	 * @param msg
	 */
	public void  warningp(Object caller, String method, String msg){ 
		if(caller!=null) {
			jlogger.logp(Level.WARNING,caller.getClass().getCanonicalName(),method, msg);
		}	else {
			jlogger.logp(Level.WARNING, Logger.class.getCanonicalName(), method, msg);
		}
	}
	/**
	 *  warning log
	 * @param msg
	 */
	public static void  warning(Object caller, String method, String msg){ 
		if(caller!=null) {
			jlogger.logp(Level.WARNING,caller.getClass().getCanonicalName(),method, msg);
		}	else {
			jlogger.logp(Level.WARNING, Logger.class.getCanonicalName(), method, msg);
		}
	}
	
	/**
	 * Static Warning log
	 * @param msg
	 */
	public static void  warning(String msg){ 
		jlogger.log(Level.WARNING, msg);
	}
	
	/**
	 * error log
	 * @param msg
	 */
	public static void  error(String msg){
		jlogger.severe(msg);	
	}
	public static void  error(Object caller, String method, String msg){
		if(caller !=null)
			jlogger.logp(Level.SEVERE, caller.getClass().getCanonicalName(), method, msg);  
		else {
			jlogger.logp(Level.SEVERE, Logger.class.getCanonicalName(), method, msg);
		}
	}
	/**
	 * error log
	 * @param msg
	 */
	public  void  errorp(String msg){
		jlogger.severe(msg);	
	}
	/**
	 * error log
	 * @param msg
	 */
	public  void  errorp(Object caller, String method, String msg){
		if(caller!=null) {
			jlogger.logp(Level.SEVERE, caller.getClass().getCanonicalName(), method, msg);  
		}	else {
			jlogger.logp(Level.SEVERE, this.getClass().getCanonicalName(), method, msg);
		}
	}
	/**
	 * error log
	 * @param msg
	 */
	public  void  errorp(Object caller, String method, String msg, Exception e){
		if(caller!=null) {
			jlogger.logp(Level.SEVERE, caller.getClass().getCanonicalName(), method, msg,e);  
		}	else {
			jlogger.logp(Level.SEVERE, this.getClass().getCanonicalName(), method, msg,e);
		}
	}
	
	 
	
	public  static void  error(Object caller, String method, String msg, Exception e){
		if(caller!=null) {
			jlogger.logp(Level.SEVERE, caller.getClass().getCanonicalName(), method, msg,e);  
		}	else {
			jlogger.logp(Level.SEVERE, Logger.class.getCanonicalName(), method, msg);
		}
	}
	
	
	public  static void  severe(Object o,String method, String msg,Exception ex){
		 
		if(o ==null){
				jlogger.logp(Level.SEVERE,Logger.class.getCanonicalName().toString(),method, msg,ex);
		}else{ 
			jlogger.logp(Level.SEVERE,o.getClass().getCanonicalName(),method, msg, msg+ex.getMessage());
		}
		
	}  
	public  static void  severep(Object o,String method, String msg,Exception ex){
		 
		if(o ==null){
				jlogger.logp(Level.SEVERE,Logger.class.getCanonicalName().toString(),method, msg,ex);
		}else{ 
			jlogger.logp(Level.SEVERE,Logger.class.getCanonicalName(),method, msg, msg+ex.getMessage());
		}
		
	}  
	public static java.util.logging.Logger getLogger(String string) {
		return java.util.logging.Logger.getLogger(string);
	}

	public  void logp(Level level, String msg) {
		jlogger.log(level, msg);
		
	}
	public  void logp( String msg) {
		jlogger.log(Level.INFO, msg);
		
	}
	public  static void log(Level level, String msg) {
		jlogger.log(level, msg);
		
	}
	public  static void log( String msg) {
		jlogger.log(Level.INFO, msg);
		
	}
}
