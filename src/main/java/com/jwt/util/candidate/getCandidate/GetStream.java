package com.jwt.util.candidate.getCandidate;

public class GetStream {
    private Long StreamId;
    private String streamName;

    public GetStream() {
    }

    public GetStream(Long streamId, String streamName) {
        StreamId = streamId;
        this.streamName = streamName;
    }

    @Override
    public String toString() {
        return "GetStream{" +
                "StreamId=" + StreamId +
                ", streamName='" + streamName + '\'' +
                '}';
    }

    public Long getStreamId() {
        return StreamId;
    }

    public void setStreamId(Long streamId) {
        StreamId = streamId;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }
}
