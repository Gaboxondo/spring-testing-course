package com.gaboxondo.testing.junit5.section5_basics.exercises;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Ejercicio 3: Anotaciones de Control (@Disabled, @DisplayName).
 * Basado en: Section 5: Testing Java with JUnit 5 - 51, 52.
 */
class AnnotationsExercise {

    @Test
    // TODO 1: Añade un DisplayName amigable para este test
    void testMeaningfulName() {
        // ... (Tu código aquí)
    }

    @Test
    // TODO 2: Deshabilita este test indicando el motivo en la anotación
    void testTBD() {
        // Este test no está acabado aún y no queremos que falle el build.
    }
}
