package org.example.quickkick.service;

import org.example.quickkick.model.Match;
import org.example.quickkick.model.enums.MatchStatus;

import java.util.Date;
import java.util.List;

public interface MatchService {

    List<Match> findAllMatches();
    Match findMatchById(int id);
    List<Match> findAllMatchesByTeam(int teamId);
    List<Match> findAllMatchesByDate(Date date);
    void finishMatch(int id);
    List<Match> findAllMatchesByStatus(MatchStatus status);
}
