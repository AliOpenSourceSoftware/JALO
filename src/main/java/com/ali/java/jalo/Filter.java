package com.ali.java.jalo;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.LogRecord;

 
 public class Filter implements java.util.logging.Filter { 
	 Vector<Level> acceptableLevels = new Vector<Level>();
	 public Filter(Vector<Level> acceptableLevels){
		 this.acceptableLevels = acceptableLevels;
		 
	 }
	 
 	public boolean isLoggable(LogRecord lr) { 
 		if(!acceptableLevels.contains(lr.getLevel())) return false; 
 		return true;
 	}
  

 } 
