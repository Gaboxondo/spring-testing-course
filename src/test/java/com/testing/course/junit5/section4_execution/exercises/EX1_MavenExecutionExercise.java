package com.testing.course.junit5.section4_execution.exercises;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>Ejercicio: Ejecución Selectiva con Maven Tags</h1>
 *
 * <p>El objetivo de este ejercicio es familiarizarse con el filtrado de ejecución
 * de tests utilizando la anotación {@link Tag} de JUnit 5 combinada con parámetros
 * de la línea de comandos de Maven.</p>
 *
 * <h2>Retos</h2>
 * <ol>
 *   <li>Asignar etiquetas a los tests para clasificarlos por velocidad.</li>
 *   <li>Ejecutar solo un subconjunto de tests desde la terminal.</li>
 *   <li>Generar reportes HTML de la ejecución de forma desatendida.</li>
 * </ol>
 *
 * <h2>Instrucciones Paso a Paso</h2>
 * <ul>
 *   <li><b>Paso 1:</b> Localiza el método <code>testFast</code> y añade la anotación <code>@Tag("fast")</code>.</li>
 *   <li><b>Paso 2:</b> Localiza el método <code>testSlow</code> y añade la anotación <code>@Tag("slow")</code>.</li>
 *   <li><b>Paso 3:</b> Ejecuta el comando <code>mvn test -Dgroups="fast"</code> y verifica que solo se ejecuta el test rápido.</li>
 * </ul>
 *
 * <p><b>Pistas:</b> Consulta la teoría en {@link L1_ExecutionTheory}. El filtrado se realiza
 * mediante los parámetros <i>groups</i> o <i>excludedGroups</i> del Maven Surefire Plugin.</p>
 *
 * @see L1_ExecutionTheory
 */
@Disabled("Pendiente de ser resuelto por el alumno")
class EX1_MavenExecutionExercise {

    /**
     * <h3>Test Rápido (FAST)</h3>
     * <p>Este test debe simular una prueba unitaria ligera e instantánea.</p>
     * <p><b>TODO 1:</b> Añade la etiqueta @Tag("fast") a este método.</p>
     */
    @Test
    void testFast() {
        assertTrue(true);
    }

    /**
     * <h3>Test Lento (SLOW)</h3>
     * <p>Este test debe simular una prueba que requiere carga de contexto o latencia.</p>
     * <p><b>TODO 2:</b> Añade la etiqueta @Tag("slow") a este método.</p>
     */
    @Test
    void testSlow() {
        assertTrue(true);
    }
}



