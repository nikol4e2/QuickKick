package org.example.quickkick.model.exceptions;

public class InvalidUserCredentialsEception extends RuntimeException{

    public InvalidUserCredentialsEception() {
        super("Invalid user credentials");
    }
}
