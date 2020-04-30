package record.learn.dynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyCG2 {

	public static void main(String[] args) throws Throwable {
		Class<? extends Super> clz = null;
		while(true){ 
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(Super.class);
			enhancer.setUseCache(false);	//默认是true,true时不生成新的代理对象的子类,不会出现perm区OOM
			enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
				Object invoke = proxy.invokeSuper(obj, args1);
				return invoke;
			}
			);
			Super proxy = (Super)enhancer.create();
			if(clz!=null){
				System.out.println( proxy.getClass().getSuperclass().getName() );
				System.out.println( clz.getName() );
				System.out.println( proxy.getClass().getSuperclass().getName() == clz.getName() );
				break;
			}
			clz = proxy.getClass();
//			System.err.println(clz.getName());
		}
	}
	
	static class Super{
		void doSth(String str){
//			System.out.println(this.getClass().getName()+"-----"+str);
		}
	}
	
}

