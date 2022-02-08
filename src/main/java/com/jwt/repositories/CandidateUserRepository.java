package com.jwt.repositories;

import com.jwt.model.CandidateUser;
import com.jwt.model.CandidateUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateUserRepository extends JpaRepository<CandidateUser, CandidateUserId> {
}
