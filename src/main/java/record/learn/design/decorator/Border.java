package record.learn.design.decorator;

public abstract class Border extends Dispaly{
	protected Dispaly dispaly;

	public Border(Dispaly dispaly) {
		super();
		this.dispaly = dispaly;
	}
}
