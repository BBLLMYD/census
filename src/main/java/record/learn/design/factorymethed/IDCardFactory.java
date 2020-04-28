package record.learn.design.factorymethed;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory{

//	private List<String> list = new ArrayList<String>();
	private List<Product> list = new ArrayList<Product>();
	
	@Override
	public Product createPro(String owner) {
		return new IDCard(owner);
	}

	@Override
	public void registerPro(Product pro) {
//		list.add(((IDCard)pro).getName());
		list.add(pro);
	}

	public List<? extends Product> getIDCards(){
		return list;
	}
	
}
