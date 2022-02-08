package com.jwt.util.candidate.updateCandidate;

public class GetUpdateCandidate {
    private Long candidateId;
    private Long userId;
    private Long score;
    private String status;

    public GetUpdateCandidate() {
    }

    public GetUpdateCandidate(Long candidateId, Long userId, Long score, String status) {
        this.candidateId = candidateId;
        this.userId = userId;
        this.score = score;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
