package com.javarush.task.task18.task1814;

public class UnsupportedFileNameException extends Exception {
    public UnsupportedFileNameException(String message) {
        super(message);
        System.out.println(getMessage());
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
