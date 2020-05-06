package record.learn.ram;

import java.util.Random;

public class MyTest3 {

	public static void main(String[] args) {
		System.out.println(FinalTest2.i);
	}
	
}


class FinalTest2{
	
	//编译时无法确定, 所以属于编译时final变量,会加载当前类,static块会执行
	public static final int i = new Random().nextInt(100);
	static{
		System.out.println("编译时无法确定, 所以属于编译时变量,会加载当前类,static块会执行");
	}
}
