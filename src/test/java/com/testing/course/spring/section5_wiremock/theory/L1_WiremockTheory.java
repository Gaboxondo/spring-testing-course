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
 * <h1>TEORÍA: Servidores HTTP de Simulación (WireMock)</h1>
 * 
 * <p><b>Qué hace:</b> Levanta un servidor HTTP real en un puerto local, permitiendo 
 * interceptar y responder a peticiones salientes de nuestra aplicación.</p>
 * 
 * <p><b>Por qué existe:</b> Es la herramienta estándar para testear integraciones 
 * con APIs de terceros (Stripe, Twilio, Google). Evita realizar llamadas reales 
 * a internet, ahorrando costes y garantizando un entorno determinista.</p>
 * 
 * <h2>Principios del Stubbing:</h2>
 * <p>A diferencia de Mockito (que mockea objetos Java), WireMock mockea el 
 * <b>canal de red</b>. El código de producción "cree" que está hablando con la API real.</p>
 */
@DisplayName("Sección 5 - L1: WireMock Standalone Server")
class L1_WiremockTheory {

    private WireMockServer wireMockServer;
    private ExternalVetService externalVetService;

    @BeforeEach
    void setUp() {
        // Inicialización manual del servidor en puerto fijo
        wireMockServer = new WireMockServer(8089);
        wireMockServer.start();
        configureFor("localhost", 8089);
        externalVetService = new ExternalVetService();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    /**
     * <h2>DEMO: Mockeo de respuesta JSON</h2>
     * <p>Programamos el servidor para que cuando reciba un GET específico, 
     * devuelva un cuerpo JSON simulado con cabeceras reales.</p>
     */
    @Test
    @DisplayName("🧪 Demo 16: Simular respuesta HTTP 200 de API Externa")
    void testExternalApiCall() {
        stubFor(get(urlEqualTo("/api/external"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"status\": \"Mocked by Wiremock\"}")));

        String response = externalVetService.getVetFromExternalApi("http://localhost:8089/api/external");
        assertTrue(response.contains("Mocked by Wiremock"));
    }
}
