package record.learn.rpc.provider;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcServerProxy {

	private ExecutorService threadPool = Executors.newFixedThreadPool(10);
	
	public void publishServer(Object service,int port) throws Throwable{
		ServerSocket socket = buildServerSocket(port);
		try {
			while(true){
				Socket accept = socket.accept();
				threadPool.execute(new WorkerThread(accept, service));
			}
		}finally {
			if(socket!=null){
				socket.close();
			}
		}
	}
	
	private ServerSocket buildServerSocket(int port) throws Exception {
		return new ServerSocket(port);
	}
	
}
