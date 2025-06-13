package com.my.admin.app.demo.adminapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<Object> handleMyCustomException(MyCustomException ex) {
         // logger
        return ResponseEntity.status(ex.getStatusCode())
                .body(new ErrorResponse(ex.getMessage(), ex.getStatusCode(), ex.getTimestamp()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        //replace with logger
        System.out.println("An unexpected error occurred: " + ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", 500, LocalDateTime.now());
        return ResponseEntity.status(500).body(errorResponse);
    }
}

record ErrorResponse(String message, int statusCode, LocalDateTime timestamp) {}