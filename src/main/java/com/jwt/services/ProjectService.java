package com.jwt.services;

import com.jwt.model.*;
import com.jwt.repositories.ProjectRepository;
import com.jwt.repositories.ProjectStreamRepository;
import com.jwt.util.project.AddProject;
import com.jwt.util.project.ProjectStreamDetails;
import com.jwt.util.stream.Streamc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    @Autowired
    private ProjectStreamRepository projectStreamRepository;

    @Autowired
    private StreamService streamService;

    public Project saveProject(AddProject addProject) {

        Project project = addProject.getProject();
        Project savedProject = projectRepository.saveAndFlush(project);

        List<ProjectStream> projectStreams = new ArrayList<>();

        for (Streamc streamc: addProject.getStreamc() ) {
            Stream stream = streamService.findStreamById(streamc.getStreamId());
            projectStreams.add(new ProjectStream(savedProject, stream, streamc.getCandidate_required()));
        }

        projectStreamRepository.saveAllAndFlush(projectStreams);

        return projectRepository.getById(savedProject.getId());

    }

    public Project getProject(Long id) {
        if(projectRepository.existsById(id)) {
            return projectRepository.getById(id);
        }
        return null;

    }

    public List<Stream> getProjectStream(Long id) {
        Project project = projectRepository.getById(id);
        if(project != null) {
            List<Stream> streams = new ArrayList<>();

            for (ProjectStream projectStream: project.getProjectStreams()) {
                streams.add(projectStream.getStream());
            }

            return streams;
        }
        return null;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public List<Candidate> getCandidates(Long id) {
        return projectRepository.getById(id).getCandidates();
    }

    public ProjectStreamDetails getProjectStreamDetails(Long id) {

        Project project = getProject(id);

        List<Candidate> candidatesInProject = getCandidates(id);

        Long javaCandidates = 0L, devopsCandidates = 0L, autoCandidates = 0L, totalSelectedCandidates = 0L;
        Long totalJavaCandidates = 0L, totalDevopsCandidates =0L, totalAutomationCandidates =0L, totalCandidates = 0L;

        for (Candidate candidate : candidatesInProject) {
            if(candidate.getStream1().getStreamName().equals("Java")) {
                if(candidate.getCandidateStatus().equals("selected")) {
                    javaCandidates++;
                }
            } else if(candidate.getStream1().getStreamName().equals("DevOps")) {
                if(candidate.getCandidateStatus().equals("selected")) {
                    devopsCandidates++;
                }

            } else if(candidate.getStream1().getStreamName().equals("Automation")) {
                if(candidate.getCandidateStatus().equals("selected")) {
                    autoCandidates++;
                }
            }
        }

        for (ProjectStream projectStream: project.getProjectStreams()) {
            Stream stream = projectStream.getStream();

            if(stream.getStreamName().equals("Java")) {
                totalJavaCandidates = projectStream.getCandidateRequired();
            } else if(stream.getStreamName().equals("DevOps")) {
                totalDevopsCandidates = projectStream.getCandidateRequired();
            } else if(stream.getStreamName().equals("Automation")) {
                totalAutomationCandidates = projectStream.getCandidateRequired();
            }
        }

        totalSelectedCandidates = javaCandidates + devopsCandidates + autoCandidates;
        totalCandidates = totalAutomationCandidates + totalDevopsCandidates + totalJavaCandidates;

        return new ProjectStreamDetails(javaCandidates, devopsCandidates, autoCandidates, totalSelectedCandidates,
                                        totalJavaCandidates,totalDevopsCandidates, totalAutomationCandidates, totalCandidates);
    }

}
