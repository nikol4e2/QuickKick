package org.example.quickkick.service.impl;

import org.example.quickkick.model.Match;
import org.example.quickkick.model.enums.MatchStatus;
import org.example.quickkick.model.exceptions.MatchNotFoundException;
import org.example.quickkick.repository.MatchRepository;
import org.example.quickkick.repository.TeamRepository;
import org.example.quickkick.service.MatchService;
import org.example.quickkick.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final TeamService teamService;

    public MatchServiceImpl(MatchRepository matchRepository, TeamService teamService) {
        this.matchRepository = matchRepository;
        this.teamService = teamService;
    }


    @Override
    public List<Match> findAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match findMatchById(Long id) {
        return this.matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
    }



    @Override
    public List<Match> findAllMatchesByDate(Date date) {
        return this.matchRepository.findAllByMatchDate(date);
    }



    @Override
    public void finishMatch(Long id) {
        Match match=this.matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
        match.setStatus(MatchStatus.FINISH);
        this.matchRepository.save(match);
        this.teamService.addMatchToTeam(match.getTeam1().getName(),match);
        this.teamService.addMatchToTeam(match.getTeam2().getName(),match);


    }

    @Override
    public List<Match> findAllMatchesByStatus(MatchStatus status) {
        return matchRepository.findAllByStatus(status);
    }

    @Override
    public Match save(Match match) {
        return this.matchRepository.save(match);
    }
}
