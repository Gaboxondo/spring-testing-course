package com.testing.course.spring.section5_wiremock.theory;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.testing.course.spring.service.ExternalVetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Sección 5 - L2: Wiremock con JUnit 5 Extension (@WireMockTest).
 * 
 * En lugar de arrancar manualmente el servidor, la extensión de JUnit lo hace más limpio.
 */
@WireMockTest(httpPort = 8089)
@DisplayName("Sección 2 - L2: Wiremock con @WireMockTest")
class L2_WiremockRecordingTheory {

    ExternalVetService externalService = new ExternalVetService();

    @Test
    @DisplayName("🧪 Verificar flujo completo con delay simulado")
    void testSlowApiResponse() {
        // Wiremock permite simular errores de red y retardos.
        stubFor(get(urlPathEqualTo("/slow-api"))
                .willReturn(aResponse()
                        .withFixedDelay(500) // 500ms de retraso.
                        .withStatus(200)
                        .withBody("Respuesta lenta")));

        String response = externalService.getVetFromExternalApi("http://localhost:8089/slow-api");
        
        assertEquals("Respuesta lenta", response);
    }
}
