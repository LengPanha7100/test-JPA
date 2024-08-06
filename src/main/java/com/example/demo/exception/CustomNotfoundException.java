package com.example.demo.exception;

public class CustomNotfoundException extends RuntimeException{
    public CustomNotfoundException(String message){
        super(message);
    }
}
