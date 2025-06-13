package com.my.admin.app.demo.adminapp.exceptions;

import java.time.LocalDateTime;

public class MyCustomException extends RuntimeException {

    private final int statusCode;
    private final LocalDateTime timestamp;

    public MyCustomException(String message, int statusCode, LocalDateTime timestamp) {
        super(message);
        this.statusCode = statusCode;
        this.timestamp = timestamp != null ? timestamp : LocalDateTime.now();
    }

    public MyCustomException(String message) {
        super(message);
        statusCode = 500;
        timestamp = LocalDateTime.now();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
