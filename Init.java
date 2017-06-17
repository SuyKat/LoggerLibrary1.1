package com.suyog.loglib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Init {
	private File file;
	private FileInputStream fileInput = null;
	Properties properties;
	private int priority;
	private String sinkType;	
       
	Init() {
		// TODO Auto-generated constructor stub
		try{
	    	file = new File("Properties/config.properties");
			fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			priority = Integer.parseInt(properties.getProperty("logging.priority"));
			sinkType = properties.getProperty("sink.type");
			
	    }
	    catch(FileNotFoundException e){
	    	e.printStackTrace();
	    }catch(IOException e){
	    	e.printStackTrace();
	    }
	}
	public int getPriority(){
		return priority;
	}
	public String getSinkType(){
		return sinkType;
	}
}
