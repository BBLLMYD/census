package record.learn.classloader.hot;

public class Worker {
	public void doit(){
		String str = "qweqwe";
		System.out.println(str+"-------"+this.getClass().getClassLoader().getClass()+"----"+String.class.getClassLoader()+"---"+Reload.class.getClassLoader().getClass()+"---"+Worker.class.getClassLoader().getClass());
	}
}
