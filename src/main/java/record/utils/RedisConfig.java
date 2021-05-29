package record.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import record.utils.gzip.CustomizedGzipRedisTemplate;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2021-04-15
 */
@Component
public class RedisConfig {

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //        key 采用 String 的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        //        hash 的 key 也采用 String 的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        //        value 的序列化方式采用 JSON
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //        hash value 的序列化方式也采用 JSON
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public CustomizedGzipRedisTemplate gzipRedisTemplate(RedisConnectionFactory connectionFactory) {
        return new CustomizedGzipRedisTemplate(connectionFactory);
    }

}
