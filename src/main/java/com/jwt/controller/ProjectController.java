package com.jwt.controller;

import com.jwt.util.project.AddProject;
import com.jwt.model.Candidate;
import com.jwt.model.Project;
import com.jwt.model.Stream;
import com.jwt.util.candidate.getCandidate.GetCandidate;
import com.jwt.services.ProjectService;
import com.jwt.services.UserService;
import com.jwt.util.project.ProjectStreamDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Project saveProject(@RequestBody AddProject addProject) {
//        System.out.println(addProject);
        return projectService.saveProject(addProject);
    }
    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping(value = "{id}")
    public Project getProject(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    @GetMapping(value = "{id}/streams")
    public List<Stream> getProjectStreams(@PathVariable Long id) {

        return projectService.getProjectStream(id);
    }

    @GetMapping(value = "{id}/candidates")
    public List<GetCandidate> getCandidates(@PathVariable Long id) {

        List<Candidate> candidates = projectService.getCandidates(id);

        List<GetCandidate> getCandidates = new ArrayList<>();

        for (Candidate candidate: candidates) {
            getCandidates.add(userService.getCandidate(candidate.getId()));
        }

        return getCandidates;
    }

    @GetMapping(value = "streamDetails/{id}")
    public ProjectStreamDetails getProjectStreamDetails(@PathVariable Long id) {
        return projectService.getProjectStreamDetails(id);
    }


}
