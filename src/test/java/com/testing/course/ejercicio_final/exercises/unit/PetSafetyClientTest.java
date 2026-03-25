package com.testing.course.ejercicio_final.exercises.unit;

import com.testing.course.ejercicio_final.client.PetSafetyClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
@DisplayName("Ejercicio: PetSafetyClient (Unit Test)")
class PetSafetyClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PetSafetyClient petSafetyClient;

    @Test
    @Disabled("TODO: Verificar el parseo de alertas")
    void shouldReturnAlertsWhenApiResponds() {
        // GIVEN: Un RestTemplate mockeado que devuelve un array de strings (usar ArgumentMatchers si es necesario)
        // WHEN: Llamamos a petSafetyClient.getAlertsForSpecies
        // THEN: Verificamos que la lista resultante contiene los elementos esperados
    }
}
