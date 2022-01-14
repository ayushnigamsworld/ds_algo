package fiftyfivetechnology.persistence.config;

import java.util.HashMap;
import java.util.Map;

public class RedisService {

    Map<String, String> cache = new HashMap<>();

    public String get(String key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        return cache.get(key);
    }

    public void set(String key, String value, Long expiry) {
        // handle expiry on actual Redis
        cache.put(key, value);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    private RedisService() {
        // get the connection details etc here
    }

    private static RedisService ourInstance = new RedisService();

    public static RedisService getInstance() {
        return ourInstance;
    }
}
