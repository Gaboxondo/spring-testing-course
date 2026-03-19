package com.gaboxondo.testing.junit5.section7_execution.theory;

import org.junit.jupiter.api.*;

/**
 * TEORÍA SECCIÓN 7: Ejecución de Tests con Maven.
 * 
 * En Maven, existen dos ciclos principales para el testing automatizado:
 * 1.  Maven SUREFIRE Plugin: Ejecuta tests unitarios (mvn test). 
 *     Convención: Terminan en 'Test' o 'Tests'.
 * 
 * 2.  Maven FAILSAFE Plugin: Ejecuta tests de integración (mvn verify).
 *     Convención: Terminan en 'IT' (Integration Test).
 */
@DisplayName("Teoría: Maven Plugins y Ciclo de Vida")
class Section7ExecutionTheory {

    @Test
    @DisplayName("🧪 Demo 1: Surefire (Unit Test)")
    void unitTestDemo() {
        // Este test se ejecuta durante 'mvn test'.
        System.out.println("SUREFIRE: Ejecutando test unitario rápido.");
    }

    /**
     * COMANDOS A PROBAR:
     * 1. mvn test            -> Solo ejecuta este archivo.
     * 2. mvn verify          -> Ejecutará los tests de integración (*IT.java).
     * 3. mvn test-compile    -> Compila pero NO ejecuta nada.
     */
}
