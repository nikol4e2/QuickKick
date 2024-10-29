package org.example.quickkick.model;

import lombok.Data;

@Data
public class PlayingMatch {

    private Long id;

    private int Match;

    private int minutesForPlayLeft;
    private int timer;
    private int duration; //duration for one half
    private int pauseTime;
    private int halfTimeCounter; //is it the first half or second
    private int timeoutTime;

}
