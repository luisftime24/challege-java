package com.challenge.api.externalService;

import com.challenge.api.advice.TrackExecutionTime;
import com.challenge.api.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    RestTemplate restTemplate;

    @TrackExecutionTime
    @Override
    public Image getPhoto(Long id) {
        String url = String.format("https://api.pexels.com/v1/photos/%d", id + 1000000);
        return restTemplate.getForObject(url, Image.class);
    }
}