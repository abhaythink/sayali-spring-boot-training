package com.think.learn_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("hello-world/{name}")
    public  String printMessage(@PathVariable String name){
        return  "Hello World "+name;
    }


}
