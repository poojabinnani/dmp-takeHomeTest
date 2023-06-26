package com.interview.assignment.dmptakeHome.exceptions;

public class ApiRequestException extends Exception{
    public ApiRequestException(String message, Throwable th){
        super(message, th);
    }

    public ApiRequestException(String message){
        super(message);
    }
}
