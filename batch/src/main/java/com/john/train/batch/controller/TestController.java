package com.john.train.batch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JohnConstantine
 * @date 2023/5/10 01:58
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
