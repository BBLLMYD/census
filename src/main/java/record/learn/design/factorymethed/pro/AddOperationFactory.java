package record.learn.design.factorymethed.pro;

public class AddOperationFactory implements OperationFactory{

	@Override
	public Operation getOperation() {
		return new AddOperation();
	}

}
