package record.learn.classloader.hot;

import java.io.IOException;
import java.io.InputStream;

public class MyLoader extends ClassLoader{
	
	private ReloadType type = null;
	
	public MyLoader() {
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		try {
			String filename = name.substring(name.lastIndexOf(".")+1)+type;
			InputStream is = getClass().getResourceAsStream(filename);
			if(is == null){
				return super.loadClass(name);
			}
			byte[] b;
			b = new byte[is.available()];
			is.read(b);
			return defineClass(name, b, 0, b.length);
		} catch (IOException e) {
			e.printStackTrace();
			return super.loadClass(name);
		}
	}
	
	private static volatile MyLoader loader = null;
	
	public synchronized static MyLoader getInstance(ReloadType type){
//		if(loader == null)
			loader = new MyLoader();
		loader.setType(type);
		return loader;
	}

	public ReloadType getType() {
		return type;
	}

	public void setType(ReloadType type) {
		this.type = type;
	}
	
}
