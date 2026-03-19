package com.testing.course.junit5.section3_advanced.exercises;

import org.junit.jupiter.api.*;

/**
 * Ejercicio 9: Tests Repetidos e Inyección de Dependencias.
 * Basado en: Section 6: Advanced JUnit Testing - 67, 68.
 */
class E3_RepeatedAndDIExercise {

    @Test
    // TODO 1: Usa @RepeatedTest para ejecutar este test 5 veces. 
    // Añade la anotación y cambia @Test por @RepeatedTest(5)
    void repeatedTest() {
        System.out.println("Este test se repite");
    }

    @Test
    // TODO 2: Inyecta 'TestReporter' como parámetro de este método
    // y utilízalo para publicar una entrada en el reporte con la clave "status" y el valor "OK".
    void diTest(/* TestReporter reporter */) {
        // ... reporter.publishEntry(...)
    }
}

