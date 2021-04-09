package com.h3c.arvin.demo.controller;

import com.h3c.arvin.demo.annotation.IgnoreResponseAdvice;
import com.h3c.arvin.demo.exception.AdException;
import com.h3c.arvin.demo.vo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    //@IgnoreResponseAdvice
    @RequestMapping("/test")
    public User test() throws AdException {
        int age = 18;
        if (age == 18)
            throw new AdException("age error");
        User user = new User("arvin", 18);
        return user;
    }
}
