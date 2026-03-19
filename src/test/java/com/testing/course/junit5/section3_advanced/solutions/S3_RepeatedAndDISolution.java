package com.testing.course.junit5.section3_advanced.solutions;

import org.junit.jupiter.api.*;

/**
 * Solución 9: Tests Repetidos e Inyección de Dependencias.
 * Basado en: Section 6: Advanced JUnit Testing - 67, 68.
 */
class S3_RepeatedAndDISolution {

    @DisplayName("🧪 Test Repetido: Ejecución especial")
    @RepeatedTest(value = 5, name = "{displayName}: {currentRepetition} de {totalRepetitions}")
    void repeatedTest() {
        System.out.println("Este test se repite");
    }

    @Test
    @DisplayName("🧪 Test DI: Reporting")
    void diTest(TestReporter reporter, TestInfo testInfo) {
        // SOLUCIÓN: Inyección directa por parámetros de JUnit (no de Spring).
        reporter.publishEntry("Ejecutando test", testInfo.getDisplayName());
        reporter.publishEntry("status", "OK");
    }
}

