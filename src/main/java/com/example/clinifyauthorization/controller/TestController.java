package com.example.clinifyauthorization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test")
    public String method() {
        System.out.println("test");
        return "ok";
    }
    @GetMapping("success")
    public ResponseEntity success() {
        System.out.println("success");
        return ResponseEntity.ok().build();
    }
    @GetMapping("fail")
    public ResponseEntity fail() {
        System.out.println("fail");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    @GetMapping("proccess")
    public String proccess() {
        System.out.println("proccess");
        return "proccess";
    }
}
