package com.jwt.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.id.Assigned;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long id;

    @Column(name = "candidate_name")
    private String candidateName;

    @Column(name = "candidate_experience")
    private Long candidateExperience;

    @ManyToOne
    @JoinColumn(name="cproject_id")
    private Project project1;


    @ManyToOne
    @JoinColumn(name = "cstream_id")
    private Stream stream1;

    @Column(name = "candidate_score")
    private Long candidateScore;

    @Column(name = "candidate_status")
    private String candidateStatus;

    @OneToMany(mappedBy = "candidatesAssigned")
    @JsonIgnore
    private List<CandidateUser> candidateUsers = new ArrayList<>();



    public Candidate() {
    }

    public Candidate(String candidateName, Long candidateExperience, Project project1, Stream stream1, Long candidateScore, String candidateStatus) {
        this.candidateName = candidateName;
        this.candidateExperience = candidateExperience;
        this.project1 = project1;
        this.stream1 = stream1;
        this.candidateScore = candidateScore;
        this.candidateStatus = candidateStatus;
    }

    public Long getCandidateScore() {
        return candidateScore;
    }

    public void setCandidateScore(Long candidateScore) {
        this.candidateScore = candidateScore;
    }

    public String getCandidateStatus() {
        return candidateStatus;
    }

    public void setCandidateStatus(String candidateStatus) {
        this.candidateStatus = candidateStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Long getCandidateExperience() {
        return candidateExperience;
    }

    public void setCandidateExperience(Long candidateExperience) {
        this.candidateExperience = candidateExperience;
    }

    public Project getProject1() {
        return project1;
    }

    public void setProject1(Project project1) {
        this.project1 = project1;
    }

    public Stream getStream1() {
        return stream1;
    }

    public void setStream1(Stream stream1) {
        this.stream1 = stream1;
    }

    public List<CandidateUser> getCandidateUsers() {
        return candidateUsers;
    }

    public void setCandidateUsers(List<CandidateUser> candidateUsers) {
        this.candidateUsers = candidateUsers;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", candidateName='" + candidateName + '\'' +
                ", candidateExperience=" + candidateExperience +
                ", project1=" + project1 +
                ", stream1=" + stream1 +
                ", candidateScore=" + candidateScore +
                ", candidateStatus='" + candidateStatus + '\'' +
                ", candidateUsers=" + candidateUsers +
                '}';
    }
}
