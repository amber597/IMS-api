package com.jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home {

    @RequestMapping("/api/v1/welcome")
    public String welcome(){
        String text = "Succesfully login ";
        return text;
    }
    @RequestMapping("/api/v1/getusers")
    public String getUser(){

        return "{\"name\":\"Sam\"}";
    }

}
