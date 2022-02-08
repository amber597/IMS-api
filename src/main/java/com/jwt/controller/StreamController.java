package com.jwt.controller;

import com.jwt.model.Stream;
import com.jwt.services.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/streams")
@CrossOrigin(origins = "*")
public class StreamController {
    @Autowired
    private StreamService streamService;

    @GetMapping
    public List<Stream> getStreams() {
        return streamService.findStreams();
    }

}
