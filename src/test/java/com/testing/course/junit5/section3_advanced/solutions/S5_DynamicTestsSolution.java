package com.testing.course.junit5.section3_advanced.solutions;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DisplayName;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * <h1>SOLUCIÓN 5: Construcción de Tests Dinámicos</h1>
 * 
 * <p>Esta es la solución del ejercicio 5 propuesto.</p>
 */
@DisplayName("Solución 5: Generación Dinámica de Casos")
class S5_DynamicTestsSolution {

    /**
     * TAREA RESUELTA: Implementación del TestFactory.
     * <p>Muestra cómo generar tests basados en un rango de forma funcional.</p>
     * 
     * @return Stream de tests dinámicos.
     */
    @TestFactory
    Stream<DynamicTest> testFactoryNumbers() {
        return IntStream.range(0, 10).mapToObj(n -> 
            dynamicTest("Validando número: " + n, () -> {
                assertTrue(n >= 0, "El número " + n + " debe ser mayor o igual a 0");
            })
        );
    }
}
