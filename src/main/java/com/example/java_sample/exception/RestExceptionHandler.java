package com.example.java_sample.exception;

import com.example.java_sample.dto.error.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ExistingUserException.class)
    protected ResponseEntity<Object> existingUserExceptionHandler(ExistingUserException existingUserException,
                                                                  HttpHeaders headers, HttpStatus status) {
        ErrorResponse response =
                new ErrorResponse("existing_user",
                        "User already exists");

        return new ResponseEntity<>(response, headers, status);
    }
}
