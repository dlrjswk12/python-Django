package com.sjw.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sjw.di.entity.Exam;

@Component
public class GridExamConsole implements ExamConsole {
	@Autowired
	private Exam exam;
	
	public GridExamConsole() {}
	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.println(exam);
		System.out.print("=====================\n");
		System.out.print("total\taverage\n");
		System.out.print("=====================\n");
		System.out.printf("%d\t%f\n",exam.total(),exam.avg());
		System.out.print("=====================\n");
	}
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
