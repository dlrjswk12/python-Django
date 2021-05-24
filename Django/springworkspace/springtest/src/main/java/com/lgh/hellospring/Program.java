package com.lgh.hellospring;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lgh.hellospring.entity.Exam;
import com.lgh.hellospring.entity.NewlecExam;
import com.lgh.hellospring.ui.ExamConsole;
import com.lgh.hellospring.ui.GridExamConsole;
import com.lgh.hellospring.ui.InlineExamConsole;


public class Program {
	
	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경
		Exam exam = new NewlecExam();
		Exam exam = new NewlecExam(10,10,10,10);
	//	ExamConsole console = new InlineExamConsole(exam); // DI
		ExamConsole console = new GridExamConsole();
		
		console.setExam(exam);
		 */	
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
//				new ClassPathXmlApplicationContext("com/lgh/hellospring/setting.xml ");
		
		//Exam exam = context.getBean(Exam.class); 			//Bean 과 Vo는 같다고 본다
		//System.out.println(exam.toString()); 
		
		//ExamConsole console = (ExamConsole) context.getBean("console"); // 형시변환 이름으로 꺼낸것
		 ExamConsole console =  context.getBean(com.lgh.hellospring.ui.InlineExamConsole.class);
		console.print();
		
		//List<Exam> exams = new ArrayList<>();
		//exams.add(new NewlecExam(1,1,1,1));
		
		//for(Exam e: exams)
		//	System.out.println(e);
		
		
	}
	
}
