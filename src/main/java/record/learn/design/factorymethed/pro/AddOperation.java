package record.learn.design.factorymethed.pro;

public class AddOperation extends Operation{

	@Override
	protected int getRes() {
		return getNum1()+getNum2();
	}

}
