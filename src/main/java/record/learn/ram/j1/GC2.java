package record.learn.ram.j1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class GC2 {

	public static void main(String[] args) {
		/*String intern = "";
		String intern2 = "";
		for(int i=0 ; i<1000000; i++){
			intern = UUID.randomUUID().toString().intern();
			intern2 = ((new Random().nextInt(1000*1000))+"").intern();
		}*/
		
		List<String> list = new ArrayList<>();
		int i =0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
	
}
