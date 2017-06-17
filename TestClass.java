package com.testclient;

import com.suyog.loglib.LoggerManager;
import com.suyog.loglib.MyLogger;

public class TestClass {

	static int divide(int a, int b){
		return a/b;
	}
	
	public static void main(String[] args) {
		LoggerManager lm = new LoggerManager();
		MyLogger log = lm.getInstance(TestClass.class.getName());
		log.info("We are doing a division");
		try{
			int z = divide(9, 0);
		}catch(Exception e){
			log.error("Divide by zero exception");
		}
		log.info("End of the code");
	}
	

}
