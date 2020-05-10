package record.learn.classloader.dispatch.invokeType;

import java.lang.invoke.MethodHandle;
import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.MethodType;

public class Test {

	class GrandFather{
		void thinking(){
			System.out.println("i am grandfather");
		}
	}
	class Father extends GrandFather{
		void thinking(){
			System.out.println("i am father");
		}
	}
	class Son extends Father{
		void thinking(){
			try{
				MethodType mt = MethodType.methodType(void.class);
				MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
				mh.invoke(this);
			}catch(Throwable t){
			}
		}
	}
	public static void main(String[] args) {
		(new Test().new Son()).thinking();
	}
}
