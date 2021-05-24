package com.dywlr.mem.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormUtil {

	public static List<String> sexual(){
		List<String> list = Arrays.asList("남", "여");
		return list;
	}
	
	public static List<String> tel(){
		List<String> list = Arrays.asList("kt", "lg","skt");
		return list;
	}
	
	public static List<String> category(){
		List<String> list = Arrays.asList("국어","수학","영어","과학","사회","수학논술","국어논술","영어논술","영어회화","프로그래밍","미술입시","체육입시","음악입시");
		list = new ArrayList<>(list);
		return list;
 	}
	
	public static List<String> locale(){
		List<String> list = Arrays.asList("서울","경기","인천","충북","충남","강원","경북","경남","대구","울산","포항","부산","전남","전북","광주");
		list = new ArrayList<>(list);
		return list;
 	}
	
	public static List<String> attend(){
		List<String> list = Arrays.asList("재학","휴학","졸업","중퇴","자퇴","해당없음");
		list = new ArrayList<>(list);
		return list;
 	}
	
	
	
	
}
