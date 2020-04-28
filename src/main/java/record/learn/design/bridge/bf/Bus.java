package record.learn.design.bridge.bf;

public class Bus extends Car{

	public Bus(Engine engine) {
		super(engine);
	}

	@Override
	public void installEngine() {
		System.out.println("bus:");
		this.getEngine().installEngine();
	}

	
}
