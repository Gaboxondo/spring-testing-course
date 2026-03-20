package com.testing.course.spring.section5_wiremock.theory;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.testing.course.spring.service.ExternalVetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: Integración Nativa (@WireMockTest)</h1>
 * 
 * <p><b>Qué hace:</b> Utiliza la extensión de JUnit 5 para gestionar automáticamente 
 * el ciclo de vida (start/stop) del servidor WireMock sin código repetitivo.</p>
 * 
 * <p><b>Por qué existe:</b> Simplifica los tests y evita fugas de memoria (servidores 
 * que se quedan encendidos tras un fallo del test), integrándose perfectamente 
 * con el modelo de programación de JUnit 5.</p>
 */
@WireMockTest(httpPort = 8089)
@DisplayName("Sección 5 - L2: WireMock con JUnit Extension")
class L2_WiremockRecordingTheory {

    private ExternalVetService externalService = new ExternalVetService();

    /**
     * <h2>DEMO: Simulación de Latencia (Slow API)</h2>
     * <p>WireMock permite inyectar retardos para testear la robustez de nuestros 
     * clientes HTTP y sus políticas de Timeout.</p>
     */
    @Test
    @DisplayName("🧪 Demo 17: Verificación de flujos con retardo (FixedDelay)")
    void testSlowApiResponse() {
        stubFor(get(urlPathEqualTo("/slow-api"))
                .willReturn(aResponse()
                        .withFixedDelay(500) 
                        .withStatus(200)
                        .withBody("Respuesta lenta")));

        String response = externalService.getVetFromExternalApi("http://localhost:8089/slow-api");
        assertEquals("Respuesta lenta", response);
    }
}
