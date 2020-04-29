package record.learn.rpc.consumer;


import record.learn.rpc.bean.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RPCNetTransport {

	String host;
	int port;
	
	public RPCNetTransport(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	
	
	public Object sendReq(RpcRequest request){
		Object res = null;
		Socket socket = buildSocket();
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(request);
			outputStream.flush();
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			res = inputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}
	
	private Socket buildSocket(){
		Socket socket = null;
		try {
			socket = new Socket(host,port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return socket;
	}
	
}
