package com.testing.course.junit5.section4_execution.exercises;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio Sección 7: Ejecución Selectiva con Maven.
 * Basado en: Section 7: Test Execution - 85, 86.
 * 
 * PISTA: Consulta la teoría en 'Section7ExecutionTheory.java' y revisa el bloque 
 * 'maven-failsafe-plugin' configurado en el archivo 'pom.xml'.
 */
class MavenExecutionExercise {

    @Test
    // TODO 1: Añade la etiqueta @Tag("fast") a este test.
    void testFast() {
        assertTrue(true);
    }

    @Test
    // TODO 2: Añade la etiqueta @Tag("slow") a este test.
    void testSlow() {
        assertTrue(true);
    }

    /**
     * COMANDOS A PROBAR EN TERMINAL:
     * 1. mvn test -Dgroups="fast"        -> Debería ejecutar solo testFast.
     * 2. mvn test -DexcludedGroups="slow" -> Debería ejecutar solo testFast.
     * 3. mvn surefire-report:report       -> Genera un reporte HTML en target/site/surefire-report.html.
     */
}
