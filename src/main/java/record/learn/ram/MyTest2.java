package record.learn.ram;

public class MyTest2 {

	public static void main(String[] args) throws Exception {
		// Class.forName("census.jvm.FinalTest");
		System.out.println(FinalTest.i);
	}

}

class FinalTest {

	// 编译时常量, 首次使用此final常量,是不会导致类被初始化的
	public static final int i = 9 / 3;

	// 是否对类进行初始化,就是静态代码块是否执行
	static {
		System.out.println("编译时常量, 首次使用此常量,是不会导致类被初始化的, 因为编译时就已经确定了数值, 无需初始化当前类");
	}
}
