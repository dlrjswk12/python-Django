package com.vision.annotation_di;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.sjw.di.entity.Exam;
import com.sjw.di.entity.ExamList;
import com.sjw.di.ui.ExamConsole;
public class Program {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecAppConfig.class);
		
//		ExamConsole c1 = 
//				context.getBean(com.sjw.di.ui.GridExamConsole.class);
//		c1.print();
		
		ExamConsole c2 = 
				context.getBean(com.sjw.di.ui.InlineExamConsole.class);
		c2.print();
	
		//@Configuration 가 붙은 클래스에 @Bean으로 등록되어 있어야 한다 
		// 사용할 객체변수명은 무엇이던지 관계없다.
//		ExamList xes = 
//				context.getBean(com.sjw.di.entity.ExamList.class);
//		for (Exam x:xes) {
//			System.out.println(x);
//		}
		
	}
}
