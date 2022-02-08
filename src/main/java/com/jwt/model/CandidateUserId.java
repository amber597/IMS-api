package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateUserId implements Serializable {

    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name = "user_id")
    private Long userId;

    public CandidateUserId() {
    }

    public CandidateUserId(Long candidateId, Long userId) {
        this.candidateId = candidateId;
        this.userId = userId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
