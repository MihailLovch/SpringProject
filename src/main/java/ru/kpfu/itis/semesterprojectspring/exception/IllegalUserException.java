package ru.kpfu.itis.semesterprojectspring.exception;

public class IllegalUserException extends RuntimeException{
    public IllegalUserException(String message) {
        super(message);
    }

    public IllegalUserException() {
        super();
    }

    public IllegalUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalUserException(Throwable cause) {
        super(cause);
    }

    protected IllegalUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
