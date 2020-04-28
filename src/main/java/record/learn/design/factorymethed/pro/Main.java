package record.learn.design.factorymethed.pro;

public class Main {

	public static void main(String[] args) {
		OperationFactory factory = new AddOperationFactory();
		Operation operation = factory.getOperation();
		operation.setNum1(1);
		operation.setNum2(1);
		System.out.println(operation.getRes());
	}
	
}
