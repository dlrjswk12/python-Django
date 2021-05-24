package cop.sjw.aop;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		IProc proxy = getProxy(Sum.class,IProc.class);
		System.out.println("total:"+proxy.execute(1, 100000000));
		System.out.println("=================================");
		IProc x = getProxy(GuguDan.class,IProc.class);
		System.out.println(x.execute(55,66,77,88,99));
	}
	
	
	public static IProc getProxy(Class exec,Class proxy) throws InstantiationException, IllegalAccessException {
		final IProc proc = (IProc) exec.newInstance();
		IProc res = (IProc)Proxy.newProxyInstance(exec.getClassLoader(), new Class[] {proxy},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						long start = System.currentTimeMillis();
						
						Object result = method.invoke(proc, args);
						
						long end = System.currentTimeMillis();
						String message = (end-start)+"ms 시간이 걸렸습니다.";
						System.out.println(message);
						return result;
					}
		});
		return res;
	}
}
