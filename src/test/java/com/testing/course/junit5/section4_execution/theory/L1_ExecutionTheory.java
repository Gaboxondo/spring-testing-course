package com.testing.course.junit5.section4_execution.theory;

import org.junit.jupiter.api.*;

/**
 * <h1>Teoría de Ejecución de Tests con Maven</h1>
 *
 * <p>Esta clase introduce los conceptos fundamentales de la ejecución de tests automatizados
 * utilizando el ciclo de vida de Maven y sus plugins especializados.</p>
 *
 * <h2>Conceptos Clave</h2>
 * <ul>
 *   <li><b>Maven Surefire Plugin:</b> Diseñado para la ejecución de tests unitarios rápidos.
 *   Se ejecuta por defecto en la fase <code>test</code> del ciclo de vida de Maven.</li>
 *   <li><b>Maven Failsafe Plugin:</b> Diseñado para la ejecución de tests de integración (IT)
 *   que suelen ser más pesados y requieren un entorno configurado. Se ejecuta en la fase <code>verify</code>.</li>
 * </ul>
 *
 * <h3>Ciclo de Vida de Maven</h3>
 * <ol>
 *   <li><code>mvn test</code>: Ejecuta los tests unitarios (Surefire).</li>
 *   <li><code>mvn integration-test</code>: Ejecuta los tests de integración (Failsafe).</li>
 *   <li><code>mvn verify</code>: Ejecuta ambos y verifica la integridad del proyecto.</li>
 * </ol>
package com.testing.course.junit5.section4_execution.theory;

import org.junit.jupiter.api.*;

/**
 * <h1>Teoría de Ejecución de Tests con Maven</h1>
 *
 * <p>Esta clase introduce los conceptos fundamentales de la ejecución de tests automatizados
 * utilizando el ciclo de vida de Maven y sus plugins especializados.</p>
 *
 * <h2>Conceptos Clave</h2>
 * <ul>
 *   <li><b>Maven Surefire Plugin:</b> Diseñado para la ejecución de tests unitarios rápidos.
 *   Se ejecuta por defecto en la fase <code>test</code> del ciclo de vida de Maven.</li>
 *   <li><b>Maven Failsafe Plugin:</b> Diseñado para la ejecución de tests de integración (IT)
 *   que suelen ser más pesados y requieren un entorno configurado. Se ejecuta en la fase <code>verify</code>.</li>
 * </ul>
 *
 * <h3>Ciclo de Vida de Maven</h3>
 * <ol>
 *   <li><code>mvn test</code>: Ejecuta los tests unitarios (Surefire).</li>
 *   <li><code>mvn integration-test</code>: Ejecuta los tests de integración (Failsafe).</li>
 *   <li><code>mvn verify</code>: Ejecuta ambos y verifica la integridad del proyecto.</li>
 * </ol>
 *
 * <p><b>¿Por qué separar Surefire y Failsafe?</b></p>
 * <p>Surefire detiene la compilación al primer fallo. Failsafe permite que los tests fallen pero
 * continúa hasta la fase de <i>post-integration-test</i> para asegurar que los recursos (bases de datos,
 * contenedores, etc.) se cierren correctamente antes de informar del error final en la fase <i>verify</i>.</p>
 *
 * <p><b>Importante:</b> Maven escanea el directorio <code>src/test/java</code> buscando clases
 * que terminen en <code>Test</code>, <code>Tests</code> o <code>TestCase</code> para Surefire,
 * y <code>IT</code> o <code>ITCase</code> para Failsafe.</p>
 *
 * <h2>Detalle de Ejecución Selectiva</h2>
 * <p>Maven permite filtrar qué tests ejecutar desde la línea de comandos:</p>
 * <ul>
 *   <li><b>Ejecutar todo:</b> <code>mvn test</code></li>
 *   <li><b>Ejecutar una clase específica:</b> <code>mvn test -Dtest=L1_ExecutionTheory</code></li>
 *   <li><b>Ejecutar tests de integración:</b> <code>mvn verify</code></li>
 * </ul>
 *
 * @see L2_SpecialtyIntegrationIT
 */
@DisplayName("Teoría: Maven Plugins y Ciclo de Vida")
class L1_ExecutionTheory {

    /**
     * <h3>Demo de Test Unitario (Surefire)</h3>
     *
     * <p>Este método representa un test unitario estándar. Los tests unitarios deben ser:</p>
     * <ul>
     *   <li><b>Rápidos:</b> Ejecución en milisegundos.</li>
     *   <li><b>Aislados:</b> No dependen de sistemas externos.</li>
     *   <li><b>Deterministas:</b> Siempre deben dar el mismo resultado.</li>
     * </ul>
     *
     * <p><b>Anotaciones utilizadas:</b></p>
     * <ul>
     *   <li>{@link Test}: Marca el método como un test ejecutable por JUnit 5.</li>
     *   <li>{@link DisplayName}: Proporciona un nombre legible para el reporte de ejecución.</li>
     * </ul>
     */
    @Test
    @DisplayName("🧪 Demo 1: Surefire (Unit Test)")
    void unitTestDemo() {
        // Este test se ejecuta durante 'mvn test'.
        System.out.println("SUREFIRE: Ejecutando test unitario rápido.");
    }
}
