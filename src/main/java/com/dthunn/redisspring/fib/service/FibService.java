package com.dthunn.redisspring.fib.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FibService {

    @Cacheable(value = "math:fib", key = "#index")
    public int getFib(int index, String name) {
        System.out.println("Getting Fibonacci number for index " + index + ", name " + name);
        return fib(index);
    }

    // PUT / POST / PATCH / DELETE
    @CacheEvict(value = "math:fib", key = "#index")
    public void clearCache(int index){
        System.out.println("clearing hash key");
    }

    @Scheduled(fixedRate = 10_000)
    @CacheEvict(value = "math:fib", allEntries = true)
    public void clearCache(){
        System.out.println("clearing all fib keys");
    }

    private int fib(int number) {
        if (number <= 1) {
            return number;
        }
        return fib(number - 1) + fib(number - 2);
    }
}
