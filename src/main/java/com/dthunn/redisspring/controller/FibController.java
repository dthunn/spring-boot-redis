package com.dthunn.redisspring.controller;

import com.dthunn.redisspring.service.FibService;
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
}
