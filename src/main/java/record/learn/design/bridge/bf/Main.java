package record.learn.design.bridge.bf;

public class Main {

	public static void main(String[] args) {
		Engine engine2000 = new Engine2000();	//实现的扩展
		Engine engine2200 = new Engine2200();
		
		Car car = new Bus(engine2000);
		car.installEngine();
		
		Car car2 = new Jeep(engine2200);	//功能的扩展
		car2.installEngine();
	}
	
}
