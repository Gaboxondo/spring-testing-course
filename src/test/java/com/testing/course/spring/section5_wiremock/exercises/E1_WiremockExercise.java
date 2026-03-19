package com.testing.course.spring.section5_wiremock.exercises;


import org.junit.jupiter.api.Disabled;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.testing.course.spring.service.ExternalVetService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio L3: Simulando la Farmacia Externa.
 * 
 * Basado en: Section 5 - L2_WiremockRecordingTheory.
 * 
 * OBJETIVO: Simular un error de red o de sistema (HTTP 500) de una API externa.
 */
@WireMockTest(httpPort = 8089)
@Disabled("Ejercicio pendiente de resolver")
class E1_WiremockExercise {

    ExternalVetService externalService = new ExternalVetService();

    @Test
    void testExternalApiError() {
        // TODO: Escenario: La API externa falla con un error 500.
        // - Configura un stub para "/api/error" que devuelva status 500.
        // - Llama a externalService.getVetFromExternalApi y comprueba el resultado.
        // (En este caso RestTemplate lanzará una excepción, o devolverá null si lo manejas).
    }
}


