package org.example.quickkick.model;

import lombok.Data;
import org.example.quickkick.model.enums.MatchStatus;

import java.time.LocalDate;

@Data
public class Match {

    private Long id;
    private LocalDate matchDate;
    private Team team1;
    private Team team2;
    private MatchStatus status;
    private int goalsTeam1;
    private int goalsTeam2;
    private int faulsTeam1;
    private int faulsTeam2;


}
