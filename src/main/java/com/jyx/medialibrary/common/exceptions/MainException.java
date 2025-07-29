package com.jyx.medialibrary.common.exceptions;

public class MainException extends RuntimeException {

    public MainException(String message) {
        super(message);
    }

    public MainException(String message, Throwable cause) {
        super(message, cause);
    }
}
