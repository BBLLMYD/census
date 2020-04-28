package record.learn.design.respsbilitychain;

public class OddSupport extends Support{

	public OddSupport(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNum()%2==1){			//解决奇数编号的问题
			return true;
		}
		return false;
	}

	
	
}
