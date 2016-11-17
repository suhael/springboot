package com.suhael.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SimpleController {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(method = RequestMethod.GET)
    public String showSimpleResponse(){
        useRedis();
        return "index";
    }

    private void useRedis() {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.template.hasKey(key)) {
            ops.set(key, "foo");
        }
        LOG.info("REDIS: Found key " + key + ", value=" + ops.get(key));
    }

    private void storeSSOToken(String accessToken, String ssoToken) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        ops.set(accessToken, ssoToken);
        //set expiry??
    }

    private String getSSOToken(String accessToken) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(accessToken);
    }

    private void removeSSOToken(String accessToken) {
//        ValueOperations<String, String> ops = this.template.opsForValue();
        this.template.delete(accessToken);
    }
}
