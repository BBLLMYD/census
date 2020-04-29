package record.learn.pthread.juc;

/**
 * 判断打印的是"one"还是"two"
 *
 * @author: mqw   
 * @date:   2018年8月28日 上午11:40:34
 */
public class TestThread8Monitor {
	public static void main(String[] args) {
		final Number n = new Number();
		new Thread(new Runnable() {
			@Override
			public void run() {
				n.getOne();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				n.getTwo();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				n.getThree();
			}
		}).start();
	}
}

class Number{
	public synchronized void getOne(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("one");
	}
	public synchronized void getTwo(){
		System.out.println("two");
	}
	public void getThree(){
		System.out.println("three");
	}
}

