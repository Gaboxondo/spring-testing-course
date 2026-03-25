package com.testing.course.ejercicio_final.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>CLIENTE: PetSafetyClient</h1>
 * 
 * <p>Se comunica con una API externa para obtener alertas sanitarias vigentes.</p>
 */
@Component
public class PetSafetyClient {

    private final RestTemplate restTemplate;
    private final String apiUrl;

    public PetSafetyClient(RestTemplate restTemplate, @Value("${pet.safety.api.url:https://api.petsafety.com}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    /**
     * Obtiene alertas para una especie concreta.
     */
    public List<String> getAlertsForSpecies(String species) {
        String url = apiUrl + "/alerts?species=" + species;
        try {
            String[] alerts = restTemplate.getForObject(url, String[].class);
            return alerts != null ? Arrays.asList(alerts) : List.of();
        } catch (Exception e) {
            // En caso de error de red, devolvemos lista vacía (fail-safe)
            return List.of();
        }
    }
}
