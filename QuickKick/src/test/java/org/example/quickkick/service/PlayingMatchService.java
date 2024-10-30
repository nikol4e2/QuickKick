package org.example.quickkick.service;

import org.example.quickkick.model.Match;
import org.example.quickkick.model.PlayingMatch;

import java.util.List;

public interface PlayingMatchService {

    PlayingMatch findById(int id);
    PlayingMatch save(PlayingMatch match);
    PlayingMatch update(PlayingMatch match);
    void delete(PlayingMatch match);
    void startMatch(Long playingMatchId);
    void finishMatch(Long playingMatchId);


    //Timer commands
    void startTimer(Long playingMatchId);
    void stopTimer(Long playingMatchId);
    void resetTimerToZero(Long playingMatchId);
    void startHalfTimeTimer(Long playingMatchId);
    void addTimeToTimer(Long playingMatchId,int seconds);
    void subtractTimeFromTimer(Long playingMatchId,int seconds);
    void startTimeoutTimer(Long playingMatchId);
}
