package record.learn.design.adtpter.pro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Adapter
 * Adapter类，他继承了现有类Adaptee并且实现了我们所要求的特定接口Target
 * @author: mqw   
 * @date:   2018年5月17日 下午4:06:35
 */
public class FileProperties extends Properties/*Adaptee*/ implements FileIO {

	private static final long serialVersionUID = 1L;

	@Override
	public void readFromFile(String filename) throws Exception {
		 load(new FileInputStream(filename));  
	}

	@Override
	public void writrToFile(String filename) throws Exception {
		 store(new FileOutputStream(filename), "written by FileProperties");  
	}

	@Override
	public void setVal(String key, String val) throws Exception {
		setProperty(key, val);
	}

	@Override
	public void getVal(String key) throws Exception {
		get(key);
	}

}
