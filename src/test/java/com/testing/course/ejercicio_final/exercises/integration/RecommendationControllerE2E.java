package com.testing.course.ejercicio_final.exercises.integration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Ejercicio: Recommendation E2E")
class RecommendationControllerE2E {

    // TODO: Configurar infraestructura Wiremock
    // TODO: Configurar Mocks necesarios para el repo
    // TODO: Inyectar TestRestTemplate

    @Test
    @Disabled("TODO: Flujo total Controller -> Service -> Client -> Wiremock")
    void fullE2EFlow() {
        // TODO: Simular repositorio y Wiremock, luego llamar via restTemplate
        // TODO: RETO: Verificar que tras pedir una recomendación, el contador de auditoría sube
    }
}
