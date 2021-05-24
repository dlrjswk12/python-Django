package com.java.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appll {
	
	
	@Bean
	public Student student1() {
	ArrayList<String> hobbys = new ArrayList<String>();
	hobbys.add("수영");
	hobbys.add("요리");
	
	Student student = new Student("홍길동1");
	student.setAge(10);
	student.setHobbys(hobbys);
	
	return student;
	
}
	@Bean
public Student student2() {

	ArrayList<String> hobbys = new ArrayList<String>();
	hobbys.add("영화감상");
	hobbys.add("독서");
	
	Student student = new Student("홍길동2");
	student.setAge(20);
	student.setHobbys(hobbys);
	
	return student;



}
	


}
