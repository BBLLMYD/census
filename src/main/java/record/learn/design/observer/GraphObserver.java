package record.learn.design.observer;

public class GraphObserver implements Observer{

	@Override
	public void update(Numbergenerator numbergenerator) {
		System.out.println("GraphObserver: ~~~~~~~~~~~~~" +numbergenerator.getNumber());
	}

}
