package com.jwt.repositories;

import com.jwt.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesRepository extends JpaRepository<Candidate, Long> {
}
