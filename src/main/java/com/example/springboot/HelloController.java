package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

import com.example.wk.IDbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    IDbService db;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/q")
    public String q() throws SQLException {
        System.out.print("new request /q");
        db.q();
        return "Hello";
    }

}