package com.jwt.util.candidate.getCandidate;

import java.util.ArrayList;
import java.util.List;


public class GetCandidate {

    private Long candidateId;
    private String candidateName;
    private Long candidateExperience;
    private GetProject project = new GetProject();
    private GetStream stream = new GetStream();
    private Long candidateScore;
    private String candidateStatus;

    private List<GetUser> getUsers = new ArrayList<>();

    public GetCandidate() {
    }

    public GetCandidate(Long candidateId, String candidateName, Long candidateExperience, GetProject project, GetStream stream, Long candidateScore, String candidateStatus, List<GetUser> getUsers) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.candidateExperience = candidateExperience;
        this.project = project;
        this.stream = stream;
        this.candidateScore = candidateScore;
        this.candidateStatus = candidateStatus;
        this.getUsers = getUsers;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
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

    public GetProject getProject() {
        return project;
    }

    public void setProject(GetProject project) {
        this.project = project;
    }

    public GetStream getStream() {
        return stream;
    }

    public void setStream(GetStream stream) {
        this.stream = stream;
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

    public List<GetUser> getGetUsers() {
        return getUsers;
    }

    public void setGetUsers(List<GetUser> getUsers) {
        this.getUsers = getUsers;
    }
}
