package com.testing.course.ejercicio_final.exercises.unit;

import com.testing.course.ejercicio_final.service.RecommendationService;
import com.testing.course.ejercicio_final.client.PetSafetyClient;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Ejercicio: RecommendationService (Unit Test)")
class RecommendationServiceTest {

    @Mock
    private VetRepository vetRepository;
    @Mock
    private PetSafetyClient petSafetyClient;

    @InjectMocks
    private RecommendationService recommendationService;

    @Test
    @Disabled("TODO: Simular respuesta del repo y del cliente")
    void shouldReturnCautionWhenAlertsExist() {
        // GIVEN: Un veterinario en el repo (findById) y una alerta en el cliente
        // WHEN: Pedimos la recomendación
        // THEN: El nivel debe ser 'CAUTION'
    }
}
