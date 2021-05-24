package com.lgh.hellospring.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lgh.hellospring.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	@Autowired // 자동객체 연결
	//@Qualifier("exam2")
	private Exam exam;
	
	public InlineExamConsole() {
		//System.out.println("constructor");
	}
	
	
	public InlineExamConsole(Exam exam) {
		//System.out.println("over load constructor");
		this.exam = exam;
	}



	@Override
	public void print() {
		
		System.out.println(exam);
			System.out.printf("total is %d, avg is %f\n", exam.total(),exam.avg());
		
		
	}
	
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}


	
	
}
