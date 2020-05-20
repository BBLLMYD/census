package record.learn.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.SortedMap;

import org.junit.Test;

public class TestChannel {

	/**
	 * 网络IO
	 * Socket
	 * ServerSocket
	 * DatagremSocket
	 * 
	 */
	public static void main(String[] args){
		try {
			test5();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * charset
	 * 编码 字符串->字节数组
	 * 解码 字节数组->字符串
	 */
	static void test5() throws Throwable{
		SortedMap<String, Charset> map = Charset.availableCharsets();
		Charset cs = Charset.forName("UTF-8");
		CharsetEncoder newEncoder = cs.newEncoder();
		CharsetDecoder newDecoder = cs.newDecoder();
		CharBuffer cb = CharBuffer.allocate(1024);
		cb.put("你好");
		cb.flip();
		
		//编码
		ByteBuffer encode = newEncoder.encode(cb);
		CharBuffer decode = newDecoder.decode(encode);
		System.out.println(decode.toString());
	}
	
	/**
	 * ?
	 * 分散Scatter与聚集Gather
	 * 分散读取:将通道中的数据分散到多个缓冲区
	 * 聚集写入:将多个缓冲区的数据聚集到通道中
	 */
	static void test4() throws Throwable{
		RandomAccessFile raf = new RandomAccessFile("0202.png", "rw");
		
		FileChannel channel = raf.getChannel();
		ByteBuffer dst1 = ByteBuffer.allocate(1024);
		ByteBuffer dst2 = ByteBuffer.allocate(1024);
		ByteBuffer dst3 = ByteBuffer.allocate(1024);
		ByteBuffer[] dsts = {dst1,dst2,dst3}; 
		channel.read(dsts);
		
		for(ByteBuffer bs :dsts){
			bs.flip();
		}
		
		RandomAccessFile raf2 = new RandomAccessFile("0208.png", "rw");
		FileChannel channel2 = raf2.getChannel();
		channel2.write(dsts);
		
	}
	
	/**
	 * 4通道之间的数据传输(也是直接缓冲区)
	 * transferfrom
	 * transferto
	 */
	static void test3() throws Throwable{
		FileChannel inchannel = FileChannel.open(Paths.get("0202.png"), StandardOpenOption.READ);
		FileChannel outchannel = FileChannel.open(Paths.get("0206.png"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

//		inchannel.transferTo(0, inchannel.size(), outchannel);
		outchannel.transferFrom(inchannel, 0, inchannel.size());
		
		inchannel.close();
		outchannel.close();
	}

	/**
	 * 3直接使用缓冲区完成文件的复制(内存映射文件方式)
	 */
	public static void test2() throws Throwable{
		FileChannel inchannel = FileChannel.open(Paths.get("0202.png"), StandardOpenOption.READ);
		FileChannel outchannel = FileChannel.open(Paths.get("0205.png"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		//内存映射文件(原理和ByteBuffer.allocateDirect(capacity)一样)
		//好处 不需要操作通道
		MappedByteBuffer inmapBuffer = inchannel.map(MapMode.READ_ONLY, 0, inchannel.size());
		MappedByteBuffer outmapBuffer = outchannel.map(MapMode.READ_WRITE, 0, inchannel.size());
		
		byte[] bs = new byte[inmapBuffer.limit()];
 		inmapBuffer.get(bs);
 		outmapBuffer.put(bs);
 		
 		inchannel.close();
 		outchannel.close();
	}
	
	/**
	 * 1利用通道完成文件的复制(非直接缓冲区)
	 */
	static void test1() throws Throwable{
		FileInputStream fi = new FileInputStream("0202.png");
		FileOutputStream fo = new FileOutputStream("0203.png");
		FileChannel channel = fi.getChannel();
		FileChannel ochannel = fo.getChannel();
		
		ByteBuffer bf = ByteBuffer.allocate(1024);
		
		while(channel.read(bf)!=-1){	//将channel指向的数据写入缓冲区
			bf.flip();//切换读取数据模式	
			ochannel.write(bf);			
			bf.clear();
		}
		ochannel.close();
		channel.close();
	}
	
}
