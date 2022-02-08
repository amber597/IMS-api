package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjectStreamId implements Serializable {

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "stream_id")
    private Long streamId;

    public ProjectStreamId() {

    }
    public ProjectStreamId(Long projectId, Long streamId) {
        this.projectId = projectId;
        this.streamId =streamId;
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


}
