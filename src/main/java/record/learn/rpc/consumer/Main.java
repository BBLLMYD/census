package record.learn.rpc.consumer;

import record.learn.rpc.bean.ReqInfo;
import record.learn.rpc.interfac.ReqInfoService;

public class Main {

	public static void main(String[] args) {
		ReqInfoService service = new RpcClientProxy().clientProxy(ReqInfoService.class, "127.0.0.1", 9002);
		String aroundInfo = service.getAroundInfo(new ReqInfo("ASD", "ASD", "ZXC"));
		System.out.println("返回:"+aroundInfo);
	}
	
}
