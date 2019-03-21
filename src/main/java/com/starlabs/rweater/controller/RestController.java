package com.starlabs.rweater.controller;

import com.starlabs.rweater.domain.Greeting;
import com.starlabs.rweater.domain.RestExperimental;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    /*
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/rest")
    public Greeting hello(
            @RequestParam(value="name", defaultValue="World") String name
    ) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }*/
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/rest")
    public RestExperimental hello(
            @RequestParam(value="name", defaultValue="Michael") String name
    ) {
        return new RestExperimental(counter.incrementAndGet(),
                                    name,
                                    3.14159d);
    }
}
