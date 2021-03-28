package record.learn.pthread;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StackTrace {
	
	public static void main(String[] args) {
		Map<Thread, StackTraceElement[]> traces = Thread.getAllStackTraces();
		Set<Entry<Thread, StackTraceElement[]>> entrySet = traces.entrySet();
		for(Entry<Thread, StackTraceElement[]> entry : entrySet){
			Thread key = entry.getKey();
			System.out.println(key);
			StackTraceElement[] value = entry.getValue();
			for(StackTraceElement ste : value){
				System.err.print(ste+"---");
			}
			System.out.println("=======");
		}
	}

}
