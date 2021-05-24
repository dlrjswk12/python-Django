package com.sjw.di.entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ExamList extends ArrayList<Exam>{
	public ExamList() {
		add(new NewlecExam("구길동",45,45,45,45));
		add(new NewlecExam("박길동",75,75,75,75));
		add(new NewlecExam("정길동",85,85,85,85));
		add(new NewlecExam("윤길동",95,95,95,95));
		add(new NewlecExam("홍길동",49,49,49,49));
	}
}
