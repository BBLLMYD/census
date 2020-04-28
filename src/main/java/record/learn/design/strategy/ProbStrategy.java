package record.learn.design.strategy;

import java.util.Random;

public class ProbStrategy implements Strategy{

	public ProbStrategy(int seed){
		
	}
	
	
	@Override
	public Hand nextHand() {
		return Hand.getHand(new Random().nextInt(3));
	}

	@Override
	public void study(boolean win) {
		
	}

}
