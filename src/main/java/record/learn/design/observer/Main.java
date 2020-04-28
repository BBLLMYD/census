package record.learn.design.observer;

public class Main {

	public static void main(String[] args) {
		Numbergenerator nb = new RandomNumberGenerator();
		Observer observer1 = new DigitObserver();
		Observer observer2 = new GraphObserver();
		nb.addObserver(observer2);
		nb.addObserver(observer1);
		nb.execute();
	}
	
}
