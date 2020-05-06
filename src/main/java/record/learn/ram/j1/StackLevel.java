package record.learn.ram.j1;

public class StackLevel {

	private int level = 1;

	public void stackLevel() {
		level++;
		String s  ="";
		byte[] bs = new byte[1024*3200];
		stackLevel();
	}

	/**
	 * 
	 *  -server -Xss108k 
		-Xmx1800m -Xms1800m
		-XX:+DoEscapeAnalysis
		
	 */
	public static void main(String[] args) throws Throwable {
		/*StackLevel sl = new StackLevel();
		try {
			sl.stackLevel();
		} catch (Throwable e) {
			System.out.println(e);
			System.err.println(sl.level);
		}*/
		
		/*for(int i=0;i<100; i++){
			//new T1().start();
			new T1().doSth();
		}
		new T1().doSth();*/
		
		System.out.println("Xmx="+Runtime.getRuntime().maxMemory()/1024.0/1024+"M");
		System.out.println("free mem="+Runtime.getRuntime().freeMemory()/1024.0/1024+"M");
		System.out.println("total mem="+Runtime.getRuntime().totalMemory()/1024.0/1024+"M");
	}

	static class T1 extends Thread{
		static StackLevel sl = new StackLevel();
		@Override
		public void run() {
			doSth();
		}
		
		public void doSth(){
			try {
				sl.stackLevel();
			} catch (Throwable e) {
				System.out.println(e);
				System.err.println(sl.level);
			}
		}
	}
	
}