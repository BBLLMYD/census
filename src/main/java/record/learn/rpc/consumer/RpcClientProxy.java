package record.learn.rpc.consumer;

import java.lang.reflect.Proxy;

public class RpcClientProxy {

	public <T> T clientProxy(Class<?> interfaces,String host,int port){
		return (T)Proxy.newProxyInstance(interfaces.getClassLoader(), new Class<?>[]{interfaces}, new RemoteInvocationHandler(host, port));
	}
	
}
