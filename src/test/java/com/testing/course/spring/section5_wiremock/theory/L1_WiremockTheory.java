package com.testing.course.spring.section5_wiremock.theory;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.testing.course.spring.service.ExternalVetService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Sección 5 - L1: Introducción a Wiremock.
 * 
 * ¿Qué pasa si tu microservicio depende de una API externa (Google, Stripe, etc.)?
 * No quieres llamar a la API real en cada test. Wiremock levanta un SERVIDOR REAL 
 * local al que le programas respuestas HTTP.
 */
@DisplayName("Sección 5 - L1: Wiremock Standalone Server")
class L1_WiremockTheory {

    WireMockServer wireMockServer;
    ExternalVetService externalVetService;

    @BeforeEach
    void setUp() {
        // Arrancamos el servidor en el puerto 8089.
        wireMockServer = new WireMockServer(8089);
        wireMockServer.start();
        configureFor("localhost", 8089);

        externalVetService = new ExternalVetService();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    @DisplayName("🧪 Simular una respuesta HTTP 200 de una API externa")
    void testExternalApiCall() {
        // Stubbing de la API externa: "Cuando recibas GET /api/external, devuelve JSON"
        stubFor(get(urlEqualTo("/api/external"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"status\": \"Mocked by Wiremock\"}")));

        String response = externalVetService.getVetFromExternalApi("http://localhost:8089/api/external");
        
        assertTrue(response.contains("Mocked by Wiremock"));
    }
}

