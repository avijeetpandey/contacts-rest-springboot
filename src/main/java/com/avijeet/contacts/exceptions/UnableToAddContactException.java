package com.avijeet.contacts.exceptions;

public class UnableToAddContactException extends RuntimeException {
    public UnableToAddContactException(String message) {
        super(message);
    }
}
