package com.testing.course.spring.section6_properties.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h1>TEORÍA: Inyección de Configuración Variable (@Value)</h1>
 * 
 * <p><b>Qué hace:</b> Permite inyectar valores escalares del entorno (propiedades) 
 * directamente en los campos de nuestras clases.</p>
 * 
 * <p><b>Por qué existe:</b> Facilita la externalización de parámetros de negocio 
 * y técnicos, permitiendo que el mismo binario de la aplicación se comporte 
 * distinto en Dev, Staging o Prod cambiando solo su configuración.</p>
 */
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
    "server.host=localhost",
    "server.port=8080"
})
@DisplayName("Sección 6 - L1: Inyección de Valores del Entorno")
class L1_ValueAnnotationTheory {

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private int port;

    /**
     * <h2>DEMO: Resolución de Placeholders</h2>
     * <p>El motor de Spring lee de la anotación <code>@TestPropertySource</code> 
     * y resuelve las expresiones <code>${...}</code> antes de ejecutar el test.</p>
     */
    @Test
    @DisplayName("🧪 Demo 18: Inyección básica de propiedades inline")
    void testValueInjected() {
        assertEquals("localhost", host);
        assertEquals(8080, port);
    }
}
