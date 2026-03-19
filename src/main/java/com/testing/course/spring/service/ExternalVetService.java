package com.testing.course.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalVetService {
    private final RestTemplate restTemplate;

    public ExternalVetService() {
        this.restTemplate = new RestTemplate();
    }

    public String getVetFromExternalApi(String url) {
        // Llamada a una API real (que no tenemos)
        return restTemplate.getForObject(url, String.class);
    }
}
