package com.testing.course.spring.section5_wiremock.solutions;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.testing.course.spring.service.ExternalVetService;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpServerErrorException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución L4: Simulando la Farmacia Externa.
 */
@WireMockTest(httpPort = 8089)
class S1_WiremockSolution {

    ExternalVetService externalService = new ExternalVetService();

    @Test
    void testExternalApiError() {
        // SOLUCIÓN:
        stubFor(get(urlPathEqualTo("/api/error"))
                .willReturn(aResponse().withStatus(500)));

        assertThrows(HttpServerErrorException.class, () -> {
            externalService.getVetFromExternalApi("http://localhost:8089/api/error");
        });
    }
}

