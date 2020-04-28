package record.learn.design.bridge;

/**
 * 添加新功能的角色
 *
 * @author: mqw   
 * @date:   2018年8月21日 下午4:09:02
 */
public class CountDisplay extends Display{

	public CountDisplay(DisplayImpl displayImpl) {
		super(displayImpl);
	}
	
	public void multiDisplay(int times){
		open();
		for(int i=0;i<times;i++){
			print();
		}
		close();
	}
}
