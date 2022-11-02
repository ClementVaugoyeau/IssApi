package com.group.IssApi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AstronautNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AstronautNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String astronautNotFoundHandler(AstronautNotFoundException ex){
        return ex.getMessage();
    }
    
}
