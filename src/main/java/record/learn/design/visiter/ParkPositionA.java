package record.learn.design.visiter;

public class ParkPositionA implements Park{

	@Override
	public void accept(Visiter v) {
		v.visite(this);
	}

}
