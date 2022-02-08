package com.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "streams")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stream_id")
    private Long id;

    @Column(name = "stream_name")
    private String streamName;

    @OneToMany(mappedBy = "stream1", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Candidate> candidates;


    @OneToMany(mappedBy = "stream")
    @JsonIgnore
    private List<ProjectStream> projectStreams = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_stream",
            joinColumns = @JoinColumn(name = "ustream_id"),
            inverseJoinColumns = @JoinColumn(name = "uuser_id")
    )
    @JsonIgnore
    private List<User> streamUsers;

    public Stream() {

    }

    public List<User> getStreamUsers() {
        return streamUsers;
    }

    public void setStreamUsers(List<User> streamUsers) {
        this.streamUsers = streamUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public List<ProjectStream> getProjectStreams() {
        return projectStreams;
    }

    public void setProjectStreams(List<ProjectStream> projectStreams) {
        this.projectStreams = projectStreams;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "id=" + id +
                ", streamName='" + streamName + '\'' +
                '}';
    }
}
