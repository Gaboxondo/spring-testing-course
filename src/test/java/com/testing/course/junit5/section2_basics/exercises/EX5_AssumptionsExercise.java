package com.testing.course.junit5.section2_basics.exercises;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * Ejercicio 6: Asunciones y Tests Condicionales.
 * Basado en: Section 5: Testing Java with JUnit 5 - 55, 56.
 */
@Disabled("Ejercicio pendiente de resolver")
class EX5_AssumptionsExercise {

    @Test
    void testOnlyOnDevelopment() {
        // TODO: Usa 'assumeTrue' para hacer que este test solo continúe si la variable 
        // de entorno "ENV" es igual a "DEV". 
        // Si no es DEV, el test debe abortarse (pero no fallar).
    }

    @Test
    // TODO: Anota este test para que solo se ejecute en sistemas operativos WINDOWS
    void testWindowsOnly() {
        // ... (Este código se basa en funcionalidades del sistema local Windows)
    }
}


