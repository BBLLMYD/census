package record.learn.pthread.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPool {

	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(7);
		pool.schedule(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("asd");
				return "sth";
			}
		}, 3, TimeUnit.SECONDS);
		
		pool.shutdown();//线程池不管进程不会停止
	}
	
}

class ScheduledThreadPoolDemo{
	
}