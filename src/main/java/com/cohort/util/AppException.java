package com.cohort.util;

public class AppException extends Exception{

    private static final long serialVersionUID = 1L;

    private String message = null;

    public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
        this.message = message;
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(String message, Throwable cause){
        super(message, cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
