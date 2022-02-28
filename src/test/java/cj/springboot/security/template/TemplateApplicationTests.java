package cj.springboot.security.template;

import cj.springboot.security.template.util.redis.CJRedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class TemplateApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {

        System.out.println(passwordEncoder.matches("1111","$2a$10$zg/l6D8/A2hal6eUTHLVR.H/gkHjB3xP7y4Xcx8fV1eLJFGCMqIui"));
        System.out.println(passwordEncoder.matches("1111","$2a$10$zJcXofUecTR0wFwS5MF.y.5NP9BP4Az2qmFfm8nqfThp1S0qYn5qK"));
    }

    @Autowired
    private CJRedisCache cjRedisCache;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void redis01(){
        String k12 = stringRedisTemplate.opsForValue().get("k1");
        System.out.println(k12);
        redisTemplate.opsForValue().set("k2","v2");
//        Object k2 = redisTemplate.opsForValue().get("k2");
//        System.out.println(k2);
        Object k11 = cjRedisCache.getCacheObject("k2");
        System.out.println(k11);
    }
}
