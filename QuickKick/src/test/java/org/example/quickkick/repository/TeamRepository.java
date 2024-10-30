package org.example.quickkick.repository;


import org.example.quickkick.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,String> {

    Optional<Team> findByName(String name);

}
