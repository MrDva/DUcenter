package com.itjizhiyong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class helloController {
    @RequestMapping("/world")
    public String helloWorld(){
        return "hello world";
    }
}
