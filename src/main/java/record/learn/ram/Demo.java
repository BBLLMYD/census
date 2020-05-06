package record.learn.ram;

public class Demo {

	private int x1 = 0;
	private int x2 = 0;
	private int x3 = 0;
	private volatile int y1= 0;
	private volatile int y2 = 0;
	private volatile int y3 = 0;
	private int z1 = 0;
	private int z2 = 0;
	private int z3 = 0;
	
	
	public void exec1(){
		x1 = 1;
		x2 = 2;
		x3 = 3;
		
		y1 = 4;
		y2 = 5;
		y3 = 6;
		
		z1 = 7;
		z2 = 8;
		z3 = 9;
	}
	
	public void exec2(int num){
		int t1 = num + x1;
		int t2 = num + x2;
		int t3 = num + x3;

		int t4 = num + y1;
		int t5 = num + y2;
		int t6 = num + y3;
		
		int t7 = num + z1;
		int t8 = num + z2;
		int t9 = num + z3;
	}
	
	public static void main(String[] args) throws Exception {
		final Demo demo = new Demo();
				
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.exec1();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.exec2(100);
			}
		}).start();
	}
	
}
