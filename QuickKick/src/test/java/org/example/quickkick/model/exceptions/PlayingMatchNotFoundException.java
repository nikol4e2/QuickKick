package org.example.quickkick.model.exceptions;

public class PlayingMatchNotFoundException extends RuntimeException{

    public PlayingMatchNotFoundException() {
        super("Playing match not found");
    }
}
