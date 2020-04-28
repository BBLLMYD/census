package record.learn.design.respsbilitychain;

public class Trouble {

	private int num;

	public Trouble(int num) {
		super();
		this.setNum(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return " { trouble"+ num + " } ";
	}
	
}
