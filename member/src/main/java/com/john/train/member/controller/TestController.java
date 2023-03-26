package com.john.train.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author johnconstantine
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }


}
