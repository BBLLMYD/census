package record.learn.design.visiter;

public class VisiterB implements Visiter{

	@Override
	public void visite(Park park) {
		
	}

	@Override
	public void visite(ParkPositionA parka) {
	}

	@Override
	public void visite(ParkPositionB parkb) {
		System.out.println("VisiterB CLEANING ParkPositionB ...");
	}

}
