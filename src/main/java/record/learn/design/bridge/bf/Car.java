package record.learn.design.bridge.bf;

public abstract class Car {

	private Engine engine;

	public Car(Engine engine) {
		super();
		this.setEngine(engine);
	}
	public abstract void installEngine();
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
}
