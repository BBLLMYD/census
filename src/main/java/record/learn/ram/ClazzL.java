package record.learn.ram;

public class ClazzL {

	public static void main(String[] args) throws Throwable {
		Class<?> clazz = Class.forName("census.jvm.ClazzL");
		Class<?> clazz2 = Class.forName("java.lang.String");
		ClassLoader loader = clazz.getClassLoader();
		ClassLoader loader2 = clazz2.getClassLoader();
		System.err.println(loader);//系统类加载器
		System.err.println(loader2);//跟类加载器
	}
	
}
