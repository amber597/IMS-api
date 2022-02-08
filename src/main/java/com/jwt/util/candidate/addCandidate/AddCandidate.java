package com.jwt.util.candidate.addCandidate;

public class AddCandidate {
    private String candidateName;
    private Long candidateExperience;
    private Long projectId;
    private Long streamId;
    private Long candidateScore;
    private String candidateStatus;

    public AddCandidate() {

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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getStreamId() {
        return streamId;
    }

    public void setStreamId(Long streamId) {
        this.streamId = streamId;
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
}
