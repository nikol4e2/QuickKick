package org.example.quickkick.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PlayingMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    private int minutesForPlayLeft;
    private int timer;
    private int duration; //duration for one half
    private int pauseTime;
    private int halfTimeCounter; //is it the first half or second
    private int timeoutTime;


    public PlayingMatch(Match match, int duration, int pauseTime, int timeoutTime) {
        this.match = match;
        this.duration = duration;
        this.pauseTime = pauseTime;
        this.halfTimeCounter = 1;
        this.timeoutTime = timeoutTime;
        this.timer=duration;
        this.minutesForPlayLeft=duration;
    }

}
