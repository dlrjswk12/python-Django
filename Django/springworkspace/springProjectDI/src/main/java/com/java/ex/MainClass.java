package com.java.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:app.xml");
		Pencil pencil111 = ctx.getBean("pencil",Pencil.class);
		pencil111.use();
		
		
		ctx.close();
	}

}
