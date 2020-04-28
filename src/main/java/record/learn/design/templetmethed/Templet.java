package record.learn.design.templetmethed;

public abstract class Templet {

	/**
	 * 模板方法, 定义步骤顺序等, 不关心各步骤实现细节
	 */
	void step(){
		methed1();
		methed2();
		methed3();
	}
	
	abstract void methed1();
	abstract void methed2();
	abstract void methed3();
	
}
