package com.aravind.spring.secu.demo.springSecTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @GetMapping("/")
    public String exec(){
        return new String("hellow world");
    }
}
