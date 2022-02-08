package com.jwt.services;

import com.jwt.model.*;
import com.jwt.util.candidate.updateCandidate.GetUpdateCandidate;
import com.jwt.repositories.CandidatesRepository;
import com.jwt.util.candidate.addCandidate.AddCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidatesRepository candidatesRepository;

    @Autowired
    private StreamService streamService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CandidateUserService candidateUserService;

    @Autowired
    private UserService userService;

    public List<Candidate> getAllCandidates() {
        return candidatesRepository.findAll();
    }

    public Candidate getCandidate(Long id) {
        return candidatesRepository.getById(id);
    }



    public User getUserToAllocate(List<User> users) {
        Long minCount = 10000L;
        User userToAllocate = users.get(0);
        for (User user : users) {
            Long noOfpendingCandidates = getNoOfpendingCandidates(user);
            if(noOfpendingCandidates<minCount) {
                userToAllocate = user;
                minCount = noOfpendingCandidates;
            }
        }
        return userToAllocate;
    }

    private Long getNoOfpendingCandidates(User user) {
        Long count = 0L;
        List<CandidateUser> candidateUsers = user.getCandidateUsers();
        for (CandidateUser candidateUser: candidateUsers) {
            if(candidateUser.getStatus().equals("pending")) {
                count++;
            }
        }
        return count;
    }

    public Candidate addCandidateToRepository(AddCandidate addCandidate) {
        Stream stream = streamService.findStreamById(addCandidate.getStreamId());
        Project project = projectService.getProject(addCandidate.getProjectId());

        if(project == null || stream == null) {
            return null;
        }
        List<Stream> streams = projectService.getProjectStream(addCandidate.getProjectId());
        if(streams.contains(stream)) {
            Candidate candidate = new Candidate(addCandidate.getCandidateName(), addCandidate.getCandidateExperience(),
                    project, stream, addCandidate.getCandidateScore(), addCandidate.getCandidateStatus());
            Candidate savedCandidate = candidatesRepository.saveAndFlush(candidate);

            return savedCandidate;
        }
        return null;
    }

    public void allocateAllPending() {
        List<Candidate> allCandidates = candidatesRepository.findAll();

        for (Candidate candidate: allCandidates) {
            if(candidate.getCandidateStatus().equals("pending")) {
              Candidate allocatedCandidate = allocateCandidate(candidate);
            }
        }
    }

    public Candidate allocateTech(Candidate candidate) {

        Stream candidateStream = candidate.getStream1();

        List<User> usersOfStream = candidateStream.getStreamUsers();

        if(usersOfStream !=null && usersOfStream.size()!=0) {
            candidate.setCandidateStatus("allocated");

            candidatesRepository.saveAndFlush(candidate);

            User userToAllocate = getUserToAllocate(usersOfStream);
            List<CandidateUser> candidateUsers = new ArrayList<>();

            candidateUsers.add(new CandidateUser(candidate, userToAllocate, "pending", null ));
//                System.out.println(candidateUsers.get(0));
            candidateUserService.addCandidateUsers(candidateUsers);

        } else {
            candidate.setCandidateStatus("pending");
            candidatesRepository.saveAndFlush(candidate);
        }
        return candidatesRepository.getById(candidate.getId());

    }

    public Candidate allocateManager(Candidate candidate) {

        Stream managerStream = streamService.findStreamById(4L);

        List<User> managers = managerStream.getStreamUsers();

        if(managers == null || managers.size() == 0) {
            candidate.setCandidateStatus("pending");
            candidatesRepository.saveAndFlush(candidate);
        } else {
            candidate.setCandidateStatus("allocated");
            candidatesRepository.saveAndFlush(candidate);

            User userToAllocate = getUserToAllocate(managers);
            List<CandidateUser> candidateUsers = candidate.getCandidateUsers();
            candidateUsers.add(new CandidateUser(candidate, userToAllocate, "pending", null));
            candidateUserService.addCandidateUsers(candidateUsers);

        }

        return candidatesRepository.getById(candidate.getId());
    }


    public Candidate allocateCandidate(Candidate candidate) {

        List<CandidateUser> usersAllocatedToCandidate = candidate.getCandidateUsers();
        if(usersAllocatedToCandidate == null || usersAllocatedToCandidate.size() == 0 ) {
            candidate = allocateTech(candidate);
        } else if(usersAllocatedToCandidate.size() == 1) {
            candidate = allocateManager(candidate);
        }
        return candidate;
    }


    public Candidate saveCandidate(AddCandidate addCandidate) {

        Candidate savedCadidate = addCandidateToRepository(addCandidate);

        return allocateCandidate(savedCadidate);
    }


    public Candidate updateCandidate(GetUpdateCandidate updateCandidate) {


        Candidate candidate = candidatesRepository.getById(updateCandidate.getCandidateId());

        List<CandidateUser> usersAllocatedToCandidate = candidate.getCandidateUsers();

        if(usersAllocatedToCandidate != null && usersAllocatedToCandidate.size() !=0) {
            if(usersAllocatedToCandidate.size() == 1) {

                if(updateCandidate.getStatus().equals("selected")) {

                    usersAllocatedToCandidate.get(0).setStatus("selected");
                    usersAllocatedToCandidate.get(0).setScore(updateCandidate.getScore());
                    candidate.setCandidateUsers(usersAllocatedToCandidate);
                    candidate = allocateManager(candidate);

                } else {
                    usersAllocatedToCandidate.get(0).setStatus("rejected");
                    usersAllocatedToCandidate.get(0).setScore(updateCandidate.getScore());
                    candidate.setCandidateUsers(usersAllocatedToCandidate);
                    candidate.setCandidateStatus("rejected");
                }

            } else {

                int indexOfManger = getIndexOfManager(usersAllocatedToCandidate);

                usersAllocatedToCandidate.get(indexOfManger).setScore(updateCandidate.getScore());
                usersAllocatedToCandidate.get(indexOfManger).setStatus(updateCandidate.getStatus());
                candidate.setCandidateScore((usersAllocatedToCandidate.get(0).getScore() + usersAllocatedToCandidate.get(1).getScore())/2);
                candidate.setCandidateUsers(usersAllocatedToCandidate);
                candidate.setCandidateStatus(updateCandidate.getStatus());

            }
        }

        return candidatesRepository.saveAndFlush(candidate);
    }

    private int getIndexOfManager(List<CandidateUser> usersAllocatedToCandidate) {

        for (int i = 0; i<usersAllocatedToCandidate.size(); i++) {
            CandidateUser candidateUser = usersAllocatedToCandidate.get(i);
            User user = candidateUser.getUsersAssigned();
            if(userIsManager(user)) {
                return i;
            }
        }
        return -1;
    }

    private boolean userIsManager(User user) {
        List<Stream> streams = user.getUserStreams();
        for (Stream stream: streams) {
            if(stream.getStreamName().equals("management")) {
                return true;
            }
        }
        return false;
    }
}
