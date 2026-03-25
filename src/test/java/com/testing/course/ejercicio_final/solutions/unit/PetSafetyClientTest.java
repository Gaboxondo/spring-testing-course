package com.testing.course.ejercicio_final.solutions.unit;

import com.testing.course.ejercicio_final.client.PetSafetyClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Solución: PetSafetyClient (Unit Test)")
class PetSafetyClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PetSafetyClient petSafetyClient;

    @Test
    @DisplayName("🧪 Debe devolver alertas cuando la API responde correctamente")
    void shouldReturnAlertsWhenApiResponds() {
        String[] mockResponse = {"Rabies", "Distemper"};
        // El constructor usó el default value de @Value en producción o null. 
        // Como el test no inyectó el valor, la URL será null + "/alerts...". 
        // Mockito @InjectMocks inyectó los mocks pero no el string.
        // Forzaremos el mock del restTemplate a cualquier URL.
        when(restTemplate.getForObject(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.eq(String[].class)))
                .thenReturn(mockResponse);

        List<String> result = petSafetyClient.getAlertsForSpecies("dog");

        assertEquals(2, result.size());
        assertTrue(result.contains("Rabies"));
    }

    @Test
    @DisplayName("🧪 Debe devolver lista vacía cuando ocurre un error")
    void shouldReturnEmptyListOnError() {
        when(restTemplate.getForObject(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.eq(String[].class)))
                .thenThrow(new RuntimeException("Connection error"));

        List<String> result = petSafetyClient.getAlertsForSpecies("dog");

        assertTrue(result.isEmpty());
    }
}
