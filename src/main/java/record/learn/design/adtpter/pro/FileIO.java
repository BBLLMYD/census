package record.learn.design.adtpter.pro;

/**
 * Target
 *
 * @author: mqw   
 * @date:   2018年5月17日 下午4:06:29
 */
public interface FileIO {

	public void readFromFile(String filename) throws Exception;
	
	public void writrToFile(String filename) throws Exception;
	
	public void setVal(String key, String val) throws Exception;
	
	public void getVal(String key) throws Exception;
	
}

