package com.wisn.exception;

public class UnRegisteredException extends RuntimeException {
    public UnRegisteredException(String message) {
        super(message);
    }

    public UnRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
