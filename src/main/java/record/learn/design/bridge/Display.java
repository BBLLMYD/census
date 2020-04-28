package record.learn.design.bridge;

/**
 * 功能层次结构的最上层
 *
 * @author: mqw   
 * @date:   2018年8月21日 下午4:08:03
 */
public class Display {

	private DisplayImpl displayImpl;

	public Display(DisplayImpl displayImpl) {
		super();
		this.displayImpl = displayImpl;
	}
	
	public void open(){
		displayImpl.rawOpen();
	}
	
	public void print(){
		displayImpl.rawPrint();
	}
	
	public void close(){
		displayImpl.rawClose();
	}
	
	public final void disPaly(){
		open();
		print();
		close();
	}
	
}
