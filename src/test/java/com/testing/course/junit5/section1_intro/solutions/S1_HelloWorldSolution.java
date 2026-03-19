package com.testing.course.junit5.section1_intro.solutions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución: Mi primer Test con JUnit 5 (Hello World).
 * Basado en: Section 4: Getting Started with JUnit 5 - 38.
 */
@DisplayName("Sección 4: Introducción a JUnit 5 (Hello World)")
class S1_HelloWorldSolution {

    @Test
    @DisplayName("🧪 Mi primer test Hola Mundo")
    void testHelloWorld() {
        // SOLUCIÓN:
        assertTrue(1 < 10, "1 debería ser menor que 10");
        System.out.println("¡Mi primer test ha pasado!");
    }

    @Test
    @DisplayName("🧪 Test que fallará (si no se deshabilita)")
    @Disabled("Deshabilitado para que el curso no falle en maven por defecto")
    void testFailExample() {
        // SOLUCIÓN: Este método se usa para aprender cómo se muestra un error en el IDE.
        fail("Este test fallaría si no estuviera deshabilitado");
    }
}

