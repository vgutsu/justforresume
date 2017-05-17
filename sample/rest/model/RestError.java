package com.cinecentre.cinecentrecinema.rest.model;

public class RestError {
    private int statusCode;
    private String message;

    public RestError() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}

