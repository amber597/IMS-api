package com.jwt.controller;


import com.jwt.util.candidate.addCandidate.AddCandidate;
import com.jwt.model.Candidate;
import com.jwt.util.candidate.getCandidate.GetCandidate;
import com.jwt.util.candidate.updateCandidate.GetUpdateCandidate;
import com.jwt.services.CandidateService;
import com.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/candidates")
@CrossOrigin(origins = "*")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<GetCandidate> list() {

        List<Candidate> candidates = candidateService.getAllCandidates();

        List<GetCandidate> getCandidates = new ArrayList<>();

        for (Candidate candidate: candidates) {
            getCandidates.add(userService.getCandidate(candidate.getId()));
        }

        return getCandidates;
    }

    @GetMapping
    @RequestMapping("{id}")
    public GetCandidate get(@PathVariable Long id) {
        return userService.getCandidate(id);
    }

    @PostMapping
    public Candidate create(@RequestBody AddCandidate addCandidate) {
        return candidateService.saveCandidate(addCandidate);

    }

    @RequestMapping(value = "/updatecandidate")
    public Candidate updateCandidate(@RequestBody GetUpdateCandidate updateCandidate) {
        return candidateService.updateCandidate(updateCandidate);
    }

    @GetMapping(value = "/allocateallpending")
    public void allocateAllpendingCandidates() {
        candidateService.allocateAllPending();
    }

}
