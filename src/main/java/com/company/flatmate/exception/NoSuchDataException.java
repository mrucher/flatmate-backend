package com.company.flatmate.exception;

public class NoSuchDataException extends RuntimeException {

    public NoSuchDataException() {
        super("No results.");
    }
}
