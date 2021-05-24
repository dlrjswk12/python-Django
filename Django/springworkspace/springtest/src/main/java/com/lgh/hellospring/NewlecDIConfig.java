package com.lgh.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lgh.hellospring.entity.Exam;
import com.lgh.hellospring.entity.NewlecExam;


@ComponentScan({"com.lgh.hellospring.ui"})
@Configuration
public class NewlecDIConfig {
	
	@Bean
	public Exam xxxxx() {
		return new NewlecExam();
	}

}
