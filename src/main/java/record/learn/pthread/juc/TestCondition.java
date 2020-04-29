package record.learn.pthread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition {
	public static void main(String[] args) {
		final Alertnate alertnate = new Alertnate();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0 ;i<=20; i++){
					alertnate.loopA(i);
				}
			}
		},"A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0 ;i<=20; i++){
					alertnate.loopB(i);
				}
			}
		},"B").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0 ;i<=20; i++){
					alertnate.loopC(i);
					System.out.println("-  -  -  -  -  -");
				}
			}
		},"C").start();
	}
}

class Alertnate{
	private volatile int num = 1;
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();

	public void loopA(int totleloop){
		lock.lock();
		try {
			if(num != 1){
				condition1.await();
			}else{
				for(int i=0;i<5;i++){
					System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totleloop);
				}
				num = 2;
				condition2.signal();
			}
		} catch(Throwable e){
		}finally {
			lock.unlock();
		}
	}
	
	public void loopB(int totleloop){
		lock.lock();
		try {
			if(num != 2){
				condition2.await();
			}else{
				for(int i=0;i<5;i++){
					System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totleloop);
				}
				num = 3;
				condition3.signal();
			}
		} catch(Throwable e){
		}finally {
			lock.unlock();
		}
	}
	
	public void loopC(int totleloop){
		lock.lock();
		try {
			if(num != 3){
				condition3.await();
			}else{
				for(int i=0;i<5;i++){
					System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totleloop);
				}
				num = 1;
				condition1.signal();
			}
		} catch(Throwable e){
		}finally {
			lock.unlock();
		}
	}
}