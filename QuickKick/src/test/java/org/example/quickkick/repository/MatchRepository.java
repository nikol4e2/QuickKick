package org.example.quickkick.repository;

import org.example.quickkick.model.Match;
import org.example.quickkick.model.Team;
import org.example.quickkick.model.enums.MatchStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {

    Optional<Match> findByTeam1AndTeam2(Team team1, Team team2);
    Optional<Match> findAllByMatchDate(Date matchDate);
    Optional<Match> findAllByStatus(MatchStatus status);

}
