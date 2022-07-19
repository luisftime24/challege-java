package com.challenge.api.externalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public interface PhotoService {
    public ResponseEntity<?> getPhoto(Long id);
}
