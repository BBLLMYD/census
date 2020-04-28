package record.learn.design.observer;

import java.util.Random;

public class RandomNumberGenerator extends Numbergenerator{

	private Random r = new Random();
	private int number;
	
	@Override
	protected int getNumber() {
		return number;
	}

	@Override
	protected void execute() {
		for(int i=0; i<20; i++){
			number = r.nextInt(50);
			notifyObserver();
		}
	}

}
