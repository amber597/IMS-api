package com.jwt.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "project_stream")
public class ProjectStream {

    @EmbeddedId
    private ProjectStreamId id;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "tproject_id")
    @JsonIgnore
    private Project project;

    @ManyToOne
    @MapsId("streamId")
    @JoinColumn(name = "tstream_id")
    private Stream stream;

    @Column(name = "candidateRequired")
    private Long candidateRequired;

    public ProjectStream() {

    }

    public ProjectStream(Project project, Stream stream, Long candidateRequired) {

        this.id = new ProjectStreamId(project.getId(), stream.getId());
        this.project = project;
        this.stream = stream;
        this.candidateRequired = candidateRequired;
    }

    public ProjectStreamId getId() {
        return id;
    }

    public void setId(ProjectStreamId id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public Long getCandidateRequired() {
        return candidateRequired;
    }

    public void setCandidateRequired(Long candidateRequired) {
        this.candidateRequired = candidateRequired;
    }

    @Override
    public String toString() {
        return "ProjectStream{" +
                "stream=" + stream +
                ", candidateRequired=" + candidateRequired +
                '}';
    }
}
