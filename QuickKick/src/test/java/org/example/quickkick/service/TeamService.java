package org.example.quickkick.service;

import org.example.quickkick.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    List<Team> findAll();
    Optional<Team> findById(long id);
    Optional<Team> findByName(String name);
    void addPlayerToTeam(String playerName,String teamName);
    Team save(String name);
    void deleteById(long id);

}