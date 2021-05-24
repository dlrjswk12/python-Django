package com.java.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
	
		
		String configLoc = "classpath:app.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		 MyCal mycal = ctx.getBean("myCal", MyCal.class);
		
		 mycal.add();
	}

}
