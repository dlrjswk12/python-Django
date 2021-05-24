package com.springx.pointcut2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// 필요한 매개변수 활용 
		
		System.out.println("returnValue:"+returnValue+", method:"+method.getName());
		
	}

}
