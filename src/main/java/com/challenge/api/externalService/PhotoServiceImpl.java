package com.challenge.api.externalService;

import com.challenge.api.advice.TrackExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    RestTemplate restTemplate;

    @TrackExecutionTime
    @Override
    public ResponseEntity<?> getPhoto(Long id) {
        try {
            String url = String.format("https://api.pexels.com/v1/photos/%d", id + 1000000);
            String result = restTemplate.getForObject(url, String.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
