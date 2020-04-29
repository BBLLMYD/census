package record.learn.pthread.juc;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并
 *
 * @author: mqw   
 * @date:   2018年8月28日 下午3:01:31
 */
public class TestForkJoinPool {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinPoolDemo(1,1000000000);
		Instant now = Instant.now();

		Long invoke = pool.invoke(task);
		System.out.println(invoke);
//		long i = 0;
//		for(i=0; i<1000000000; i++){
//			i+=i;
//		}
//		System.out.println(i);
		
		Instant now2 = Instant.now();
		System.out.println(Duration.between(now, now2));
	}
	
}

class ForkJoinPoolDemo extends RecursiveTask<Long>{
	private static final long serialVersionUID = 4509914232433282678L;
	private static final long THOUSHOLD = 100;
	
	private long start;
	private long end;
	
	public ForkJoinPoolDemo(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start;
		if(length <= THOUSHOLD){
			long sum = 0;
			for(long i=start; i<end; i++){
				sum+=i;
			}
			return sum;
		}else{
			long m = (start + end) /2;
			ForkJoinPoolDemo left = new ForkJoinPoolDemo(start, m);
			left.fork();
			
			ForkJoinPoolDemo right = new ForkJoinPoolDemo(m, end);
			right.fork();
			return left.join()+right.join();
		}
	}
	
}
