package record.learn.design.iterator;

import java.util.ArrayList;

/**
 * 具体的集合
 * 角色:ConcreteAggregate(具体的集合)
 *
 * @author: mqw   
 * @date:   2018年5月15日 上午11:10:10
 */
public class BookShelf implements Aggregate{

	private ArrayList<Book> booksList;
	private int last = 0;
	
	public BookShelf(int maxSize){
		booksList = new ArrayList<>(maxSize);
	}
	
	public Book getBookAt(int index){
		return booksList.get(index);
	}
	
	public void appendBook(Book book){
		booksList.add(book);
		last++;
	}
	
	public int getLength(){
		return last;
	}

	/**
	 * 返回具体迭代器
	 */
	@Override
	public Iterator iterator(){
		/*具体集合中对具体迭代器的引用*/
		return new BookShelfIterator(this);
	}
}
