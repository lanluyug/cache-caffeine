package com.example.cache.caffeine.service;

import com.example.cache.caffeine.entity.Key;
import com.example.cache.caffeine.entity.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaffeineService {

    @Autowired
    private CaffeineComponent caffeineComponent;

    public boolean add(Key key){
        boolean success = true;
        try{
            caffeineComponent.cache.put(key, new Value("test","111"));
        }catch (Exception e){
            success = false;
        }
        return success;
    }

    public Value get(Key key){
        return caffeineComponent.cache.get(key);
    }

}
