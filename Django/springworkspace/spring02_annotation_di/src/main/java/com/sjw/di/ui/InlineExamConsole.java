package com.sjw.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sjw.di.entity.Exam;
@Component
public class InlineExamConsole implements ExamConsole {
	@Autowired
	private Exam exam;
	
	public InlineExamConsole() {}
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}
	@Override
	public void print() {
		System.out.println(exam);
		System.out.printf("total is %d, average id %f\n",exam.total(),exam.avg());
	}
}
