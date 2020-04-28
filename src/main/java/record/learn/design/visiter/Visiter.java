package record.learn.design.visiter;

public interface Visiter {

	void visite(Park park);
	
	void visite(ParkPositionA parka);
	
	void visite(ParkPositionB parkb);
	
}
