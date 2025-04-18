package com.dthunn.redisspring.fib.controller;

import com.dthunn.redisspring.fib.service.FibService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fib")
@RequiredArgsConstructor
public class FibController {

    private final FibService fibService;

    @GetMapping("{index}/{name}")
    public Mono<Integer> getFibonacciNumber(@PathVariable int index, @PathVariable String name) {
        return Mono.fromSupplier(() -> fibService.getFib(index, name));
    }


    @GetMapping("{index}/clear")
    public Mono<Void> clearCache(@PathVariable int index){
        return Mono.fromRunnable(() -> this.fibService.clearCache(index));
    }
}
