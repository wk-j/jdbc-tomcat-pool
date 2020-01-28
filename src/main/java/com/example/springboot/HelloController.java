package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import com.example.wk.A;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        A.query();
        return "Greetings from Spring Boot!";
    }

}