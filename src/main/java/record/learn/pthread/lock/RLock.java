package record.learn.pthread.lock;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class RLock {

	static Lock lock1 = new ReentrantLock();
	static Condition newCondition1 = lock1.newCondition();
	static Lock lock2 = new ReentrantLock();

	
	
	public static void main(String[] args) throws Exception {
		/*Class<?> forName = Class.forName("census.pthread.lock.RLock");
		Class<?> forName1 = Class.forName("census.pthread.lock.RLock");
		System.out.println(forName.hashCode());
		System.out.println(forName1.hashCode());
		System.out.println(forName1.newInstance());
		System.out.println(forName1.newInstance());
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		t1.start();
		t2.start();
		t2.interrupt();*/
		
		//死锁
		Thread t1 = new Thread(new T3(lock1,lock2),"cenos__");
		Thread t2 = new Thread(new T3(lock2,lock1),"zoiua__");
		t1.start();
		t2.start();
		
		//Condition	
		//condition.await()释放锁,Object.wait()释放锁,Thread.sleep()不释放锁,Object.notify/all()同步代码块执行完释放锁,
		/*Thread t1 = new Thread(new T5());
		t1.start();
		Thread.sleep(900);
		lock1.lock();
		System.out.println("I am main");
		newCondition1.signal();
		lock1.unlock();*/
		
		//信号量902328
		/*ExecutorService pool = Executors.newFixedThreadPool(20);
		final SemapDemo semapDemo = new SemapDemo();
		for(int i = 0 ; i < 20 ; i++){
			pool.submit(semapDemo);
		}*/
		
		//forkjoinpool
		/*ForkJoinPool pool = new ForkJoinPool();
		CountTask task = new CountTask(0, 20000L);
		ForkJoinTask<Long> result = pool.submit(task);
		try {
			Long res = result.get();
			System.err.println("计算结果："+res);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}*/
		
		//LockSupport
//		LockSupoortDemo t1 = new LockSupoortDemo("t1");
//		LockSupoortDemo t2 = new LockSupoortDemo("t2");
//		t1.start();
//		Thread.sleep(200);
//		t2.start();
//		LockSupport.unpark(t2);
//		LockSupport.unpark(t1);
//		t1.join();
//		t2.join();
		
		//CyclicBarrierr
		/*int n = 10;
		Thread[] allSoldiers = new Thread[n];
		boolean flag = false;
		CyclicBarrier cyclic = new CyclicBarrier(n,new BarrierRun(flag, n));
		System.out.println("集合队伍！");
		for(int i = 0; i< n ;i++){
			System.out.println("士兵"+i+"报道");
			allSoldiers[i] = new Thread(new CyclicBarrierrDemo("士兵"+i, cyclic));
			allSoldiers[i].start();
			if(i==100){allSoldiers[0].interrupt();}
		}*/
		
		//CountDownLatch
		/*ExecutorService pool = Executors.newFixedThreadPool(7);
		CountDownLatchDemo demo = new CountDownLatchDemo();
		for(int i = 0 ; i < 7 ; i++){
			pool.submit(demo);
		}
		CountDownLatchDemo.countDownLatch.await();
		System.out.println("fire!!");
		pool.shutdown();*/
		
		//ReadWriteLock
		/*final Lock lock = new ReentrantLock();
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		final ReadLock readLock = readWriteLock.readLock();
		final WriteLock writeLock = readWriteLock.writeLock();
		Runnable readRunnable = new Runnable() {
			@Override
			public void run() {
				demo.handleRead(readLock);
//				demo.handleRead(lock);
			}
		};
		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				demo.handleWrite(writeLock, new Random().nextInt());
//				demo.handleWrite(lock, new Random().nextInt());
			}
		};*/
		 
		/*for(int i=0; i< 18; i++){
			new Thread(readRunnable).start();
		}
		for(int i=18; i< 20; i++){
			new Thread(writeRunnable).start();
		}*/
	}

	static class ReadWriteLockDemo {
		private int value;
		
		public Object handleRead(Lock lock){
			try{
				lock.lock();
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
			return value;
		}
		
		public void handleWrite(Lock lock, int index){
			try{
				lock.lock();
				Thread.sleep(1000);
				value = index;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
	}
	
	
	static class CountDownLatchDemo implements Runnable{
		static CountDownLatch countDownLatch = new CountDownLatch(7);
		@Override
		public void run() {
			try {
				System.out.println("准备中。。。");
				Thread.sleep(2000);
				countDownLatch.countDown();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	static class CyclicBarrierrDemo implements Runnable{
		private String soldier;
		private CyclicBarrier cyclic;
		CyclicBarrierrDemo(String soldier,CyclicBarrier cyclic){
			this.soldier = soldier;
			this.cyclic = cyclic;
		}
		@Override
		public void run() {
			try {
				//等待士兵集合
				cyclic.await();
				doWork();
				//等待所有士兵完成任务
				cyclic.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void doWork() throws Exception {
			Thread.sleep(Math.abs(new Random().nextInt()%10000));
			System.out.println(soldier +"任务完成");
		}
		
	}
	static class BarrierRun implements Runnable{

		boolean flag ;
		int N;
		
		public BarrierRun(boolean flag, int n) {
			super();
			this.flag = flag;
			N = n;
		}

		@Override
		public void run() {
			if(flag){
				System.out.println("司令:[士兵"+N+"个任务完成！]");
			}else{
				System.out.println("司令:[士兵"+N+"个集合完毕！]");
				flag = true;
			}
		}
		
	}
	
	
	
	
	
	
	
	static class LockSupoortDemo extends Thread{
		static Object obj = new Object();
		@Override
		public void run() {
			synchronized (obj) {
				LockSupport.park();
				System.err.println("in "+getName());
			}
		}
		
		public LockSupoortDemo(String name){
			super.setName(name);
		}
	}
	
	static class CountTask extends RecursiveTask<Long>{
		private static final long serialVersionUID = 1L;
		private static final int THRESHOLD = 1000;
		private long start;
		private long end;
		
		public CountTask(long start, long end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		protected Long compute() {
			long sum = 0;
			boolean cantCompute = (end - start)>THRESHOLD;
			if(cantCompute){
				long step = (start + end)/100;
				ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
				long pos = start;
				for(int i = 0 ; i<100; i++){
					long lastOne = pos + step;
					if(lastOne>end)lastOne=end;
					CountTask task = new CountTask(pos, lastOne);
					pos+=step+1;
					subTasks.add(task);
					task.fork();
				}
				for(CountTask t: subTasks){
					sum += t.join();
				}
			}else{
				for(long i =start; i<end; i++){
					sum += i;
				}
			}
			return sum;
		}
		
	}
	
	static class SemapDemo implements Runnable{
		//信号量指定的参数个数 全部释放完毕，才进行另外一组线程进入
		final Semaphore semo = new Semaphore(5);
		@Override
		public void run() {
			try{
				semo.acquire();
				System.out.println(Thread.currentThread().getId()+"done!!");
//				Thread.sleep(2000+new Random().nextInt(2000));
				Thread.sleep(2000);
				semo.release();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
			}
		}
		
	}
	
	
	static class T5 implements Runnable{
		@Override
		public void run() {
			try {
				lock1.lock();
				newCondition1.await();
				System.out.println("wait over");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock1.unlock();
			}
		}
		
	}
	
	static class T1 implements Runnable{
		@Override
		public void run() {
			try {
				lock1.lockInterruptibly();
				Thread.sleep(400);
				lock2.lockInterruptibly();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	static class T2 implements Runnable{
		
		@Override
		public void run() {
			try {
				lock2.lockInterruptibly();
				Thread.sleep(400);
				lock1.lockInterruptibly();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	static class T3 implements Runnable{

		private Lock lock1;
		private Lock lock2;
		
		public T3(Lock lock1,Lock lock2){
			this.lock1 = lock1;
			this.lock2 = lock2;
		}
		
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println(lock1);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println(lock2);
					}
			}
		}
		
	}
}
