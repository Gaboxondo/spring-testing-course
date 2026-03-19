package com.testing.course.junit5.section1_intro.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio: Mi primer Test con JUnit 5 (Hello World).
 * Basado en: Section 4: Getting Started with JUnit 5 - 38.
 *
 * TODO: Crea un test que use 'assertTrue' para validar una expresión simple.
 */
class L1_HelloWorldExercise {

    @Test
    void testHelloWorld() {
        // TODO: Comprobar que 1 < 10 usando assertTrue
    }

    @Test
    void testFailAlways() {
        // TODO: Usa fail("mensaje") para forzar un error al principio y ver cómo se reporta
    }
}
