package record.learn.ram.j1;

public class GC1 {

//	-Xmx20m -Xms20m -Xmn1m -XX:SurvivoRatio=2 -XX:+PrintGCDetails 
//	-Xmx20m -Xms20m -Xmn7m -XX:NewRatio=1 -XX:SurvivorRatio=2 -XX:+PrintGCDetails
//	堆内存设置最大20m, 年轻代(eden+s0+s1=1m)
	
//	-XX:OnOutOfMemoryError=
//	-XX:+HeadDumpOnOutOfMemoryError
	
//	-XX:NewRatio=4   		4表示 新生代:老年代=1:4 即年轻带占堆的1/5 
//	-XX:SurvivorRatio=8		8表示 两个srvivor:eden = 2:8	即一个s占年轻代的1/10 
	public static void main(String[] args) {
		
		byte[] bs = null;
		for(int i=0; i<10; i++){
			bs = new byte[1*1024*1024];
		}

		System.err.println("Xmx="+Runtime.getRuntime().maxMemory()/1024.0/1024+"M");
		System.err.println("free mem="+Runtime.getRuntime().freeMemory()/1024.0/1024+"M");
		System.err.println("total mem="+Runtime.getRuntime().totalMemory()/1024.0/1024+"M");
	}
	
}
