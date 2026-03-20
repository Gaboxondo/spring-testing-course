package com.testing.course.spring.section8_features.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * <h1>TEORÍA: Modos del entorno Web (@SpringBootTest)</h1>
 * 
 * <p><b>Qué hace:</b> Permite definir si Spring Boot levantará capacidad 
 * web (HTTP), si usará simulación (MOCK) o si ignorará por completo el puerto.</p>
 * 
 * <p><b>Por qué existe:</b> Proporciona flexibilidad. Un test de integración de 
 * lógica de negocio no requiere levantar Tomcat (NONE), mientras que uno de 
 * interoperabilidad sí (RANDOM_PORT).</p>
 * 
 * <h2>Principios del WebEnvironment:</h2>
 * <ul>
 *   <li><b>MOCK (Default):</b> Carga un WebContext mockeado. Sin puerto.</li>
 *   <li><b>RANDOM_PORT:</b> Levanta el servidor en un puerto aleatorio real (0 para OS).</li>
 *   <li><b>DEFINED_PORT:</b> Usa el puerto de properties (ej: 8080). Riesgo de colisión.</li>
 *   <li><b>NONE:</b> Solo carga el contexto, ignorando la capa Web. Muy eficiente.</li>
 * </ul>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Sección 8 - L1: Configuración del WebEnvironment")
class L1_WebEnvironmentTheory {

    @Test
    @DisplayName("🧪 Demo 13: Levantar servidor real en puerto efímero")
    void testServerStarted() {
        assertNotNull(this, "El test ha levantado servidor externo"); 
    }
}
