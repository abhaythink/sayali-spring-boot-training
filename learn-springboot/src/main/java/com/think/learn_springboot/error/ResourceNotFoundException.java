package com.think.learn_springboot.error;


import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceNotFoundException extends Throwable {


    public ResourceNotFoundException(String message) {
    }
}
