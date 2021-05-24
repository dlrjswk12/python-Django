package com.lgh.hellospring.ui;

import com.lgh.hellospring.entity.Exam;

public class GridExamConsole implements ExamConsole {

	
	private Exam exam;
	
	public GridExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	public GridExamConsole(Exam exam) {
		
		this.exam = exam;
	}


	@Override
	public void print() {
		
		
		System.out.printf("total is %d, avg is %f\n", exam.total(),exam.avg());
		System.out.println("이것은 그리드 로 출력이다");

	}


	public Exam getExam() {
		return exam;
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}
	
	
	

}
