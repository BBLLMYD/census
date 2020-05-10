package record.learn.classloader.dispatch.astatic;

/**
 * 方法静态分派
 *
 * @author: mqw   
 * @date:   2018年8月13日 下午4:48:29
 */
public class StaticDispatch {

	static abstract class Human{
	}
	
	static class Man extends Human{
	}
	
	static class Woman extends Human{
	}

	public void sayhello(Human man){
		System.out.println("hi guy");
	}
	public void sayhello(Woman man){
		System.out.println("hi man");
	}
	public void sayhello(Man man){
		System.out.println("hi wuman");
	}
	public StaticDispatch(){
	}
	
	public static void main(String[] args) {
		Human man = new Man();
		Human wman = new Woman();
		StaticDispatch dispatch = new StaticDispatch();
		dispatch.sayhello(man);
		dispatch.sayhello(wman);
	}
}
