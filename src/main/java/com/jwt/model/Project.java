package com.jwt.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "projects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_date")
    private String projectDate;

    @OneToMany(mappedBy = "project1")
    @JsonIgnore
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "project")
    private List<ProjectStream> projectStreams = new ArrayList<>();



    public Project() {

    }

    public Project(String projectName, String projectDate, List<Candidate> candidates) {
        this.projectName = projectName;
        this.projectDate = projectDate;
        this.candidates = candidates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate;
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
}
