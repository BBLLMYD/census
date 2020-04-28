package record.learn.design.observer.bf;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		BlogUser blogUser = (BlogUser)o;
		System.err.println("震惊!!!"+blogUser+"发表了:::新文章");
	}

}
