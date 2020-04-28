package record.learn.design.iterator.copy;

/**
 * 遍历集合的接口
 * 角色:(迭代器)
 *
 * @author: mqw   
 * @date:   2018年5月15日 上午11:06:37
 */
public interface Iterator {

	boolean hasNext();
	
	Object next();

}
