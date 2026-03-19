package com.testing.course.spring.section6_properties.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Sección 6 - L1: Testeando la anotación @Value.
 * 
 * La anotación @Value lee del entorno de Spring (Environment).
 * Para testear estos valores sin depender de application.properties, 
 * usamos @TestPropertySource.
 */
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
    "server.host=localhost",
    "server.port=8080"
})
@DisplayName("Sección 6 - L1: Inyección con @Value")
class L1_ValueAnnotationTheory {

    @Value("${server.host}")
    String host;

    @Value("${server.port}")
    int port;

    @Test
    @DisplayName("🧪 Verificar que @Value inyecta los valores de @TestPropertySource")
    void testValueInjected() {
        assertEquals("localhost", host);
        assertEquals(8080, port);
    }
}

