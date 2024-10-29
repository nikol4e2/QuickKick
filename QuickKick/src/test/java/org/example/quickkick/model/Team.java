package org.example.quickkick.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Team {

    @Id
    private String name;

    @ElementCollection
    private HashMap<String,Integer> playersWithGoals;

    @OneToMany(mappedBy = "team")
    private List<Match> playedMatches;
    private int GivenGoals;
    private int TakenGoals;
    private int wins;
    private int losses;
    private int draws;
    private int points;


    public Team(String name) {
        this.name = name;
        this.playersWithGoals = new HashMap<>();
        this.playedMatches = new ArrayList<>();
        this.GivenGoals = 0;
        this.TakenGoals = 0;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.points = 0;
    }
}
