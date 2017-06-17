package com.suyog.loglib;

public class LoggerManager extends Init{
	public MyLogger getInstance(String namespace){
		if(super.getSinkType().equals("File") )
			return new FileSink(namespace);
		else if(super.getSinkType().equals("Console"))
			return new ConsoleSink(namespace);
		else return null;
	}	
}