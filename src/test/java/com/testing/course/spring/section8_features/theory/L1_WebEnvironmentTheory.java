package com.testing.course.spring.section8_features.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Sección 8 - L1: @SpringBootTest y webEnvironment.
 * 
 * Basado en las opciones de Spring Boot:
 * 
 * 1. MOCK (Default): Carga un WebContext mockeado. No levanta servidor real.
 * 2. RANDOM_PORT: Levanta el servidor en un puerto aleatorio (0). Evita conflictos.
 * 3. DEFINED_PORT: Levanta el servidor en el puerto 8080 (o lo definido en properties).
 * 4. NONE: Solo carga el contexto, sin puerto ni capacidades web.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Sección 8 - L1: Entornos Web")
class L1_WebEnvironmentTheory {

    @Test
    @DisplayName("🧪 Verificar servidor en puerto aleatorio")
    void testServerStarted() {
        // En este modo podemos inyectar TestRestTemplate o WebTestClient
        assertNotNull(this); 
    }
}
