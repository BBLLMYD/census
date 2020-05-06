package record.learn.ram;

import java.util.Random;

public class MyTest4 {

	public static void main(String[] args) {
		System.out.println(FinalTest4.i);
	}
	
}


class FinalTest4{
	
	//编译时无法确定, 所以属于编译时final变量,会加载当前类,static块会执行
	public static int i = 3;
	static{
		System.out.println("没有final不属于常量, 会执行static");
	}
}
