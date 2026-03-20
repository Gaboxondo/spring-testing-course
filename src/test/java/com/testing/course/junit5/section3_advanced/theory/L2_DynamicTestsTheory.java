package com.testing.course.junit5.section3_advanced.theory;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DisplayName;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * <h1>TEORÍA: Tests Dinámicos (@TestFactory)</h1>
 * 
 * <p><b>Qué hace:</b> Permite "fabricar" casos de prueba programáticamente 
 * durante la ejecución del test, en lugar de declararlos de forma estática.</p>
 * 
 * <p><b>Por qué existe:</b> Es indispensable cuando el número o contenido de 
 * los tests depende de fuentes externas volátiles (bases de datos, APIs o archivos) 
 * que solo están disponibles tras el arranque del test.</p>
 * 
 * <h2>Diferencia Crucial:</h2>
 * <p>A diferencia de los tests estándar, los <code>DynamicTests</code> no 
 * ejecutan <code>@BeforeEach</code> ni <code>@AfterEach</code> individualmente 
 * por cada item generado; el ciclo de vida aplica al método fábrica completo.</p>
 */
@DisplayName("Sección 3 - L2: Generación Dinámica de Tests")
class L2_DynamicTestsTheory {

    /**
     * <h2>DEMO: Fabricación desde un Stream de datos</h2>
     * <p>Convertimos una lista de palabras en tests individuales que el motor 
     * de JUnit 5 mostrará de forma desglosada en el informe final.</p>
     */
    @TestFactory
    @DisplayName("🧪 Demo 4: Construcción reactiva de asserts")
    Stream<DynamicTest> simpleDynamicTests() {
        List<String> inputs = Arrays.asList("JUnit", "Mockito", "Spring");

        return inputs.stream()
            .map(input -> dynamicTest("Validando cadena: " + input, () -> {
                assertNotNull(input);
                assertFalse(input.isBlank());
            }));
    }

    /**
     * <h2>DEMO: Agrupación en Contenedores Jerárquicos</h2>
     * <p>Utilizamos <code>dynamicContainer</code> para estructurar los tests 
     * dinámicos en carpetas virtuales dentro del árbol de ejecución.</p>
     */
    @TestFactory
    @DisplayName("📁 Demo 5: Estructura de árbol dinámica")
    Stream<DynamicNode> groupedDynamicTests() {
        return Stream.of("Backend", "Frontend")
            .map(category -> dynamicContainer("Capa: " + category, Stream.of(
                dynamicTest("Smoke Test " + category, () -> assertTrue(true))
            )));
    }
}
