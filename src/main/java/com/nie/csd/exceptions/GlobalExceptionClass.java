package com.nie.csd.exceptions;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionClass {

    @ExceptionHandler(IdNotPresentException.class)  
    public String handleIdNotPresentException(IdNotPresentException ex) {
        return ex.getMessage();
    }

}