package com.zqj.consumer.controller;

import com.zqj.consumer.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @GetMapping("hello")
    public String hello(String name){
        return this.helloService.hello(name);
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

}
