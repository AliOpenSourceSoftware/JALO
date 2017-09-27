package com.ali.java.jalo; 

import java.io.File;
import java.io.FileOutputStream; 
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar; 
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
 

/**
 * Custom logger to export to a file
 * @author AARONAli
 *
 */
public class LoggerHandler extends Handler {

	private FileOutputStream fileOutputStream;
	private PrintWriter printWriter;
	
	
	 
	/**
	 * Creates the logger handler to output the logs at the given location
	 * @param filename
	 */
	public LoggerHandler(String fileName) {
		super();
		Path p = null;
		Calendar calendar = Calendar.getInstance();
		// check input parameter
		if (fileName == null || fileName == "") { 
			try { System.out.println(" Creating path for file ");}catch(Exception e) {}
			p = Paths.get("");
			System.out.println(p.getFileName().toAbsolutePath());
			try { Paths.get("").toAbsolutePath().normalize().toFile().mkdirs();}catch(Exception e) {}
		   
			fileName = p.getFileName().toAbsolutePath().toString()+File.separator+calendar.get(Calendar.YEAR)+"_"+calendar.get(Calendar.MONTH) + "_" 
					+ calendar.get(Calendar.DAY_OF_MONTH) + "_H" + calendar.get(Calendar.HOUR_OF_DAY)
					+ "_M" + calendar.get(Calendar.MINUTE) + "_S" + calendar.get(Calendar.SECOND)   
					+ "_ML" + calendar.get(Calendar.MILLISECOND)+".log.txt";  
		} 
		try { 
			try {  System.out.println("Creating logger file");}catch(Exception e) {};
			 File f = new File(fileName);
			 if(!f.exists()) {
				 try {
				 p = Paths.get(fileName);
				 p.getParent().toFile().mkdirs();			 		
				 f.createNewFile();//fileOutputStream =  f. new FileOutputStream(f);
				 }catch(Exception e) {
					 e.printStackTrace();
				 }
			 }
			fileOutputStream =  new FileOutputStream(fileName,true);
			printWriter = new PrintWriter(fileOutputStream);
			setFormatter(new SimpleFormatter());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	

	/* (non-API documentation)
	 * @see java.util.logging.Handler#publish(java.util.logging.LogRecord)
	 */
	public void publish(LogRecord record) {
		// ensure that this log record should be logged by this Handler
		if (!isLoggable(record))
			return;
		
		// Output the formatted data to the file
		printWriter.println(getFormatter().format(record));
		outToConsole( record);
		flush();
	}

	/* (non-API documentation)
	 * @see java.util.logging.Handler#flush()
	 */
	public void flush() {
		printWriter.flush();
	}

	/* (non-API documentation)
	 * @see java.util.logging.Handler#close()
	 */
	public void close() throws SecurityException {
		printWriter.close();
	}
	
	private void outToConsole(LogRecord record){
		if(record.getLevel()==Level.INFO){ 
			try { System.out.println( record.getMessage()); }catch(Exception e) {} 
		}
		 
	}
	 

}