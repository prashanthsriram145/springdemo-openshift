package com.home.personal.springdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Value("${username}")
    private String username;


    @GetMapping("/welcome")
    public String getHello() {
        return String.format("Hello %s", username);
    }
}
