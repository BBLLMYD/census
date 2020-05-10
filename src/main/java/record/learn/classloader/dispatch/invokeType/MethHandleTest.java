package record.learn.classloader.dispatch.invokeType;
import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class MethHandleTest {

	static class ClassA{
		public void println(String s){
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws Throwable {
		Object o = System.currentTimeMillis()%2 == 0 ? System.out : new ClassA();
		getPrintlnMH(o).invokeExact("icyfenix");
		
	}
	
	private static MethodHandle getPrintlnMH(Object reveiver)throws Throwable{
		MethodType mt = MethodType.methodType(void.class,String.class);
		return lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
	}
	
}
