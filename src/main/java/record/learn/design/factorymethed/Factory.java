package record.learn.design.factorymethed;

public abstract class Factory {

	public final Product create(String owner){
		Product createPro = createPro(owner);
		registerPro(createPro);
		return createPro;
	}
	public abstract Product createPro(String owner);
	public abstract void registerPro(Product pro);
}
