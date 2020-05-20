package record.learn.nio;

import java.nio.ByteBuffer;

public class TestBuffer {

	public static void main(String[] args) {
		//非直接缓冲区 将缓冲区建立在jvm的内存中
		ByteBuffer bf = ByteBuffer.allocate(1024);
		//直接缓冲区 将缓冲区建立在操作系统内存中,堆外内存
		//建立内存映射文件,避免了操作系统内核态和用户态之间切换时的copy浪费
		ByteBuffer.allocateDirect(1024);
		System.out.println(bf.position());
		System.out.println(bf.limit());
		System.out.println(bf.capacity());
		
		String string = "asd";
		bf.put(string.getBytes());
		System.out.println(bf.position());
		System.out.println(bf.limit());
		System.out.println(bf.capacity());
		
		bf.flip();
		System.out.println(bf.position());
		System.out.println(bf.limit());
		System.out.println(bf.capacity());
		
		byte[] bs = new byte[bf.limit()];
		bf.get(bs, 0, bf.limit());
		System.out.println(bf.position());
		System.out.println(bf.limit());
		System.out.println(bf.capacity());
		
		bf.rewind();//执行此方法后 可重复读数据
		System.out.println(bf.position());
		System.out.println(bf.limit());
		System.out.println(bf.capacity());
		
		bf.clear();//数据处于被遗忘状态
		System.out.println(bf.position());
		System.out.println(bf.limit());
		System.out.println(bf.capacity());
		
		// 0 <= mark <= position <= limit <= capacity
		bf.mark();
		
		
	}
	
	
}
