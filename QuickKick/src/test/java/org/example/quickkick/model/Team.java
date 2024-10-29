package org.example.quickkick.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class Team {

    private String name;
    private HashMap<String,Integer> playersWithGoals;
    //TODO - Uncomment after making Match entity
    //private List<Match > matches
    private int GivenGoals;
    private int TakenGoals;
    private int wins;
    private int losses;
    private int draws;
    private int points;
}
