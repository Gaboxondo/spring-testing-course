package com.testing.course.junit5.section4_execution.theory;

import org.junit.jupiter.api.*;

/**
 * TEORÍA SECCIÓN 7: Ejecución de Tests con Maven.
 * 
 * Basado en: Section 7 - Lecciones 83 a 86.
 * 
 * DETALLE FINO:
 * - SUREFIRE: Orientado a tests rápidos que no requieren entorno (Unitarios). Salta por defecto con 'mvn test'.
 * - FAILSAFE: Orientado a tests lentos (Integración). Salta con 'mvn verify' o 'mvn integration-test'.
 *   No falla la compilación inmediatamente, continúa hasta 'verify' para asegurar que el entorno de 
 *   integración se limpie (@AfterAll) antes de reportar el error.
 * 
 * REFERENCIAS:
 * - Mira la configuración del plugin 'maven-failsafe-plugin' en el archivo 'pom.xml'.
 * - El test IT de ejemplo está en: 'SpecialtyIntegrationIT.java'.
 */
@DisplayName("Teoría: Maven Plugins y Ciclo de Vida")
class L1_ExecutionTheory {

    @Test
    @DisplayName("🧪 Demo 1: Surefire (Unit Test)")
    void unitTestDemo() {
        // Este test se ejecuta durante 'mvn test'.
        System.out.println("SUREFIRE: Ejecutando test unitario rápido.");
    }

    /**
     * DETALLE DE EJECUCIÓN (MUY IMPORTANTE):
     * Maven por defecto escanea todo el directorio 'src/test/java'.
     *
     * 1. 'mvn test': Ejecuta TODAS las capas de las secciones 4, 5, 6 y 7. 
     *     - Útil para CI o antes de un commit.
     * 
     * 2. 'mvn test -Dtest=L1_ExecutionTheory': Solo ejecuta este archivo.
     *     - Útil durante el aprendizaje para no ver logs de asertos antiguos.
     *
     * 3. 'mvn verify': Dispara maven-failsafe-plugin (busca SpecialtyIntegrationIT).
     *     - Se ejecuta desde la raíz del proyecto.
     */
}

