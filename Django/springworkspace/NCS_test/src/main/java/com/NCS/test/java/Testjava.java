package com.NCS.test.java;

import javax.swing.JOptionPane;

public class Testjava {

	public static void main(String[] args) {
	
		//inputData();
		System.out.println(inputData());
		
		
	}

	public static String inputData() {
		
		String score = JOptionPane.showInputDialog("점수을 입력");
		String name = JOptionPane.showInputDialog("이름을 입력");
		
		int realScore = Integer.parseInt(score);
		
		String grade = "";
		
		if (realScore>=90) {
			grade = "A";
		}else if (realScore>=80) {
			grade = "B";
		}else if (realScore>=70) {
			grade = "C";
		}else if (realScore>=60) {
			grade = "D";
		}else {
			grade = "재수강";
		}
		
		
		return grade;
	}
	
	
}
