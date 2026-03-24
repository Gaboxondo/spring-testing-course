package com.testing.course.junit5.section4_execution.theory;

import com.testing.course.model.Specialty;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>Tests de Integración con Maven Failsafe</h1>
 *
 * <p>Esta clase demuestra cómo configurar y ejecutar tests de integración (IT) utilizando el
 * <b>Maven Failsafe Plugin</b>.</p>
 *
 * <h2>Convenciones de Nomenclatura</h2>
 * <p>Para que Maven reconozca automáticamente un test como de integración, se utilizan los siguientes sufijos:</p>
 * <ul>
 *   <li><code>*IT.java</code></li>
 *   <li><code>*ITCase.java</code></li>
 *   <li><code>*IntegrationTest.java</code></li>
 * </ul>
 *
 * <h2>¿Por qué usar Failsafe?</h2>
 * <p>A diferencia de Surefire (que detiene el build ante el primer fallo), Failsafe está diseñado para:</p>
 * <ol>
 *   <li>Ejecutar los tests en la fase <code>integration-test</code>.</li>
 *   <li>No fallar el build inmediatamente si un test falla.</li>
 *   <li>Esperar a la fase <code>post-integration-test</code> para realizar tareas de limpieza.</li>
 *   <li>Reportar los fallos finalmente en la fase <code>verify</code>.</li>
 * </ol>
 */
@DisplayName("Teoría: Failsafe Integration Test Demo")
class L2_SpecialtyIntegrationIT {

    /**
     * <h3>Simulación de un Test de Integración</h3>
     *
     * <p>En un entorno real, este test interactuaría con componentes externos como:</p>
     * <ul>
     *   <li>Bases de Datos (H2, PostgreSQL, etc.)</li>
     *   <li>APIs REST externas</li>
     *   <li>Sistemas de Mensajería</li>
     * </ul>
     *
     * <p><b>Comando de ejecución:</b> <code>mvn verify</code></p>
     */
    @Test
    @DisplayName("🧪 Test de Integración: specialty IT")
    void testIntegration() {
        // En tests de integración probaríamos llamadas a base de datos, API externa, etc.
        Specialty specialty = new Specialty("Odontología");
        assertNotNull(specialty.getName(), "La especialidad IT debería tener nombre");
        System.out.println("FAILSAFE: Ejecutando test de integración (más pesado)");
    }
}


