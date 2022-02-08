package com.jwt.services;

import com.jwt.model.*;
import com.jwt.util.candidate.getCandidate.GetCandidate;
import com.jwt.util.candidate.getCandidate.GetProject;
import com.jwt.util.candidate.getCandidate.GetStream;
import com.jwt.util.candidate.getCandidate.GetUser;
import com.jwt.util.user.getUser.GetPanelUser;
import com.jwt.repositories.UserRepository;
import com.jwt.util.user.addUser.Userpass;
import com.jwt.util.user.getUser.GetUserId;
import com.jwt.util.user.getUser.UserReturn;
import com.jwt.util.user.updateUser.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StreamService streamService;

    @Autowired
    private CandidateService candidateService;

    public User saveUser(Userpass userpass) {
        User user = new User();
        user.setUserName(userpass.getUsername());
        user.setPassword(userpass.getPassword());

        return userRepository.saveAndFlush(user);
    }

    public User updateUser(UpdateUser updateUser) {
        User user = userRepository.getById(updateUser.getUserId());


        user.setUserLevel(updateUser.getLevel());

        List<Stream> streams = new ArrayList<>();

        for (Long streamId: updateUser.getStreamIds()) {
            Stream stream = streamService.findStreamById(streamId);
            streams.add(stream);
        }

        user.setUserStreams(streams);

        return userRepository.saveAndFlush(user);
    }

    public List<UserReturn> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserReturn> userReturns = new ArrayList<>();
        for (User user: users) {
            userReturns.add(new UserReturn(user.getId(), user.getUserName(), user.getPassword(), user.getUserLevel()));
        }
        return userReturns;
    }

    public UserReturn getUser(Userpass userpass) {


        List<UserReturn> userReturns = getUsers();
        for (UserReturn userReturn: userReturns) {
            if(userReturn.getUserName().equals(userpass.getUsername()) && userReturn.getPassWord().equals(userpass.getPassword())) {
                return userReturn;
            }
        }
        return null;
    }
    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    public List<GetCandidate> getCandidates(GetUserId userId) {

        User user = userRepository.getById(userId.getUserId());
//        System.out.println(user);

        List<CandidateUser> candidateUsers =  user.getCandidateUsers();
        List<GetCandidate> candidates = new ArrayList<>();



        for (CandidateUser candidateUser : candidateUsers) {

            Candidate candidate =  candidateUser.getCandidatesAssigned();
//            System.out.println(candidate.getProject1().getProjectName());
            GetProject getProject = new GetProject(candidate.getProject1().getId(), candidate.getProject1().getProjectName());
            GetStream getStream =  new GetStream(candidate.getStream1().getId(), candidate.getStream1().getStreamName());

//            System.out.println(getProject);
//            System.out.println(getStream);
            List<GetUser> getUsers = new ArrayList<>();
            List<CandidateUser> candidateUsers1 = candidate.getCandidateUsers();
            for (CandidateUser candidateUser1: candidateUsers1) {
                List<Stream> streams = candidateUser1.getUsersAssigned().getUserStreams();
                GetUser getUser = new GetUser(candidateUser1.getUsersAssigned().getId(), candidateUser1.getUsersAssigned().getUserName(),
                        candidateUser1.getScore(), candidateUser1.getStatus(), streams);
                getUsers.add(getUser);

            }
            GetCandidate getCandidate = new GetCandidate(candidate.getId(), candidate.getCandidateName(), candidate.getCandidateExperience(), getProject, getStream,
                    candidate.getCandidateScore(),candidate.getCandidateStatus(),getUsers);
            candidates.add(getCandidate);
        }

        return candidates;

    }

    public GetCandidate getCandidate(Long id) {
        Candidate candidate = candidateService.getCandidate(id);

        GetProject getProject = new GetProject(candidate.getProject1().getId(), candidate.getProject1().getProjectName());
        GetStream getStream =  new GetStream(candidate.getStream1().getId(), candidate.getStream1().getStreamName());

//            System.out.println(getProject);
//            System.out.println(getStream);
        List<GetUser> getUsers = new ArrayList<>();
        List<CandidateUser> candidateUsers1 = candidate.getCandidateUsers();
        for (CandidateUser candidateUser1: candidateUsers1) {
            List<Stream> streams = candidateUser1.getUsersAssigned().getUserStreams();
            GetUser getUser = new GetUser(candidateUser1.getUsersAssigned().getId(), candidateUser1.getUsersAssigned().getUserName(), candidateUser1.getScore(), candidateUser1.getStatus(), streams);
            getUsers.add(getUser);

        }
        GetCandidate getCandidate = new GetCandidate(candidate.getId(), candidate.getCandidateName(), candidate.getCandidateExperience(), getProject, getStream,
                candidate.getCandidateScore(),candidate.getCandidateStatus(),getUsers);
        return getCandidate;
    }

    public List<Stream> getStreams(Long id) {
        return userRepository.getById(id).getUserStreams();
    }


    public List<GetPanelUser> getPanelUsers() {
        List<User> users = userRepository.findAll();

        List<GetPanelUser> panelUsers = new ArrayList<>();

        for (User user: users) {
            if(user.getUserLevel()!=null && user.getUserLevel().equals("panel")) {
                Long pending = 0L;
                for (CandidateUser candidateUser: user.getCandidateUsers()) {
//                    Candidate candidate = candidateUser.getCandidatesAssigned();
                    if(candidateUser.getStatus().equals("pending")){
                        pending++;
                    }
                }
                Long total = Long.valueOf(user.getCandidateUsers().size());
                Long interviewed = total - pending;
                panelUsers.add(new GetPanelUser(user.getId(), user.getUserName(), interviewed, pending, total));
            }
        }
        return panelUsers;
    }

    public User getUserByName(String username) {

        List<User> users = userRepository.findAll();

        User foundUser;

        for (User user: users) {
            if(user.getUserName().equals(username)) {
                return user;
            }
        }

        return null;
    }
}
