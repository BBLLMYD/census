package record.learn.classloader.dispatch.dynamic;
/**
 * 单分派和多分派
 *
 * @author: mqw   
 * @date:   2018年8月13日 下午5:21:49
 */
public class Dispath {

	static class QQ{}
	static class _360{}
	
	public static class Father{
		public void hardChnice(QQ arg){
			System.out.println("father choose qq");
		}
		public void hardChnice(_360 arg){
			System.out.println("father choose 360");
		}
	}
	public static class Son extends Father{
		public void hardChnice(QQ arg){
			System.out.println("son choose qq");
		}
		public void hardChnice(_360 arg){
			System.out.println("son choose 360");
		}
	}
	
	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		father.hardChnice(new _360());
		son.hardChnice(new QQ());
	}
	
}
