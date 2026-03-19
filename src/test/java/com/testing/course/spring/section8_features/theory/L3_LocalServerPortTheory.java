package com.testing.course.spring.section8_features.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Sección 8 - L3: Inyectando el puerto con @LocalServerPort.
 * 
 * Cuando usamos RANDOM_PORT, no sabemos el puerto final.
 * Esta anotación nos permite recuperarlo e inyectarlo en un test.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Sección 8 - L3: Inyección de puerto real")
class L3_LocalServerPortTheory {

    @LocalServerPort // Inyecta el puerto elegido por Spring Boot.
    int port;

    @Test
    @DisplayName("🧪 Verificar que el puerto inyectado es > 0")
    void testPortInjected() {
        assertTrue(port > 0);
        System.out.println("🚀 Servidor levantado en el puerto: " + port);
    }
}
