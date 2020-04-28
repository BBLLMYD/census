package record.learn.design.visiter;

public class VisitorManager implements Visiter{

	@Override
	public void visite(Park park) {
		System.out.println("管理员负责检查公园Park");
	}

	@Override
	public void visite(ParkPositionA parka) {
		System.out.println("管理员负责检查公园ParkPositionA");
	}

	@Override
	public void visite(ParkPositionB parkb) {
		System.out.println("管理员负责检查公园ParkPositionB");
	}

}
