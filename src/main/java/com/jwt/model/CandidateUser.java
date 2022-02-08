package com.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "candidate_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CandidateUser {

    @EmbeddedId
    private CandidateUserId id;

    @ManyToOne
    @MapsId("candidateId")
    @JoinColumn(name = "ccandidate_id")
    @JsonIgnore
    private Candidate candidatesAssigned;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "cuser_id")
    @JsonIgnore
    private User usersAssigned;

    @Column(name = "status")
    private String status;

    @Column(name = "score")
    private Long score;

    public CandidateUser() {
    }

    public CandidateUser(Candidate candidatesAssigned, User usersAssigned, String status, Long score) {
        this.id = new CandidateUserId(candidatesAssigned.getId(), usersAssigned.getId());
        this.candidatesAssigned = candidatesAssigned;
        this.usersAssigned = usersAssigned;
        this.status = status;
        this.score = score;
    }

    public CandidateUserId getId() {
        return id;
    }

    public void setId(CandidateUserId id) {
        this.id = id;
    }

    public Candidate getCandidatesAssigned() {
        return candidatesAssigned;
    }

    public void setCandidatesAssigned(Candidate candidatesAssigned) {
        this.candidatesAssigned = candidatesAssigned;
    }

    public User getUsersAssigned() {
        return usersAssigned;
    }

    public void setUsersAssigned(User usersAssigned) {
        this.usersAssigned = usersAssigned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CandidateUser{" +
                "id=" + id +
                ", candidatesAssigned=" + candidatesAssigned +
                ", usersAssigned=" + usersAssigned +
                ", status='" + status + '\'' +
                ", score=" + score +
                '}';
    }
}
