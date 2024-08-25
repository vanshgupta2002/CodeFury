package com.mycomapny.exceptions;

public class InsufficientCreditsException extends Exception {
    public InsufficientCreditsException(String message) {
        super(message);
    }
}