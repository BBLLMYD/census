package record.learn.ram.clazzl;

/**
 * 加载类并不是对类的主动使用, 不会导致类的初始化
 *
 * @author: mqw
 * @date: 2018年6月1日 下午2:57:41
 */
@SuppressWarnings("unchecked")
public class ClazzL {

	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<CL> loadClass = (Class<CL>) classLoader.loadClass("census.jvm.clazzl.CL");// 不属于主动使用
		loadClass.newInstance(); // 主动使用, 会导致初始化
	}

}

class CL {
	static {
		System.err.println("asd");
	}
}