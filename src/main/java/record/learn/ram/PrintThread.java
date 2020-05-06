package record.learn.ram;

import java.util.HashMap;

public class PrintThread extends Thread{

	public static final long starttime = System.currentTimeMillis();
	
	
	public static void main(String[] args) {
		new PrintThread().start();
		new MyThread().start();
	}
	
	@Override
	public void run() {
		try{
			while(true){
				long time = System.currentTimeMillis()-starttime;
				System.err.println(time);
				Thread.sleep(100);
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
	}
	
	public static class MyThread extends Thread{
		HashMap<Long, byte[]> mp = new HashMap<>();
		@Override
		public void run() {
			try{
				while(true){
					if(mp.size()*512/1024/1024>=450){	//大于450M时清理内存
						System.out.println("====准备清理===="+mp.size());
						mp.clear();
					}
					for(int i=0;i<1024;i++){
						mp.put(System.nanoTime(), new byte[512]);
					}
					Thread.sleep(1);
				}
			}catch(Throwable e){
				e.printStackTrace();
			}
		}
	}
	
}
