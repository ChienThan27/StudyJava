package com.example.hello.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(NullPointerException.class)
    public String nullPointer(Exception ex){
        ex.printStackTrace();
        return "null-pointer";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgument(Exception ex){
        ex.printStackTrace();
        return "illegal-argument";
    }
}
