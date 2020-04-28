package record.learn.design.adtpter.a;
/**
 * Adaptee(被适配)
 *
 * @author: mqw   
 * @date:   2018年5月16日 上午10:15:34
 */
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
