package record.learn.design.bridge;

public class Main {

	public static void main(String[] args) {
		StringDisplayImpl strDispImpl1 = new StringDisplayImpl("hello china");
		StringDisplayImpl strDispImpl2 = new StringDisplayImpl("hello jixi");	//类扩展的实现
		Display d1 = new Display(strDispImpl1);
		Display d2 = new CountDisplay(strDispImpl1);
		CountDisplay d3 = new CountDisplay(strDispImpl2);
		d1.disPaly();
		d2.disPaly();
		d3.disPaly();
		d3.multiDisplay(5);	//功能扩展的体现
	}
	
}
