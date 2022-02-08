package com.jwt.util.project;

import com.jwt.model.Project;
import com.jwt.util.stream.Streamc;

import java.util.List;


public class AddProject {
    private Project project;
    private List<Streamc> streamc;

    public AddProject() {

    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Streamc> getStreamc() {
        return streamc;
    }

    public void setStreamc(List<Streamc> streamc) {
        this.streamc = streamc;
    }

    @Override
    public String toString() {
        return "AddProject{" +
                "project=" + project +
                ", streamc=" + streamc +
                '}';
    }
}
