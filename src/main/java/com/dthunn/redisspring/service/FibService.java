package com.dthunn.redisspring.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FibService {

    @Cacheable(value = "math:fib", key = "#index")
    public int getFib(int index, String name) {
        System.out.println("Getting Fibonacci number for index " + index + ", name " + name);
        return fib(index);
    }

    private int fib(int number) {
        if (number <= 1) {
            return number;
        }
        return fib(number - 1) + fib(number - 2);
    }
}
