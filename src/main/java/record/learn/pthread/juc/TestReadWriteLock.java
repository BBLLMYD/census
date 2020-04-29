package record.learn.pthread.juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

	public static void main(String[] args) {
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		new Thread(new Runnable() {
			@Override
			public void run() {
//				for(int i=0;i<10;i++){
					demo.set(new Random().nextInt(101));
//				}
			}
		},"write").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					demo.get();
				}
			}
		},"READ").start();
	}
	
}

class ReadWriteLockDemo{
	private int num;
	ReadWriteLock lock = new ReentrantReadWriteLock(true);
	public void get(){
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+" : " + num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.readLock().unlock();
		}
	}
	public void set(int num){
		lock.writeLock().lock();
		try {
			this.num = num;
			System.out.println(Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock();
		}
	}
}

