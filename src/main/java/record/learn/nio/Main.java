package record.learn.nio;

public class Main {

	public static void main(String[] args) {
		String str = "aAb";
		System.out.println(str.getBytes());
		System.out.println(str.getBytes().length);
		for(byte s :str.getBytes()){
			System.out.println(s);
		}
		System.out.println('a'+'b');
		System.out.println(97+'b');
		char s = 'a';
		byte a = 'a';
		System.out.println(s+a);
	}
	
}
