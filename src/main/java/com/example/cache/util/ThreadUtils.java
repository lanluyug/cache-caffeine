package com.example.cache.util;

public class ThreadUtils {


    public static void sleep(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
