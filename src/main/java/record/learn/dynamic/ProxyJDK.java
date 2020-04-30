package record.learn.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyJDK {
	public static void main(String[] args) {
		Subject subject1 = new RealSubject();
		Subject subject2 = new RealSubject();
		Subject proxyIns1 = SubjectDynamicProxy.newProxyIns(subject1);
		Subject proxyIns2 = SubjectDynamicProxy.newProxyIns(subject2);
		// proxyIns.doSth();
		System.out.println(proxyIns1.getClass());
		System.out.println(proxyIns2.getClass());
		System.out.println(proxyIns2.getClass().equals(proxyIns1.getClass()));
		
	}
}

class RealSubject implements Subject {
	@Override
	public void doSth() {
		System.out.println("real subject dosth");
	}
}

interface Subject {
	void doSth();
}

class MyInvacationHandler implements InvocationHandler {
	private Object obj;

	public MyInvacationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(obj, args);
	}

}

class DynamicProxy<T> {
	public static <T> T newProxyIns(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler) {
		if (true) {
			new BeforeIAdvice().exec();
		}
		return ((T) Proxy.newProxyInstance(loader, interfaces, handler));
	}
}

interface IAdvice {
	void exec();
}

class BeforeIAdvice implements IAdvice {	
	@Override
	public void exec() {
		System.err.println("front already exec");
	}
}

class SubjectDynamicProxy extends DynamicProxy<Subject> {
	public static <T> T newProxyIns(Subject subject) {
		ClassLoader loader = subject.getClass().getClassLoader();
		Class<?>[] interfaces = subject.getClass().getInterfaces();
		MyInvacationHandler myInvacationHandler = new MyInvacationHandler(subject);
		return newProxyIns(loader, interfaces, myInvacationHandler);
	}
}

