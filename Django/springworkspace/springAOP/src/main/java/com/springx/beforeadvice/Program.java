package com.springx.beforeadvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Program {
	public static void main(String[] args) {
		ApplicationContext context = 
				//new AnnotationConfigApplicationContext(NewlecAppConfig.class);
				new ClassPathXmlApplicationContext("com/springx/beforeadvice/setting.xml");
		// Exam exam = new NewlecExam(1,1,1,1); ==> xml로
		Exam proxy = (Exam) context.getBean("proxy");
		System.out.printf("total is %d\n",proxy.total());
		System.out.printf("avg is %f\n",proxy.avg());
			
	}
}
