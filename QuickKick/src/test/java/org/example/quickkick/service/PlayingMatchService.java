package org.example.quickkick.service;

import org.example.quickkick.model.Match;
import org.example.quickkick.model.PlayingMatch;

import java.util.List;

public interface PlayingMatchService {

    PlayingMatch findById(Long id);
    PlayingMatch save(Match match, int duration, int pauseTime, int timeoutTime);
    PlayingMatch update(PlayingMatch match);
    void delete(Long id);
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
    int getRemainingTime(Long playingMatchId);







    void addGoalForTeam(Long playingMatchId,int teamNumber);
    void subtractGoalForTeam(Long playingMatchId,int teamNumber);
    void addFaulForTeam(Long playingMatchId,int teamNumber;
    void subtractFaulForTeam(Long playingMatchId,int teamNumber);
    void resetFaulsForTeam(Long playingMatchId,int teamNumber);




}
