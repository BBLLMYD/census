package record.utils;

import java.util.concurrent.ExecutionException;

import com.google.common.util.concurrent.ListenableFutureTask;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2021-04-15
 */
public class FutureTaskUtils {

    public static <T> T futureTask() throws ExecutionException, InterruptedException {
        return (T) ListenableFutureTask.create(()->doSthAsync()).get();
    }

    private static <V> V doSthAsync() {
        return null;
    }


}
