package org.example.quickkick.service;

import org.example.quickkick.model.Match;
import org.example.quickkick.model.enums.MatchStatus;

import java.util.Date;
import java.util.List;

public interface MatchService {

    List<Match> findAllMatches();
    Match findMatchById(Long id);
    List<Match> findAllMatchesByDate(Date date);
    void finishMatch(Long id);
    List<Match> findAllMatchesByStatus(MatchStatus status);
}
