package record.learn.pthread.jdkapi;

public class ThtradJoin {

	public static void main(String[] args) throws Throwable {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		Thread3 thread3 = new Thread3();
		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();
	}
	
	
}

class Thread1 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread1");
		UncaughtExceptionHandler eh = null;
		setUncaughtExceptionHandler(eh );
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread2");
	}
}

class Thread3 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread3");
	}
}