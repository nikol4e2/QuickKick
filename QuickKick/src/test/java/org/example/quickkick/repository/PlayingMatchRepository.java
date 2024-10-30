package org.example.quickkick.repository;

import org.example.quickkick.model.PlayingMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayingMatchRepository extends JpaRepository<PlayingMatch, Long> {

    Optional<PlayingMatch> findByMatchId(Long matchId);
}
