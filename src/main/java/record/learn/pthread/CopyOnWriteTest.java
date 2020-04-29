package record.learn.pthread;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteTest {

	static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//	static List<String> list = new ArrayList<>();
	
	static{
		list.add("1");		list.add("2");		list.add("3");
		list.add("4");		list.add("5");		list.add("6");
		list.add("7");		list.add("8");		list.add("9");
	}
	
	//结论: 遍历过程中修改,不会影响之前的遍历,即不会遍历更新后最新的集合
	public static void main(String[] args) {
		new T1().start();
		new T2().start();
		try {Thread.sleep(300);} catch (InterruptedException e) {}
		list.remove(2);
		try {Thread.sleep(100);} catch (InterruptedException e) {}
//		list.add("10");
	}
	
	static class T1 extends Thread{
		@Override
		public void run() {
			System.out.println("T1 ALREADY START");
			for(String str:list){ 
				try {Thread.sleep(200);} catch (InterruptedException e) {}
				System.err.println(str+ " is in " +list + "  SIZE(T1):"+list.size());
			}
//			更新集合后再次遍历时, 会拿到最新的集合
//			new T2().start();
			/*for(int i=0; i<list.size(); i++){
				try {Thread.sleep(200);} catch (InterruptedException e) {}
				System.out.println(list.get(i)+ " is in " +list + "  SIZE(T1):"+list.size());
			}*/
		}
	}
	
	static class T2 extends Thread{
		@Override
		public void run() {
			System.out.println("T2 ALREADY START");
			for(String str:list){
				try {Thread.sleep(200);} catch (InterruptedException e) {}
				System.err.println(str+ " is in " +list + "  SIZE(T2):"+list.size());
			}
		}
	}
}
