package com.testing.course.junit5.section3_advanced.theory;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DisplayName;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * <h1>TEORÍA: Dynamic Tests (@TestFactory) en JUnit 5</h1>
 * 
 * <p>A diferencia de los métodos anotados con @Test (tests estáticos), los Dynamic Tests 
 * son generados en tiempo de ejecución por un método @TestFactory.</p>
 * 
 * <h2>Principios Clave:</h2>
 * <ul>
 *   <li><b>Flexibilidad:</b> Los tests se generan dinámicamente basándose en datos 
 *   disponibles solo durante la ejecución.</li>
 *   <li><b>Retorno:</b> Un @TestFactory debe devolver un <code>Stream</code>, 
 *   <code>Collection</code>, <code>Iterable</code>, o <code>Iterator</code> de instancias de <code>DynamicNode</code> (normalmente <code>DynamicTest</code>).</li>
 *   <li><b>Ciclo de Vida:</b> A diferencia de @Test, un Dynamic Test no tiene 
 *   métodos @BeforeEach y @AfterEach individuales ejecutándose para cada test dinámico.</li>
 * </ul>
 * 
 * <p><b>¿Cuándo usarlos?</b> Cuando el número o los parámetros exactos del test 
 * no se conocen en tiempo de compilación (p.ej., leer archivos de un directorio y ejecutar un test por cada uno).</p>
 * 
 * @see <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests">JUnit 5 Dynamic Tests</a>
 */
@DisplayName("Teoría: Tests Dinámicos (@TestFactory)")
class L2_DynamicTestsTheory {

    /**
     * Ejemplo básico de creación de tests dinámicos desde una colección.
     * <p>Genera 3 tests dinámicos, cada uno con un nombre diferente.</p>
     * 
     * @return Colección de tests dinámicos.
     */
    @TestFactory
    @DisplayName("🧪 Demo basic Dynamic Tests")
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
            dynamicTest("1st dynamic test", () -> assertTrue(true)),
            dynamicTest("2nd dynamic test", () -> assertTrue(true))
        );
    }

    /**
     * Ejemplo avanzado usando Streams.
     * <p>Permite una generación mucho más elegante y funcional de los tests.</p>
     * 
     * @return Stream de tests dinámicos.
     */
    @TestFactory
    @DisplayName("🧪 Demo Stream of Dynamic Tests")
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of("A", "B", "C")
            .map(str -> dynamicTest("Test para: " + str, () -> {
                System.out.println("Ejecutando lógica dinámica para " + str);
                assertTrue(str.length() > 0);
            }));
    }
}
