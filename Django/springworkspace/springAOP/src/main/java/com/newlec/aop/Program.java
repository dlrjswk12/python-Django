package com.newlec.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		Exam exam = new NewlecExam(1,1,1,1);//invoke시 사용할 객체
		Exam proxy = (Exam) Proxy.newProxyInstance(
			NewlecExam.class.getClassLoader(), // 주된관심사
			new Class[] {Exam.class}, // 주관심사 인터페이스 
			new InvocationHandler() {

				@Override
				public Object invoke(Object proxy, Method method, Object[] args) 
						throws Throwable {
					long start = System.currentTimeMillis();// 횡관심사
					
					///////////////////////////////////////////////////
					Object result = method.invoke(exam, args);// 주관심사
					///////////////////////////////////////////////////
					
					long end = System.currentTimeMillis(); // 횡관심사 ///
					String message = (end-start)+"ms 시간이 걸렸습니다.";
					System.out.println(message);///////////////////////
					
					return result;
				}
				
			});
		
		System.out.printf("total is %d\n",exam.total());
		System.out.printf("avg is %f\n",exam.avg());
		//----------------------------------------
		System.out.printf("total is %d\n",proxy.total());
		System.out.printf("avg is %f\n",proxy.avg());

	}

}
