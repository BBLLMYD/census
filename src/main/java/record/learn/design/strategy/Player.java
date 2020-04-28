package record.learn.design.strategy;

public class Player {

	private String name;
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int gamecount;
	public Player(String name, Strategy strategy) {
		super();
		this.name = name;
		this.strategy = strategy;
	}

	public Hand nextHand(){
		return strategy.nextHand();
	}
	
	public void win(){
		strategy.study(true);
		wincount++;
		gamecount++;
	}
	public void lose(){
		strategy.study(false);
		losecount++;
		gamecount++;
	}

	public void even(){
		gamecount++;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", strategy=" + strategy + ", wincount=" + wincount + ", losecount=" + losecount
				+ ", gamecount=" + gamecount + "]";
	}

}
