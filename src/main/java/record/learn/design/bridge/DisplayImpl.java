package record.learn.design.bridge;
/**
 * 类的实现层次的最上层
 *
 * @author: mqw   
 * @date:   2018年8月21日 下午4:08:18
 */
public abstract class DisplayImpl {

	abstract void rawOpen();
	
	abstract void rawPrint();
	
	abstract void rawClose();
	
}
