package record.learn.design.visiter;

public class VisiterA implements Visiter{

	@Override
	public void visite(Park park) {
		
	}

	@Override
	public void visite(ParkPositionA parka) {
		System.out.println("VisiterA CLEANING ParkPositionA ...");
	}

	@Override
	public void visite(ParkPositionB parkb) {
		
	}

}
