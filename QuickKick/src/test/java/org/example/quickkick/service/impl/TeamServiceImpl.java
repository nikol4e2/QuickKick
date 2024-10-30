package org.example.quickkick.service.impl;

import org.example.quickkick.model.Match;
import org.example.quickkick.model.Team;
import org.example.quickkick.model.exceptions.TeamNotFoundException;
import org.example.quickkick.repository.TeamRepository;
import org.example.quickkick.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> findAll() {
        return this.teamRepository.findAll();
    }



    @Override
    public Optional<Team> findByName(String name) {
        return this.teamRepository.findByName(name);
    }

    @Override
    public void addPlayerToTeam(String playerName, String teamName) {
        Team team=this.teamRepository.findByName(teamName).orElseThrow(TeamNotFoundException::new);
        HashMap<String,Integer> copy=team.getPlayersWithGoals();
        copy.put(playerName,0);
        team.setPlayersWithGoals(copy);
        this.teamRepository.save(team);
    }

    @Override
    public Team save(String name) {
        Team team = new Team(name);
        return this.teamRepository.save(team);
    }

    @Override
    public void deleteByName(String name) {
        Team team=this.teamRepository.findByName(name).orElse(null);
        if(team!=null) {
            this.teamRepository.delete(team);
        }
    }

    @Override
    public Team addMatchToTeam(String teamName, Match match) {
        Team team=this.teamRepository.findByName(teamName).orElseThrow(TeamNotFoundException::new);
        List<Match> playedMatches=team.getPlayedMatches();
        playedMatches.add(match);
        team.setPlayedMatches(playedMatches);
        int goalsForThisTeam=match.getGoalsTeam2();
        int awayTeamGoals=match.getGoalsTeam1();
        if(match.getTeam1().equals(teamName))
        {
            goalsForThisTeam=match.getGoalsTeam1();
            awayTeamGoals=match.getGoalsTeam2();
        }
        if(goalsForThisTeam>awayTeamGoals)
        {
            team.setWins(team.getWins()+1);
        }else if(goalsForThisTeam<awayTeamGoals)
        {
            team.setLosses(team.getLosses()+1);
        }else
        {
            team.setDraws(team.getDraws()+1);
        }

        team.calculatePoints();




        return this.teamRepository.save(team);
    }

    @Override
    public void addGoalToPlayer(String teamName, String playerName, int goal) {
        Team team=this.teamRepository.findByName(teamName).orElseThrow(TeamNotFoundException::new);
        HashMap<String,Integer> copy=team.getPlayersWithGoals();
        copy.put(playerName,copy.get(playerName)+goal);
        team.setPlayersWithGoals(copy);
        this.teamRepository.save(team);
    }
}
