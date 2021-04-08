package com.h3c.arvin.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/test")
    public String test() {
        //int i = 10 / 0;
        return "greeting";
    }
}
