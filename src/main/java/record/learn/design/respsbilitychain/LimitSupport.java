package record.learn.design.respsbilitychain;

public class LimitSupport extends Support{
	
	private int limit;
	
	public LimitSupport(String name,int limit) {
		super(name);
		this.limit = limit;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if(this.limit>trouble.getNum()){
			return true;
		}else{
			return false;
		}
	}
	
}
