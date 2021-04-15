package record.utils;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2021-04-15
 */
public class GuavaAbstractLoadingCache<K, V> {

    private int expireAfterWriteDuration = 30;
    private TimeUnit timeUnit = TimeUnit.MINUTES;

    private LoadingCache<K, V> loadingCache;

    public LoadingCache<K, V> getCache(){
        synchronized (Object.class){
            if(Objects.isNull(loadingCache)) {
                loadingCache = CacheBuilder.newBuilder().refreshAfterWrite(expireAfterWriteDuration, timeUnit)
                                .recordStats()
                                .build(new CacheLoader<K, V>() {
                                    // 加载缓存时调用
                                    @Override
                                    public V load(K k) {
                                        return null;
                                    }
                                    // 异步刷缓存时调用
                                    @Override
                                    public ListenableFuture<V> reload(K key, V oldValue) throws Exception {
                                        return super.reload(key, oldValue);
                                    }
                                });
                return loadingCache;
            }
            return loadingCache;
        }
    }

}
