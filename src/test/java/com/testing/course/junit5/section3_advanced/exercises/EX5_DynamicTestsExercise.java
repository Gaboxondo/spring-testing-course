package com.testing.course.junit5.section3_advanced.exercises;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DisplayName;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * <h1>EJERCICIO 5: Construcción de Tests Dinámicos</h1>
 * 
 * <p>El objetivo es implementar un @TestFactory que 
 * genere dinámicamente tests basados en un rango de números.</p>
 * 
 * <p><b>Por qué existe:</b> Para practicar la generación dinámica y 
 * entender la diferencia con los tests parametrizados.</p>
 * 
 * <p><b>Instrucciones:</b> 
 * 1. Quitar el @Disabled.
 * 2. Implementar 'testFactoryNumbers' para que genere 10 tests dinámicos.
 * 3. En cada test, validar que el número sea mayor o igual a 0.</p>
 */
@Disabled("Ejercicio de Dynamic Tests pendiente de completar")
@DisplayName("Ejercicio: Generación Dinámica de Casos")
class EX5_DynamicTestsExercise {

    /**
     * TAREA: Implementa el TestFactory.
     * <p>Usa <code>IntStream.range(0, 10).mapToObj(...)</code> para devolver 
     * un Stream de <code>DynamicTest</code>.</p>
     */
    @TestFactory
    Stream<DynamicTest> testFactoryNumbers() {
        // TODO: Generar 10 tests dinámicos que validen n >= 0
        return null;
    }
}
