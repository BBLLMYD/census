package record.utils.gzip;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class RedisGZipUtils {

    @Autowired
    private CustomizedGzipRedisTemplate customizedGzipRedisTemplate;

    /**
     * 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
     */
    public void set(String key, Object value) {
        customizedGzipRedisTemplate.set(key,value);
    }

    public <T> T get(String key, Class<T> valueType) {
        if(StringUtils.isEmpty(key) || Objects.isNull(valueType)){
            return null;
        }
        return customizedGzipRedisTemplate.get(key, valueType);
    }

    public <T> T get(String key, TypeReference valueType) {
        if(StringUtils.isEmpty(key) || Objects.isNull(valueType)){
            return null;
        }
        return customizedGzipRedisTemplate.get(key, valueType);
    }

}
