package record.learn.pthread;

public class ThreadInterruptTest {

	public static void main(String[] args) {
		try {
			MyThread.sleep(3000);
			MyThread myThread = new MyThread();
			myThread.start();
			myThread.interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * 线程被中断测试
 * 被调用线程请求中断后,run方法还是会继续执行; 除非主动判断当前线程自身状态是否被中断
 *
 * @author: mqw   
 * @date:   2018年6月15日 上午10:58:27
 */
class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0 ; i<1000000; i++){
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			/*if(this.isInterrupted()){System.err.println("isInterrupted");try {
				throw new InterruptedException();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}*/
			System.out.println("i="+(i+1));
		}
	}
}
