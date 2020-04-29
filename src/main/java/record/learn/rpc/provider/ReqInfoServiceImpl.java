package record.learn.rpc.provider;


import record.learn.rpc.bean.ReqInfo;
import record.learn.rpc.interfac.ReqInfoService;

/**
 * 暴露的接口实现
 *
 * @author: mqw   
 * @date:   2018年11月30日 下午1:49:04
 */
public class ReqInfoServiceImpl implements ReqInfoService {

	@Override
	public String getAroundInfo(ReqInfo info) {
		System.err.println("id:"+info.getId()+", name:"+info.getName()+", mob:"+info.getMobiled());
		return "Server get";
	}

}
