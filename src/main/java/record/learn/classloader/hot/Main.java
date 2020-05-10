package record.learn.classloader.hot;

public class Main {

	public static void main(String[] args) throws Throwable {
		
//		new Reload("census.cll.hot.Worker",ReloadType.CLAZZ).start();
//		new Reload("census.cll.hot.Worker",ReloadType.CLAZZ).start();

		MyLoader loader = MyLoader.getInstance(ReloadType.CLAZZ);
		System.err.println("类装载器 "+loader.loadClass("census.classloader.hot.Worker").newInstance().getClass().getClassLoader());

		MyLoader loader2 = MyLoader.getInstance(ReloadType.CLAZZ);
		Class<?> aClass =  loader2.loadClass("census.classloader.hot.Worker");
		Class<? extends Object> aClass1 = aClass.newInstance().getClass();
		//System.err.println("类装载器 "+loader2.loadClass("census.classloader.hot.Worker").newInstance().getClass().getClassLoader());
		//System.err.println("类装载器 "+loader2.loadClass("census.classloader.hot.Worker").newInstance().getClass().getClassLoader());

		Worker worker = new Worker();
		Class<? extends Worker> aClass2 = worker.getClass();
		System.out.println(worker.getClass().getClassLoader());

//		Worker wk = new Worker();
//		while(true){
//			Thread.sleep(700);
//			wk.doit();
//		}
	}
	
}
