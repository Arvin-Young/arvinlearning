package com.h3c.arvin.demo.controller;

import com.h3c.arvin.demo.exception.AdException;
import com.h3c.arvin.demo.vo.UserBO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    //@IgnoreResponseAdvice
    @RequestMapping("/test")
    public UserBO test() throws AdException {
        int age = 18;
        if (age == 18)
            throw new AdException("age error");
        UserBO user = new UserBO("arvin", 18);
        return user;
    }
}
