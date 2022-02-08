package com.jwt.controller;

import com.jwt.model.*;
import com.jwt.util.candidate.getCandidate.GetCandidate;
import com.jwt.util.user.getUser.GetPanelUser;
import com.jwt.services.UserService;
import com.jwt.util.user.addUser.Userpass;
import com.jwt.util.user.getUser.GetUserId;
import com.jwt.util.user.getUser.UserReturn;
import com.jwt.util.user.getUser.UserReturnNew;
import com.jwt.util.user.updateUser.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/getuser")
    public UserReturnNew getUser(@RequestBody Userpass userpass) {

        UserReturn user =  userService.getUser(userpass);

        return new UserReturnNew(user.getUserId(), user.getUserName(), user.getLevel());
    }

    @GetMapping(value = "/getuser/{id}")
    public UserReturnNew getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return  new UserReturnNew(user.getId(), user.getUserName(), user.getUserLevel());
    }

    @GetMapping(value = "/getusers")
    public List<UserReturnNew> getUsers() {
        List<UserReturnNew> users = new ArrayList<>();

        for (UserReturn user: userService.getUsers()) {
            users.add(new UserReturnNew(user.getUserId(), user.getUserName(), user.getLevel()));
        }
        return users;
    }

    @PostMapping(value = "/getcandidates")
    public List<GetCandidate> getCandidates(@RequestBody GetUserId userId) {
        return userService.getCandidates(userId);
    }
    @GetMapping(value = "/user/candidate/{id}")
    public GetCandidate getCandidate(@PathVariable("id") Long id) {
        return userService.getCandidate(id);
    }

    @PostMapping(value = "/adduser")
    public User addUser(@RequestBody Userpass userpass) {
        return userService.saveUser(userpass);
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
    public User updateUser(@RequestBody UpdateUser updateUser) {

        return userService.updateUser(updateUser);
    }

    @GetMapping(value = "/getstreams/{id}")
    public List<Stream> getStreams(@PathVariable Long id) {
        return userService.getStreams(id);
    }

    @GetMapping(value = "/getpaneldetails")
    public List<GetPanelUser> getPanelUsers() {
        return userService.getPanelUsers();
    }
}
