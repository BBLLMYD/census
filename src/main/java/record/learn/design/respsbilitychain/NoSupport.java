package record.learn.design.respsbilitychain;

public class NoSupport extends Support{

	public NoSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return false;				//解决方式就是解决不了
	}

}
