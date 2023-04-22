package com.example.cache.caffeine.controller;

import com.example.cache.caffeine.service.CaffeineAnnotationService;
import com.example.cache.caffeine.service.CaffeineService;
import com.example.cache.caffeine.entity.Key;
import com.example.cache.caffeine.entity.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CaffeineController {

    @Autowired
    private CaffeineService caffeineService;

    @Autowired
    private CaffeineAnnotationService caffeineAnnotationService;

    @PostMapping("add")
    public Boolean add(@RequestBody Key key){
        return caffeineService.add(key);
    }

    @PostMapping("get")
    public Value get(@RequestBody Key key){
        return caffeineService.get(key);
    }


    @PostMapping("getA")
    public Integer getFromA(Integer key){
        return caffeineAnnotationService.getFromA(key);
    }

    @PostMapping("getB")
    public Integer getFromB(Integer key){
        return caffeineAnnotationService.getFromB(key);
    }
}
