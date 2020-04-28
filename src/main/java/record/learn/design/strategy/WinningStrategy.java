package record.learn.design.strategy;

import java.util.Random;

public class WinningStrategy implements Strategy{

	private Random random;
	private boolean won = false;
	private Hand prevhand;
	
	public WinningStrategy(int seed) {
		random = new Random(seed);
	}
	
	@Override
	public Hand nextHand() {
		if(!won){
			prevhand = Hand.getHand(random.nextInt(3));
		}
		return prevhand;
	}

	@Override
	public void study(boolean win) {
		won = win;
	}

}
