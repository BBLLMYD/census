package record.learn.design.factorymethed;

public class Main {

	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product sb1 = factory.create("sb1");
		Product sb2 = factory.create("sb2");
		Product sb3 = factory.create("sb3");
		sb1.use();
		sb2.use();
		sb3.use();
		/**
		 * 抽象工厂是针对产品族的创建
		 * eg: 
		 * IDCardFactory factory = new AmericaIDCardFactory();
		 */
	}
	
	
}
