package com.lgh.Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Aoptest {

	public static void main(String[] args)
		throws InstantiationException, IllegalAccessException	{
		IProc proxy = getProxy(Sum.class, IProc.class);
		System.out.println("total:"+ proxy.execute(1,1000000));
		System.out.println("==================");
		IProc x = getProxy(Gugudan.class, IProc.class);
		System.out.println(x.execute(55,66,77,88,99));

	}

	private static IProc getProxy(Class exec, Class proxy)
			throws InstantiationException, IllegalAccessException {
		final IProc proc = (IProc) exec.newInstance(); // new Sum(), new Gugudan() 과 같음
		IProc res = (IProc) Proxy.newProxyInstance(
				exec.getClassLoader(),
				new Class[] { proxy },
				new InvocationHandler() {  // 익명 클래스
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					long start = System.currentTimeMillis();
					// 주관심사 실행 ------------------------
					Object result = method.invoke(proc, args);
					//-------------------------------------
					long end = System.currentTimeMillis();
					String message = (end - start) + "ms 시간이 걸림";
					System.out.println(message);
					return result;
				}
				
				
	});
		return res;
	
}
}

