package org.example.quickkick.model.exceptions;

public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException() {
        super("Team not found");
    }
}
