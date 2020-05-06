package record.learn.ram;

import java.util.concurrent.atomic.AtomicInteger;

public class OOM2 {

	static AtomicInteger i = new AtomicInteger(0);
	
	/**
	 * 据说java9,java10时输出'here'两次
	 * @param args
	 */
	public static void main(String[] args) {
		String[] array = {""};
		array[test()]+="a";
		
	}
	static int test(){
		System.err.println("here");
		return 0;
	}
}

