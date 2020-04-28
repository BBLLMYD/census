package record.learn.design.respsbilitychain;

public class SpecialSupport extends Support{
	private int num;
	public SpecialSupport(String name,int num) {
		super(name);
		this.num = num;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNum()==num){
			return true;
		}
		return false;
	}
	
}
