package com.example.RestAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemNofFoundExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ItemNofFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String itemNotFoundHandler (ItemNofFoundException ex) {
        return ex.getMessage();
    }
}
