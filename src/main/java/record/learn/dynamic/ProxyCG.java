package record.learn.dynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyCG {

	public static void main(String[] args) {
		while(true){
			CglibProxy cpe = new CglibProxy();
	        Super obj = cpe.getProxy(Super.class);
	        System.err.println(obj.getClass());
	        obj.dosth("do sth");//调用逻辑处理方法
		}
	}
	
}
	class CglibProxy implements MethodInterceptor {
		@Override
		public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
			//CGLIB反射调用真实对象方法
			System.out.println("front");
			Object result = methodProxy.invokeSuper(proxy, args);
			System.out.println("after");
			return result;
		}
	
		/**
		 * 生成CGLIB代理对象
		 */
		@SuppressWarnings("unchecked")
		public <T> T getProxy(Class<?> cls){
			//CGLIB enhancer 增强类对象
			Enhancer enhancer = new Enhancer();
			//设置增强类型
			enhancer.setSuperclass(cls);
			//定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor方法
			enhancer.setCallback(this);
			enhancer.setUseCache(false);
			//生成并返回代理对象
			return (T)enhancer.create();
		}
	}

	class Super {
	    private String sth = "";
	    public void dosth(String dosth){
	        System.out.println(dosth);
	    }
	    public String getName() {
	        return sth;
	    }
	    public void setName(String name) {
	        this.sth = name;
	    }
	}

