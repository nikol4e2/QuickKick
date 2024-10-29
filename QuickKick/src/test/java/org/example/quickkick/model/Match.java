package org.example.quickkick.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.quickkick.model.enums.MatchStatus;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate matchDate;
    @ManyToOne
    @JoinColumn(name = "team1_id")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team2_id")
    private Team team2;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;
    private int goalsTeam1;
    private int goalsTeam2;
    private int faulsTeam1;
    private int faulsTeam2;

    public Match(Team team1, Team team2, LocalDate matchDate) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchDate = matchDate;
        this.status=MatchStatus.SCHEDULED;
        this.goalsTeam1=0;
        this.goalsTeam2=0;
        this.faulsTeam1=0;
        this.faulsTeam2=0;
    }
}
