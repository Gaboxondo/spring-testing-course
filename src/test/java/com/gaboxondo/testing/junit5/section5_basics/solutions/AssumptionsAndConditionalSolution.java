package com.gaboxondo.testing.junit5.section5_basics.solutions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * Solución 6: Asunciones y Tests Condicionales.
 * Basado en: Section 5: Testing Java with JUnit 5 - 55, 56.
 */
class AssumptionsAndConditionalSolution {

    @Test
    void testOnlyOnDevelopment() {
        // SOLUCIÓN: Abortar si no se cumple el entorno esperado.
        // Simulamos entorno leyendo variable 'ENV'.
        // Si no existe, assumeTrue(false) aborta sin error (status 'skipped')
        assumeTrue("DEV".equalsIgnoreCase(System.getenv("ENV")));
        
        System.out.println("Este código solo se ejecuta si estamos en entorno DEV");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testWindowsOnly() {
        // SOLUCIÓN: Solo se activa en Windows.
        System.out.println("Test para entorno Windows completado satisfactoriamente");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMacOnly() {
        // Obviamente este saltará si estás en Windows.
    }
}
