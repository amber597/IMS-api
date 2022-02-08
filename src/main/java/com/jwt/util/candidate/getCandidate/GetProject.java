package com.jwt.util.candidate.getCandidate;

public class GetProject {
    private Long projectId;
    private String projectName;

    public GetProject() {
    }

    public GetProject(Long projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "GetProject{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                '}';
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}