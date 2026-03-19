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
 * Basado en: Section 6 - Lecciones 63 a 76.
 * 
 * DETALLE FINO:
 * - @Nested: Las clases internas no estáticas pueden compartir atributos con la 
 *   clase externa. Cada clase anidada puede tener su propio @BeforeEach.
 * - @ParameterizedTest: Reduce la duplicación de código permitiendo pasar una 
 *   matriz de datos a un solo método de test de forma automatizada.
 * 
 * REFERENCIAS:
 * - Mira en README.md los comandos para filtrar por @Tag (mvn test -Dgroups="smoke").
 * - El plugin responsable de esto es el 'maven-surefire-plugin' configurado en la 
 *   sección <build><plugins> del 'pom.xml'.
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
