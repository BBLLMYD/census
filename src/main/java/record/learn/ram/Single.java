package record.learn.ram;

public class Single {

	private static Single single;

	public static int count1;
	public static int count2 = 0;
	
	public static Single getInstanse(){
		if(single==null){
			return new Single();
		}else{
			return single;
		}	
	}
	private Single(){
		count1++;
		count2++;
	}
	
	public static void main(String[] args) {
		Single single = Single.getInstanse();
		System.out.println(single.count1);
		System.out.println(single.count2);
	}
}
