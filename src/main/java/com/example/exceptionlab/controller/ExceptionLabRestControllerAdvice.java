package com.example.exceptionlab.controller;

import com.example.exceptionlab.exception.DuplicatedMemberNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionLabRestControllerAdvice {

    Logger logger = LoggerFactory.getLogger(ExceptionLabRestControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(Exception exception) {
        logger.error("Internal Server Exception: {}", exception.getMessage());
        return exception.getMessage();
    }

    @ExceptionHandler(DuplicatedMemberNameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String duplicatedMemberNameExceptionHandler(DuplicatedMemberNameException e){
        logger.error("DuplicatedMemberNameException: {}", e.getMessage());
        return e.getMessage();
    }
}
