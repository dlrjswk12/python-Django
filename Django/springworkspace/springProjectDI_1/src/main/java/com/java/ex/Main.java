package com.java.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Appll.class);
	
		
	Student student1 = ctx.getBean("student1",Student.class);
	System.out.println(student1.getName());
	System.out.println(student1.getAge());
	System.out.println(student1.getHobbys());
	
	
	
	
	Student student2 = ctx.getBean("student2",Student.class);
	System.out.println(student2.getName());
	System.out.println(student2.getAge());
	System.out.println(student2.getHobbys());
		
	}

}
