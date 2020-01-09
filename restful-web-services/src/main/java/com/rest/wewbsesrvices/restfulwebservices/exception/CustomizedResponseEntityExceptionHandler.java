package com.rest.wewbsesrvices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions
            (Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = new ExceptionResponse
                (request.getDescription(false),
                        ex.getMessage(),
                        new Date());

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException
             (UserNotFoundException ex , WebRequest webRequest) throws UserNotFoundException {
         ExceptionResponse exceptionNotFoundResponse = new ExceptionResponse
                                               (webRequest.getDescription(false),
                                                ex.getMessage(),
                                                new Date());
          return new ResponseEntity(exceptionNotFoundResponse, HttpStatus.NOT_FOUND);
    }
}

