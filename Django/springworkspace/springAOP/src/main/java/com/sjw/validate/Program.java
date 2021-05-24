package com.sjw.validate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		//Confirm confirm = new Login();//invoke시 사용할 객체
		Confirm confirm = new LookPay();//invoke시 사용할 객체
		Confirm proxy = (Confirm) Proxy.newProxyInstance(
				LookPay.class.getClassLoader(), // 주된관심사
			new Class[] {Confirm.class}, // 주관심사 인터페이스 
			new InvocationHandler() {

				@Override
				public Object invoke(Object proxy, Method method, Object[] args) 
						throws Throwable {
					///////////////////////////////////////////////////
					Object result = method.invoke(confirm, args);// 주관심사
					///////////////////////////////////////////////////
					return null;
				}
			});
		proxy.confirm("admin", "1212");
	}
}