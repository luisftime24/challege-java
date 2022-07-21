package com.challenge.api.externalService;

import com.challenge.api.entity.Image;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {
    public Image getPhoto(Long id);
}
