package com.example.cache.caffeine.service;

import com.example.cache.util.ThreadUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CaffeineAnnotationService {

    // A是缓存名称，#type是具体的key，支持SpEL
    @Cacheable(value="A", key = "#type")
    public Integer getFromA(Integer type){
        ThreadUtils.sleep(5000);
        return type + 1;
    }

    // B是缓存名称，#type是具体的key，支持SpEL
    @Cacheable(value="B", key = "#type")
    public Integer getFromB(Integer type){
        ThreadUtils.sleep(5000);
        return type + 1;
    }

}
