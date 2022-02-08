package com.jwt.util.stream;

public class Streamc {
    private Long streamId;
    private Long candidate_required;

    public Streamc() {

    }

    public Long getStreamId() {
        return streamId;
    }

    public void setStreamId(Long streamId) {
        this.streamId = streamId;
    }

    public Long getCandidate_required() {
        return candidate_required;
    }

    public void setCandidate_required(Long candidate_required) {
        this.candidate_required = candidate_required;
    }

    @Override
    public String toString() {
        return "Streamc{" +
                "streamId=" + streamId +
                ", candidate_required=" + candidate_required +
                '}';
    }
}