package record.learn.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


/**
 * 
 * 1. 通道    :负责连接
 * 				SelectableChannel
 * 					ScoketChannel
 * 					ServerScoketChannel
 * 					DatagramChannel	//UDP
 * 
 * 					Pipe.SinkChannel
 * 					Pipe.SourceChannel
 * 2. 缓冲区:负责数据的存取
 * 3. 选择器:多路复用器,用于监控selectableChannel的IO状况
 *
 * @author: mqw   
 * @date:   2018年8月8日 上午7:52:21
 */
public class TestNIO {
	
	public static void main(String[] args) throws Throwable {
		server();
		Thread.sleep(1000);
		client();
	}
	
	static void client() throws Throwable{
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9003));
		
		ByteBuffer bf = ByteBuffer.allocate(1024);
		bf.put("sth".getBytes());
		
		sc.write(bf);
	}
	
	static void server() throws Throwable{
		ServerSocketChannel sc = ServerSocketChannel.open();
		sc.bind(new InetSocketAddress(9002));
		SocketChannel sc2 = sc.accept();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		sc2.write(buffer);
		
		buffer.flip();
		String str = new String(buffer.array());
	}		
}
