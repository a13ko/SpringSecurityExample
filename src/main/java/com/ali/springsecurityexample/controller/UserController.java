package com.ali.springsecurityexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/admin")
    public String admin(){
        return "Welcome to admin page";
    }
    @GetMapping("/index")
    public String index(){
        return "Welcome to login page";
    }
    @GetMapping("/dashboard")
    public String dashboard(){
        return "Successful Login, Welcome...";
    }
}
