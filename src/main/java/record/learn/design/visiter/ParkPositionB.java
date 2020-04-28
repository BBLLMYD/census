package record.learn.design.visiter;

public class ParkPositionB implements Park{

	@Override
	public void accept(Visiter v) {
		v.visite(this);
	}

}
