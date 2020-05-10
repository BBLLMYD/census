package record.learn.classloader.dispatch.dynamic;

public class DynamicDispatch {

	static abstract class Human{
		protected abstract void sayhello();
	}
	static class Man extends Human{
		@Override
		protected void sayhello() {
			System.out.println("man say hello");
		}
	}
	
	static class Woman extends Human{
		@Override
		protected void sayhello() {
			System.out.println("woman say hello");
		}
	}
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		man.sayhello();
		woman.sayhello();
		/*man = new Woman();
		man.sayhello();*/
	}
}
