package record.learn.classloader.hot;

import java.io.File;

/**
 * 监控bin下被替换的class文件, 实时返回
 *
 * @author: mqw   
 * @date:   2018年8月10日 上午10:39:16
 */
public class MonitorUtil {

	private static volatile MonitorUtil mutil;
	private static boolean isFirstTime = true;

	private long lastModifiedTime = 0;
	private String fullpath = null;
	
	private MonitorUtil(){}
	
	public synchronized static MonitorUtil getInstance(String fullClazzPath,ReloadType type){
		if(mutil == null) {
			mutil = new MonitorUtil();
		}
		mutil.init(fullClazzPath,type);
		return mutil;
	}
	
	private void init(String fullClazzPath, ReloadType type) {
		fullClazzPath = fullClazzPath.replaceAll("\\.", "/");
		this.setFullpath(type.getPath()+fullClazzPath+type);
		if(isFirstTime){
			File file = new File(fullpath);
			this.lastModifiedTime = file.lastModified();
			isFirstTime = false;
		}
	}
	
	boolean monit(){
		File file = new File(fullpath);
		long newTime = file.lastModified();
//		System.out.println("newTime:"+newTime+",lastModifiedTime:"+lastModifiedTime);
		boolean flag = newTime > lastModifiedTime;
		lastModifiedTime = newTime;
		return flag;
	}

	public String getFullpath() {
		return fullpath;
	}

	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}

}
