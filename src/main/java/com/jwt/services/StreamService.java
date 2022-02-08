package com.jwt.services;

import com.jwt.model.Stream;
import com.jwt.repositories.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreamService {

    @Autowired
    private StreamRepository streamRepository;

    public Stream findStreamById(Long streamId) {
        if(streamRepository.existsById(streamId)) {
            return streamRepository.getById(streamId);
        }
        return null;
    }
    public List<Stream> findStreams() {
        List<Stream> streams =  streamRepository.findAll();
        List<Stream> newStreams = new ArrayList<>();

        for (Stream stream: streams) {
            if(stream.getStreamName().equals("management")) {
//                streams.remove(stream);
            } else {
                newStreams.add(stream);
            }
        }



        return newStreams;
    }
}
