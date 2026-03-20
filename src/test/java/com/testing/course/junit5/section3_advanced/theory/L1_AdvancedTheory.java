package com.testing.course.junit5.section3_advanced.theory;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: Organización Avanzada y Tests Parametrizados</h1>
 * 
 * <p>Esta sección aborda técnicas para gestionar suites de tests complejas, 
 * mejorar la legibilidad mediante el anidamiento y optimizar la cobertura 
 * con datos dinámicos.</p>
 * 
 * <h2>Principios Clave:</h2>
 * <ul>
 *   <li><b>@Tag:</b> Permite categorizar tests para ejecuciones selectivas (p.ej. smoke tests). 
 *   Se integra con el <code>maven-surefire-plugin</code> mediante el parámetro <code>-Dgroups</code>.</li>
 *   <li><b>@Nested:</b> Facilita la agrupación jerárquica de tests relacionados funcionalmente. 
 *   Cada clase interna puede tener su propio ciclo de vida (@BeforeEach/@AfterEach).</li>
 *   <li><b>@ParameterizedTest:</b> Reduce drásticamente la duplicación al ejecutar 
 *   el mismo método de test con múltiples conjuntos de datos.</li>
 *   <li><b>Dependency Injection:</b> JUnit 5 permite inyectar metadatos directamente 
 *   en los métodos via <code>TestInfo</code> o <code>TestReporter</code>.</li>
 * </ul>
 * 
 * <p><b>¿Cuándo usar este enfoque?</b> Cuando la lógica de negocio tiene múltiples 
 * estados o variaciones de entrada, o cuando la jerarquía de tests refleja la estructura del dominio.</p>
 * 
 * @see org.junit.jupiter.params.ParameterizedTest
 * @see org.junit.jupiter.api.Nested
 * @since 1.0
 */
@DisplayName("Teoría: Organización y Metodología Avanzada")
@Tag("smoke")
class L1_AdvancedTheory {

    OwnerService ownerService = new OwnerService();

    /**
     * TAREA DEMO 1: Categorización selectiva con @Tag.
     * <p>Muestra cómo etiquetar tests para que puedan ser filtrados 
     * durante la ejecución del build (mvn test -Dgroups="smoke").</p>
     */
    @Test
    @Tag("smoke")
    @DisplayName("🧪 Demo 1: Tagging (@Tag)")
    void tagDemo() {
        // Los @Tag se usan para ejecutar conjuntos específicos de tests (excluir o incluir en maven build).
    }

    /**
     * CLASE ANIDADA: Operaciones de persistencia.
     * <p>Agrupa tests relacionados con el guardado de datos, demostrando 
     * el aislamiento del ciclo de vida en sub-suites.</p>
     */
    @Nested
    @Tag("owner-persistence")
    @DisplayName("🏢 Bloque Anidado: Operaciones de Guardado")
    class SavingsTests {
        
        @BeforeEach
        void beforeEachNested() {
            System.out.println("   - Se ejecuta el setUp de la clase interna.");
        }

        /**
         * TAREA DEMO 2: Organización Jerárquica con @Nested.
         * <p>Demuestra cómo las clases internas pueden validarse de forma aislada 
         * pero manteniendo el contexto de la clase principal.</p>
         */
        @Test
        @DisplayName("🧪 Demo 2: Nesting (@Nested)")
        void nestedDemo() {
            // Un @Nested permite agrupar tests relacionados funcionalmente de forma legible.
            ownerService.save(new Owner("Keanu", "Reeves"));
            assertNotNull(ownerService.findByLastName("Reeves"));
        }
    }

    /**
     * TAREA DEMO 3: Tests Parametrizados Simples (@ValueSource).
     * <p>Muestra cómo ejecutar un test múltiples veces inyectando un 
     * valor diferente en cada iteración desde una fuente de datos básica.</p>
     * 
     * @param firstName Nombre inyectado desde el ValueSource.
     */
    @ParameterizedTest(name = "{index} => Procesar {0}")
    @ValueSource(strings = {"Ana", "Paco", "Beatriz"})
    @DisplayName("🧪 Demo 3: Parameterized (@ValueSource)")
    void valueSourceDemo(String firstName) {
        // Ejecuta el mismo test para cada valor del array 'strings'.
        assertNotNull(firstName);
    }

    /**
     * TAREA DEMO 4: Datos Estructurados con @CsvSource.
     * <p>Demuestra cómo pasar múltiples argumentos a un test parametrizado 
     * utilizando un formato de Comma Separated Values (CSV).</p>
     * 
     * @param firstName Nombre del propietario.
     * @param lastName Apellido del propietario.
     */
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

    /**
     * TAREA DEMO 5: Inyección de Dependencias en Métodos de Test.
     * <p>Muestra el uso de <code>TestInfo</code> y <code>TestReporter</code> para 
     * acceder a metadatos del test y generar logs personalizados.</p>
     * 
     * @param info Contenedor de metadatos del test.
     * @param reporter Interfaz para publicar entradas en el reporte.
     */
    @Test
    @DisplayName("🧪 Demo 5: Test DI (Dependency Injection)")
    void diDemo(TestInfo info, TestReporter reporter) {
        // JUnit 5 permite inyectar información del test o reporteadores directamente en el método.
        reporter.publishEntry("Ejecutando test con nombre: ", info.getDisplayName());
    }
}


