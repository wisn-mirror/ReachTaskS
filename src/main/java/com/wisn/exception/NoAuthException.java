package com.wisn.exception;

public class NoAuthException extends RuntimeException {
    public NoAuthException(String message) {
        super(message);
    }

    public NoAuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
