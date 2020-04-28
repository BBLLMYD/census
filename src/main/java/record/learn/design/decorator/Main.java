package record.learn.design.decorator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.Reader;

public class Main {

	public static void main(String[] args) {
		Dispaly b1 = new StringDisplay("hello world");
		Dispaly b2 = new SideBorder(b1, '#');
		Dispaly b3 = new FullBorder(b2);
		
		b1.show();
		b2.show();
		b3.show();
		
		Dispaly b4 = new SideBorder(new FullBorder(new SideBorder(new FullBorder(new StringDisplay("你好啊世界   ")), '*')), '/');
		b4.show();
	}
	
	
	static void jdkio() throws Throwable{
		Reader r1 = new FileReader("");
		Reader r2 = new BufferedReader(new FileReader(""));
		Reader r3 = new LineNumberReader(new BufferedReader(new FileReader("")));
	}
	
}
