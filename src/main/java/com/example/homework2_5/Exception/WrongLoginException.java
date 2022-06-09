package com.example.homework2_5.Exception;

public class WrongLoginException extends RuntimeException {

    public WrongLoginException(String message) {
        super(message);
    }
}