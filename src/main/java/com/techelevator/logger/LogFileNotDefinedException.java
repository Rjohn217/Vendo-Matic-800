package com.techelevator.logger;

public class LogFileNotDefinedException extends Exception {
    public LogFileNotDefinedException() {
    }

    public LogFileNotDefinedException(String message) {
        super(message);
    }

    public LogFileNotDefinedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogFileNotDefinedException(Throwable cause) {
        super(cause);
    }

    public LogFileNotDefinedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
