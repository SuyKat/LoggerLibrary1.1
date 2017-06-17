package com.suyog.loglib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileSink extends Init implements MyLogger{
	private String namespace = "";
	FileSink(String ns){
		namespace = ns;
	}
	private void toFile(String message, String level) {
		try {
			FileOutputStream fout=new FileOutputStream(properties.getProperty(level.toLowerCase()+".file_location"), true);
			
			String dateFormatStr = properties.getProperty(level.toLowerCase()+".ts_format");
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
			
			Calendar cal = Calendar.getInstance();
			String s = dateFormat.format(cal.getTime())+" "+level+" "+namespace+" "+message+System.lineSeparator();    
            byte b[]=s.getBytes();//converting string into byte array    
            fout.write(b);    
            fout.close();    
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void debug(String message) {
		if(super.getPriority()<=DEBUG)
			this.toFile(message, "DEBUG");
	}

	@Override
	public void info(String message) {
		if(super.getPriority()<=INFO)
			this.toFile(message, "INFO");
	}

	@Override
	public void warn(String message) {
		if(super.getPriority()<=WARN)
			this.toFile(message, "WARN");
	}

	@Override
	public void error(String message) {
		if(super.getPriority()<=ERROR)
			this.toFile(message, "ERROR");
	}

	@Override
	public void fatal(String message) {
		if(super.getPriority()<=FATAL)
			this.toFile(message, "FATAL");
	}
}
