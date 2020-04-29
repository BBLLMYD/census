package record.learn.rpc.provider;


import record.learn.rpc.interfac.ReqInfoService;

public class Main {

	public static void main(String[] args) throws Throwable {
		ReqInfoService service = new ReqInfoServiceImpl();
		RpcServerProxy rpcServerProxy = new RpcServerProxy();
		rpcServerProxy.publishServer(service, 9002);
	}
	
}
