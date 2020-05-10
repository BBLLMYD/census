package record.learn.classloader.hot;

public class Reload extends Thread{

	private String clzname;
	private ReloadType type = null;
	
	public Reload(String clzname,ReloadType type) {
		this.clzname = clzname;
		this.type = type;
	}

	public void reloadClazz(){
		try {
			MyLoader loader = MyLoader.getInstance(type);
			System.err.println("类装载器 "+loader.loadClass(clzname).newInstance().getClass().getClassLoader());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true){
			asleep(1000);
			boolean needReload = MonitorUtil.getInstance(clzname,type).monit();
			if(needReload){
				System.out.println("开始重新装载类!!!");
				try {
					reloadClazz();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	void asleep(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
