package record.learn.rpc.provider;


import record.learn.rpc.bean.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;


public class WorkerThread implements Runnable{

	private	Socket socket;
	private Object service;
	
	@Override
	public void run() {
		System.out.println("开始处理客户端请求");
		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;
		try {
			inputStream = new ObjectInputStream(socket.getInputStream());
			RpcRequest rpcReq = (RpcRequest)inputStream.readObject();	//java的反序列化
			Object invokeRes = invoke(rpcReq);
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(invokeRes);
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Object invoke(RpcRequest rpcReq){
		Object resu = null;
		Object[] args = rpcReq.getArgs();
		Class<?>[] types = new Class[args.length];
		for(int i=0;i<types.length;i++){
			types[i] = args[i].getClass(); 
		}
		try {
			Method method = service.getClass().getMethod(rpcReq.getMethodName(), types);
			resu = method.invoke(service, args);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resu;
	}
	

	public WorkerThread(Socket socket, Object service) {
		super();
		this.setSocket(socket);
		this.setService(service);
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Object getService() {
		return service;
	}

	public void setService(Object service) {
		this.service = service;
	}

}
