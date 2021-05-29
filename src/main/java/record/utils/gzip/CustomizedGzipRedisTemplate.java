package record.utils.gzip;

import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomizedGzipRedisTemplate extends RedisTemplate<String, String> {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 只针对非空的值进行序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 将类型序列化到属性json字符串中
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        // 对于找不到匹配属性的时候忽略报错
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 不包含任何属性的bean也不报错
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public CustomizedGzipRedisTemplate() {
        GzipRedisSerializer gzipRedisSerializer = new GzipRedisSerializer();
        setKeySerializer(RedisSerializer.string());
        setValueSerializer(gzipRedisSerializer);
        setHashKeySerializer(RedisSerializer.string());
        setHashValueSerializer(gzipRedisSerializer);
    }

    public CustomizedGzipRedisTemplate(RedisConnectionFactory connectionFactory) {
        this();
        setConnectionFactory(connectionFactory);
        afterPropertiesSet();
    }

    @Override
    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        return new DefaultStringRedisConnection(connection);
    }

    public <T> T get(String key, Class<T> valueType) {
        String value = this.opsForValue().get(key);
        if (value == null) {
            return null;
        }
        try {
            return objectMapper.readValue(value, valueType);
        } catch (Exception e) {
            log.error("读取redis缓存异常", e);
            return null;
        }
    }

    public <T> T get(String key, TypeReference valueType) {
        String value = this.opsForValue().get(key);
        if (value == null) {
            return null;
        }
        try {
            return objectMapper.readValue(value, valueType);
        } catch (Exception e) {
            log.error("读取redis缓存异常", e);
            return null;
        }
    }

    public void set(String key, Object value) {
        if (value == null) {
            log.warn("value值为null，不刷新redis缓存");
            return;
        }
        try {
            String strValue = objectMapper.writeValueAsString(value);
            this.opsForValue().set(key, strValue);
        } catch (Exception e) {
            log.error("更新redis缓存异常", e);
        }
    }


}
