package record.learn.design.bridge;

/**
 * 类实现的角色
 *
 * @author: mqw   
 * @date:   2018年8月21日 下午4:09:54
 */
public class StringDisplayImpl extends DisplayImpl{

	private String string;
	private int width;
	public StringDisplayImpl(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}
	@Override
	void rawOpen() {
		printLine();		
	}
	@Override
	void rawPrint() {
		System.out.println("|"+string+"|");
	}
	@Override
	void rawClose() {
		printLine();		
	}
	
	private void printLine(){
		System.out.print("+");
		for(int i=0; i<width; i++){
			System.out.print("-");
		}
		System.out.println("+");
	}
	
}
