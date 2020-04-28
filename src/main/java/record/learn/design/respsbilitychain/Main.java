package record.learn.design.respsbilitychain;

public class Main {

	public static void main(String[] args) {
		Support s0 = new LimitSupport("limit",4);
		Support s1 = new OddSupport("odd");
		Support s2 = new SpecialSupport("Special",7);
		s0.setNext(s1).setNext(s2).support(new Trouble(6));
	}
	
}
