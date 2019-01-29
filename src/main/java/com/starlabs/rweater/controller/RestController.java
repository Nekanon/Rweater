package com.starlabs.rweater.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @RequestMapping(value="/rest")
    public String hello() {
        return "Hello, Rest";
    }
}
