package com.gaboxondo.testing.junit5.section6_advanced.theory;

import com.gaboxondo.testing.model.Owner;
import com.gaboxondo.testing.service.OwnerService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TEORÍA: Sección 6 - Organización y Tests Parametrizados.
 * 
 * En este bloque se explica cómo organizar tests complexes y cómo ejecutar un 
 * mismo test con múltiples entradas de datos de forma elegante.
 */
@DisplayName("Teoría: Organización y Metodología Avanzada")
@Tag("smoke")
class AdvancedJUnit5Theory {

    OwnerService ownerService = new OwnerService();

    @Test
    @Tag("smoke")
    @DisplayName("🧪 Demo 1: Tagging (@Tag)")
    void tagDemo() {
        // Los @Tag se usan para ejecutar conjuntos específicos de tests (excluir o incluir en maven build).
    }

    @Nested
    @Tag("owner-persistence")
    @DisplayName("🏢 Bloque Anidado: Operaciones de Guardado")
    class SavingsTests {
        
        @BeforeEach
        void beforeEachNested() {
            System.out.println("   - Se ejecuta el setUp de la clase interna.");
        }

        @Test
        @DisplayName("🧪 Demo 2: Nesting (@Nested)")
        void nestedDemo() {
            // Un @Nested permite agrupar tests relacionados funcionalmente de forma legible.
            ownerService.save(new Owner("Keanu", "Reeves"));
            assertNotNull(ownerService.findByLastName("Reeves"));
        }
    }

    @ParameterizedTest(name = "{index} => Procesar {0}")
    @ValueSource(strings = {"Ana", "Paco", "Beatriz"})
    @DisplayName("🧪 Demo 3: Parameterized (@ValueSource)")
    void valueSourceDemo(String firstName) {
        // Ejecuta el mismo test para cada valor del array 'strings'.
        assertNotNull(firstName);
    }

    @ParameterizedTest
    @CsvSource({
        "Jose, Ruiz",
        "Ana, Lopez"
    })
    @DisplayName("🧪 Demo 4: Parameterized (@CsvSource)")
    void csvSourceDemo(String firstName, String lastName) {
        // Similar a ValueSource pero acepta múltiples columnas (parámetros).
        Owner owner = new Owner(firstName, lastName);
        ownerService.save(owner);
        assertNotNull(ownerService.findByLastName(lastName));
    }

    @Test
    @DisplayName("🧪 Demo 5: Test DI (Dependency Injection)")
    void diDemo(TestInfo info, TestReporter reporter) {
        // JUnit 5 permite inyectar información del test o reporteadores directamente en el método.
        reporter.publishEntry("Ejecutando test con nombre: ", info.getDisplayName());
    }
}
