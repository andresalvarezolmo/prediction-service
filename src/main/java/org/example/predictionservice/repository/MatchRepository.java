package org.example.predictionservice.repository;

import org.example.predictionservice.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {}
