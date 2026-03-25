package com.testing.course.spring.section8_features.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Solución 1: Entorno Web Real y Puerto Dinámico.
 */
// SOLUCIÓN:
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(S1_RandomPortSolution.PingController.class)
@DisplayName("Sol 1: TestIntegracion en RANDOM_PORT y TestRestTemplate")
class S1_RandomPortSolution {

    @RestController
    static class PingController {
        @GetMapping("/ping-solucion")
        public String ping() {
            return "pong";
        }
    }

    // SOLUCIÓN:
    @LocalServerPort
    private int port;

    // SOLUCIÓN:
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Debe devolver pong al llamar al endpoint local")
    void testPingEndpoint() {
        // SOLUCIÓN:
        String url = "http://localhost:" + port + "/ping-solucion";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        // SOLUCIÓN:
        assertEquals(200, response.getStatusCode().value());
        assertEquals("pong", response.getBody());
    }
}
