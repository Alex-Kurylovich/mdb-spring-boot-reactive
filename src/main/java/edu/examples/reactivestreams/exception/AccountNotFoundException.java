package edu.examples.reactivestreams.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("Account Not Found");
    }
}
