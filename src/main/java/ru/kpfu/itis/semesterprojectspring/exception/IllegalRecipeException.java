package ru.kpfu.itis.semesterprojectspring.exception;

public class IllegalRecipeException extends RuntimeException{
    public IllegalRecipeException() {
        super();
    }

    public IllegalRecipeException(String message) {
        super(message);
    }

    public IllegalRecipeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalRecipeException(Throwable cause) {
        super(cause);
    }

    protected IllegalRecipeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
