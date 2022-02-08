package com.jwt.util.project;

public class ProjectStreamDetails {

    private Long javaSelected;
    private Long devopsSelected;
    private Long automationSelected;
    private Long totalSelected;
    private Long totalJava;
    private Long totalDevops;
    private Long totalAutomation;
    private Long totalCandidates;

    public ProjectStreamDetails() {
    }

    public ProjectStreamDetails(Long javaSelected, Long devopsSelected, Long automationSelected, Long totalSelected, Long totalJava, Long totalDevops, Long totalAutomation, Long totalCandidates) {
        this.javaSelected = javaSelected;
        this.devopsSelected = devopsSelected;
        this.automationSelected = automationSelected;
        this.totalSelected = totalSelected;
        this.totalJava = totalJava;
        this.totalDevops = totalDevops;
        this.totalAutomation = totalAutomation;
        this.totalCandidates = totalCandidates;
    }

    public Long getJavaSelected() {
        return javaSelected;
    }

    public void setJavaSelected(Long javaSelected) {
        this.javaSelected = javaSelected;
    }

    public Long getDevopsSelected() {
        return devopsSelected;
    }

    public void setDevopsSelected(Long devopsSelected) {
        this.devopsSelected = devopsSelected;
    }

    public Long getAutomationSelected() {
        return automationSelected;
    }

    public void setAutomationSelected(Long automationSelected) {
        this.automationSelected = automationSelected;
    }

    public Long getTotalSelected() {
        return totalSelected;
    }

    public void setTotalSelected(Long totalSelected) {
        this.totalSelected = totalSelected;
    }

    public Long getTotalJava() {
        return totalJava;
    }

    public void setTotalJava(Long totalJava) {
        this.totalJava = totalJava;
    }

    public Long getTotalDevops() {
        return totalDevops;
    }

    public void setTotalDevops(Long totalDevops) {
        this.totalDevops = totalDevops;
    }

    public Long getTotalAutomation() {
        return totalAutomation;
    }

    public void setTotalAutomation(Long totalAutomation) {
        this.totalAutomation = totalAutomation;
    }

    public Long getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(Long totalCandidates) {
        this.totalCandidates = totalCandidates;
    }
}
