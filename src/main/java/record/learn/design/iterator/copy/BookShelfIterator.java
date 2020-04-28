package record.learn.design.iterator.copy;

/**
 * 遍历具体某集合的实现
 * 角色:ConcreteIterator(具体的迭代器)
 *
 * @author: mqw   
 * @date:   2018年5月15日 上午11:07:47
 */
public class BookShelfIterator implements Iterator{

	private BookShelf bookShelf;
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf){
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if(index < bookShelf.getLength()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}
}
