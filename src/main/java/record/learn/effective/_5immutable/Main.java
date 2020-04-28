package record.learn.effective._5immutable;

public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
		sum += i;
		}
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.err.println((end-start));
	}
	
}
