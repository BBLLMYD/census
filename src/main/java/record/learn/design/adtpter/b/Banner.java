package record.learn.design.adtpter.b;

public class Banner {

	private String str;
	
	String showWithParen(){
		String strAft = "("+str+")";
		System.err.println(strAft);
		return strAft;
	}
	
	String showWithAster(){
		String strAfter = "*"+str+"*";
		System.err.println(strAfter);
		return strAfter;
	}

	public Banner(String str) {
		super();
		this.str = str;
	}
	
}
