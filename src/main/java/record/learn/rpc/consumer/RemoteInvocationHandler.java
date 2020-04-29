package record.learn.rpc.consumer;


import record.learn.rpc.bean.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler{

	String host;
	int port;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		RpcRequest request = new RpcRequest();
		request.setMethodName(method.getName());
		request.setArgs(args);
		
		RPCNetTransport transport = new RPCNetTransport(host, port);
		Object sendReq = transport.sendReq(request);
		return sendReq;
	}

	public RemoteInvocationHandler(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}

}
