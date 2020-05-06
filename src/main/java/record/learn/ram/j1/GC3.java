package record.learn.ram.j1;

public class GC3 {

	private static final int _1M = 1024*1024;
	
	public static void main(String[] args) {
//		testAllocation();
//		testPretenureSizeThreshold();
//		testTenuringThreshold();
		testTenuringThreshold2();
	}
	

	/**
	 * 对象优先在eden分配
	 * 
	 * VM args: 
	 * -verbose:gc -Xms=20m -Xmx=20m -Xmn=10m 
	 * -XX:SurvivorRatio=8
	 * -XX:+PrintGCDetails 
	 */
	@SuppressWarnings("unused")
	public static void testAllocation(){
		byte[] bs1, bs2, bs3, bs4;
		bs1 = new byte[2*_1M];
		bs2 = new byte[2*_1M];
		bs3 = new byte[2*_1M];
		bs4 = new byte[4*_1M];
	}
	
	/**
	 * 大对象直接进入到老年代
	 * PretenureSizeThreshold参数只对Serial和ParNew两款收集器有效,Parallel Scavenge并不认识这个参数
	 * 一般用到此参数可考虑ParNew+CMS组合
	 * 
	 * VM args: 
	 * -verbose:gc -Xms=20m -Xmx=20m -Xmn=10m 
	 * -XX:SurvivorRatio=8
	 * -XX:PretenureSizeThreshold=3145728 	//3M
	 * -XX:+PrintGCDetails 
	 * 
	 * -XX:+UseConcMarkSweepGC	//cms
	 */
	@SuppressWarnings("unused")
	public static void testPretenureSizeThreshold(){
		byte[] allocation;
		allocation = new byte[4*_1M];
	}
	
	/**
	 * 长期存活的对象进入老年代
	 * PretenureSizeThreshold参数只对Serial和ParNew两款收集器有效,Parallel Scavenge并不认识这个参数
	 * 一般用到此参数可考虑ParNew+CMS组合
	 * 
	 * VM args: 
	 * -verbose:gc -Xms=20m -Xmx=20m -Xmn=10m 
	 * -XX:SurvivorRatio=8
	 * -XX:MaxTenuringThreshold=1	//对象年龄计数器, 默认值是15***(计数到15时候移到老年代), 值设置为1时, 第二次MinorGC时, 直接进入到老年代(不经历s0/s1区)
	 * -XX:PrintTenuringDistribution
	 * -XX:+PrintGCDetails 
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold(){
		byte[] allocaition1,allocaition2,allocaition3;
		allocaition1 = new byte[_1M/4];
		//什么时候进入老年代取决于XX:MaxTenuringThreshold的配置
		allocaition2 = new byte[4*_1M];
		allocaition3 = new byte[4*_1M];
		allocaition3 = null;
		allocaition3 = new byte[4*_1M];
	}

	/**
	 * 动态对象年龄判定
	 * 同年对象达到survivor空间一半的规则
	 * 
	 * VM args: 
	 * -verbose:gc -Xms=20m -Xmx=20m -Xmn=10m 
	 * -XX:SurvivorRatio=8
	 * -XX:MaxTenuringThreshold=15	
	 * -XX:+PrintGCDetails 
	 * -XX:PrintTenuringDistribution
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold2(){
		byte[] allocaition1,allocaition2,allocaition3,allocaition4;
		allocaition1 = new byte[_1M/4];
		allocaition2 = new byte[_1M/4];
		//allocation1+,allocaition2大于survivo空间的一半
		allocaition3 = new byte[4*_1M];
		allocaition4 = null;
		allocaition4 = new byte[4*_1M];
	}
	
	/**
	 * 空间分配担保
	 * 
	 * 只要老年代连续空间大小小于历次平均值,进行FullGC
	 * -verbose:gc -Xms=20m -Xmx=20m -Xmn=10m 
	 * -XX:SurvivorRatio=8
	 * -XX:+PrintGCDetails 
	 * -XX:-HandlePromotionFailure
	 */
	@SuppressWarnings("unused")
	public static void testHandlePromotion(){
		byte[] allocaition1,allocaition2,allocaition3,allocaition4,allocaition5,allocaition6,allocaition7;
		allocaition1 = new byte[2*_1M];
		allocaition2 = new byte[2*_1M];
		allocaition3 = new byte[2*_1M];
		allocaition1 = null;
		allocaition4 = new byte[2*_1M];
		allocaition5 = new byte[2*_1M];
		allocaition6 = new byte[2*_1M];
		allocaition4 = null;
		allocaition5 = null;
		allocaition6 = null;
		allocaition7 = new byte[2*_1M];
	}
	
}
