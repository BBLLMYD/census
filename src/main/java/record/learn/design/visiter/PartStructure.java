package record.learn.design.visiter;

public class PartStructure implements Park{

	private ParkPositionA parka;
	private ParkPositionB parkb;
	
	public PartStructure(){
		this.parka = new ParkPositionA();
		this.parkb = new ParkPositionB();
	}
	
	@Override
	public void accept(Visiter v) {
		v.visite(this);
		parka.accept(v);
		parkb.accept(v);
	}

	
	
	
/*	List<Park> list = new ArrayList<Park>();

	PartStructure append(Park park){
		this.list.add(park);
		return this;
	}

	@Override
	public void accept(Visiter v) {
		for(Park park : list){
			park.accept(v);
		}
	}*/
	
}
