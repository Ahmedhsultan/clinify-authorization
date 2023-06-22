package com.example.clinifyauthorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test")
    public String method() {
        System.out.println("test");
        return "ok";
    }
    @GetMapping("success")
    public String success() {
        System.out.println("success");
        return "success";
    }
    @GetMapping("fail")
    public String fail() {
        System.out.println("fail");
        return "fail";
    }
    @GetMapping("proccess")
    public String proccess() {
        System.out.println("proccess");
        return "proccess";
    }
}
