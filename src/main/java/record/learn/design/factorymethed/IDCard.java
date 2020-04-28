package record.learn.design.factorymethed;

public class IDCard implements Product{

	private String name;
	
	IDCard(String name){
		this.name = name;
		System.out.println("制作"+name+"的ID卡");
	}
	
	@Override
	public void use() {
		System.out.println("使用"+name+"的ID卡");
	}

	public String getName(){
		return name;
	}
}
