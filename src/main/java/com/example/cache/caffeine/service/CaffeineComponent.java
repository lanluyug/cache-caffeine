package com.example.cache.caffeine.service;

import com.example.cache.caffeine.entity.Key;
import com.example.cache.caffeine.entity.Value;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class CaffeineComponent {

    LoadingCache<Key, Value> cache = Caffeine.newBuilder()
            .maximumSize(10_000)
            .expireAfterWrite(Duration.ofMinutes(5))
            .refreshAfterWrite(Duration.ofMinutes(1))
            .build(this::createExpensiveGraph);

    /**
     * 如果缓存中找不到，则走此高昂的方式获取
     * 获取之后的值，也将存入缓存中
     * @param key KEY
     * @return Value
     */
    private Value createExpensiveGraph(Key key) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Value("得到我可不容易", "555");
    }

}
