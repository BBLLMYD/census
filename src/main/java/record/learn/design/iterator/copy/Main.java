package record.learn.design.iterator.copy;

public class Main {

	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(9);
		bookShelf.appendBook(new Book("s z h j"));
		bookShelf.appendBook(new Book("y z t l d x d z"));
		bookShelf.appendBook(new Book("h j s d"));
		bookShelf.appendBook(new Book("b r"));
		bookShelf.appendBook(new Book("b r 2"));
		Iterator iterator = bookShelf.iterator();
		while(iterator.hasNext()){
			Book book = (Book)iterator.next();
			System.err.println(book.getName());
		}
	}
	
}
