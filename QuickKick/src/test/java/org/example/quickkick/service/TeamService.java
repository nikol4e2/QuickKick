package org.example.quickkick.service;

import org.example.quickkick.model.Match;
import org.example.quickkick.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    List<Team> findAll();

    Optional<Team> findByName(String name);
    void addPlayerToTeam(String playerName,String teamName);
    Team save(String name);
    void deleteByName(String name);
    //TODO IMPLEMENT EDIT
    //Team edit()
    Team addMatchToTeam(String teamName, Match match);
    void addGoalToPlayer(String teamName,String playerName,int goal);


}
