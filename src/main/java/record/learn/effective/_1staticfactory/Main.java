package record.learn.effective._1staticfactory;

public class Main {

	public static void main(String[] args) {
//		Service newInstance = Services.newInstance("qwe");  //未注册时执行newInstance会报错   命名应该为geiInstance比较合适
		Services.registerDefaultProvider(() -> new Service() {
			//注册进去个匿名类
		});
		Service newInstance = Services.newInstance();
		System.out.println(newInstance);
		
	}
	
}
