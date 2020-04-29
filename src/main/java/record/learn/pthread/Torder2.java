package record.learn.pthread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Torder2 {
	
	static Object obj = new Object();
	
	public static void main(String[] args) throws Throwable {
		Thread11 thread1 = new Thread11();
		Thread22 thread2 = new Thread22();
		Thread33 thread3 = new Thread33();
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.submit(thread1);
		executor.submit(thread2);
		executor.submit(thread3);
		executor.shutdown();
	}
	
}

class Thread11 extends Thread{

	@Override
	public void run() {
		synchronized (Torder2.obj) {
			System.out.println("Thread1");
		}
	}
	
}

class Thread22 extends Thread{
	
	@Override
	public void run() {
		synchronized (Torder2.obj) {
			System.out.println("Thread2");
		}
	}
	
}

class Thread33 extends Thread{
	
	@Override
	public void run() {
		synchronized (Torder2.obj) {
			System.out.println("Thread3");
		}
	}
	
}