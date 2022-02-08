package com.jwt.services;

import com.jwt.model.Candidate;
import com.jwt.model.CandidateUser;
import com.jwt.model.User;
import com.jwt.repositories.CandidateUserRepository;
import com.jwt.repositories.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateUserService {

    @Autowired
    private CandidateUserRepository candidateUserRepository;

    public void addCandidateUsers(List<CandidateUser> candidateUsers) {
        candidateUserRepository.saveAllAndFlush(candidateUsers);
    }
}
