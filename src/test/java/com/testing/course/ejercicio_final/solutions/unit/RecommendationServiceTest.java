package com.testing.course.ejercicio_final.solutions.unit;

import com.testing.course.ejercicio_final.client.PetSafetyClient;
import com.testing.course.ejercicio_final.model.VetRecommendation;
import com.testing.course.ejercicio_final.service.RecommendationService;
import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Solución: RecommendationService (Unit Test)")
class RecommendationServiceTest {

    @Mock
    private VetRepository vetRepository;
    @Mock
    private PetSafetyClient petSafetyClient;

    @InjectMocks
    private RecommendationService recommendationService;

    @Test
    @DisplayName("🧪 Nivel CAUTION cuando existen alertas sanitarias")
    void shouldReturnCautionWhenAlertsExist() {
        Vet vet = new Vet("John", "Doe");
        when(vetRepository.findById(1L)).thenReturn(Optional.of(vet));
        when(petSafetyClient.getAlertsForSpecies("dog")).thenReturn(List.of("Alert 1"));

        VetRecommendation result = recommendationService.getRecommendationForVet(1L, "dog");

        assertEquals("CAUTION", result.getRecommendationLevel());
        assertEquals("John Doe", result.getVetName());
    }

    @Test
    @DisplayName("🧪 Nivel HIGH cuando NO existen alertas")
    void shouldReturnHighWhenNoAlerts() {
        Vet vet = new Vet("Jane", "Smith");
        when(vetRepository.findById(2L)).thenReturn(Optional.of(vet));
        when(petSafetyClient.getAlertsForSpecies("cat")).thenReturn(List.of());

        VetRecommendation result = recommendationService.getRecommendationForVet(2L, "cat");

        assertEquals("HIGH", result.getRecommendationLevel());
    }
}
