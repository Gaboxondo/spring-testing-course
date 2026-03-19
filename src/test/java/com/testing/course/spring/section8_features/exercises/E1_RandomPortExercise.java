package com.testing.course.spring.section8_features.exercises;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ejercicio 1: Entorno Web Real y Puerto Dinámico.
 * 
 * OBJETIVO: Configura este test para levantar la aplicación en un puerto ALEATORIO
 * (RANDOM_PORT). Luego, inyecta el puerto asignado y usa el TestRestTemplate
 * para hacer una llamada "real" al controlador interno.
 */
// TODO: Usa @SpringBootTest para levantar en un puerto aleatorio (RANDOM_PORT)
@Disabled("Ejercicio pendiente de resolver")
@DisplayName("Ej 1: TestIntegracion en RANDOM_PORT y TestRestTemplate")
class E1_RandomPortExercise {

    @RestController
    static class PingController {
        @GetMapping("/ping")
        public String ping() {
            return "pong";
        }
    }

    // TODO: Inyecta el puerto asignado aleatoriamente a la variable port usando @LocalServerPort
    private int port;

    // TODO: Inyecta en esta variable la plantilla de Rest para tests
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Debe devolver pong al llamar al endpoint local")
    void testPingEndpoint() {
        // TODO: Construye la url usando: "http://localhost:" + port + "/ping"
        String url = "";

        // TODO: Realiza un HTTP GET pasándole la url y esperando un String.class
        // ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        // TODO: Comprueba que el código de estado es 200 (OK) y el cuerpo es "pong"
    }
}
