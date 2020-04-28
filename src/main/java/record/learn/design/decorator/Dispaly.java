package record.learn.design.decorator;

/**
 * 用于显示字符串的抽象类
 *
 * @author: mqw   
 * @date:   2018年8月21日 上午11:33:42
 */
public abstract class Dispaly {

	abstract int getColumns();
	
	abstract int getRows();

	abstract String getRowText(int i);
	
	void show(){
		for(int i = 0 ; i< getRows(); i++){
			System.out.println(getRowText(i));
		}
	}
}
