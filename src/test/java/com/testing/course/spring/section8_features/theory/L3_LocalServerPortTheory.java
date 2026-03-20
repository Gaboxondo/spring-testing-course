package com.testing.course.spring.section8_features.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <h1>TEORÍA: Inyección de puerto real (@LocalServerPort)</h1>
 * 
 * <p><b>Qué hace:</b> Captura el número de puerto TCP que el sistema operativo 
 * asigna dinámicamente al servidor embebido durante un test <code>RANDOM_PORT</code>.</p>
 * 
 * <p><b>Por qué existe:</b> Permite construir URLs de invocoación dinámica 
 * en tiempo de ejecución (ej: <code>"http://localhost:" + port + "/api"</code>), 
 * garantizando que los tests funcionan en cualquier host o entorno de CI/CD.</p>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Sección 8 - L3: Interceptación del Canal de Red")
class L3_LocalServerPortTheory {

    @LocalServerPort 
    private int port;

    /**
     * <h2>DEMO: Depuración del puerto efímero</h2>
     * <p>Verificamos que Spring es capaz de inyectar el puerto aleatorio en 
     * nuestra variable gestionada.</p>
     */
    @Test
    @DisplayName("🧪 Demo 15: Localización del servidor embebido")
    void testPortInjected() {
        assertTrue(port > 0, "Debe inyectar un puerto TCP asignado");
        System.out.println("🚀 Servidor levantado en: localhost:" + port);
    }
}
