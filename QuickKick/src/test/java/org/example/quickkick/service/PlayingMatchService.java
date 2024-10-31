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


    /* TODO Implement this functions for adding goals and fauls for teams
    void addGoalForTeam1(Long id)
    void addGoalForTeam2(Long id)
    void subtractGoalForTeam1(Long id)
    void subtractGoalForTeam2(Long id)
    void addFaulForTeam1(Long id)
    void addFaulForTeam2(Long id)
    void subtractFaulForTeam1(Long id)
    void subtractFaulForTeam2(Long id)
    void resetFaulsForTeam1(Long id)
    void resetFaulsForTeam2(Long id)



     */
}
