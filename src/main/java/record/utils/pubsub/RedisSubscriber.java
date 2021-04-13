package record.utils.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import record.utils.EnvironmentUtil;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2021-04-11
 */
@Component
@Slf4j
public class RedisSubscriber {

    @Autowired
    private EnvironmentUtil environmentUtil;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void receiveMessage(String message) {
        if(environmentUtil.isPro() || environmentUtil.isLocal()){
            return;
        }
    }

}
