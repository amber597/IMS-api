package com.jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        com.jwt.model.User foundUser = userService.getUserByName(userName);

        if(foundUser !=null){
            return new User(foundUser.getUserName(), foundUser.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found !!");
        }
    }
}
