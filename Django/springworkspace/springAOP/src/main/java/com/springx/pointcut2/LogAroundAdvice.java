package com.springx.pointcut2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start = System.currentTimeMillis();// 횡관심사
		
		///////////////////////////////////////////////////
		//Object result = method.invoke(exam, args);// 주관심사
		Object result = invocation.proceed();
		///////////////////////////////////////////////////
		
		long end = System.currentTimeMillis(); // 횡관심사 ///
		String message = (end-start)+"ms 시간이 걸렸습니다.";
		System.out.println(message);///////////////////////
		
		return result;
	}

}
