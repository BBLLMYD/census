package record.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author laiwenchao <laiwenchao@kuaishou.com>
 * Created on 2020-08-25
 */
@Component
public class EnvironmentUtil {

    @Autowired
    private Environment environment;

    private static final String local = "local";
    private static final String dev = "development";
    private static final String prod = "production";
    private static final String nosso = "nosso";

    private static final String pre = "pre";

    public List<String> getActiveProfiles() {
        return Arrays.asList(environment.getActiveProfiles());
    }

    public boolean isLocal() {
        return getActiveProfiles().contains(local);
    }

    public boolean isDev() {
        return getActiveProfiles().contains(dev);
    }

    public boolean isNosso() {
        return getActiveProfiles().contains(nosso);
    }

    /**
     * 是否预生产环境
     */
    public boolean isPre() {
        return getActiveProfiles().contains(pre);
    }

    public boolean isPro() {
        return getActiveProfiles().contains(prod);
    }
}
