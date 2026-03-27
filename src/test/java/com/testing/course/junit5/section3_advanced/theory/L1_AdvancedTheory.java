package com.testing.course.junit5.section3_advanced.theory;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: Organización Avanzada y Tests Colectivos</h1>
 * 
 * <p><b>Qué hace:</b> Explora las anotaciones destinadas a estructurar grandes 
 * volúmenes de tests, permitiendo filtrado, anidamiento y ejecución masiva con datos.</p>
 * 
 * <p><b>Por qué existe:</b> A medida que un proyecto crece, los tests unitarios 
 * pierden legibilidad. Estas herramientas permiten agrupar lógica relacionada 
 * y reducir la repetición de código (DRY) mediante fuentes de datos externas.</p>
 * 
 * <h2>Técnicas de Organización:</h2>
 * <ul>
 *   <li><b>@Tag:</b> Clasifica tests para ejecuciones selectivas (ej: <code>mvn test -Dgroups=smoke</code>).</li>
 *   <li><b>@Nested:</b> Agrupa jerárquicamente tests compartiendo un contexto común.</li>
 *   <li><b>@ParameterizedTest:</b> Ejecuta un test N veces con diferentes entradas (CSV, ValueSource).</li>
 * </ul>
 */
@DisplayName("Sección 3 - L1: Jerarquía y Parametrización")
@Tag("smoke")
class L1_AdvancedTheory {

    private final OwnerService ownerService = new OwnerService();

    /**
     * <h2>DEMO: Agrupación en Bloques (@Nested)</h2>
     * <p>Permite crear sub-suites con su propio ciclo de vida <code>@BeforeEach</code>, 
     * mejorando la navegación por el reporte del IDE.</p>
     */
    @Nested
    @DisplayName("🏢 Bloque: Gestión de Persistencia")
    class SavingsTests {
        @Test
        @DisplayName("🧪 Demo 2: Nesting funcional")
        void nestedDemo() {
            ownerService.save(new Owner("Keanu", "Reeves"));
            assertNotNull(ownerService.findByLastName("Reeves"));
        }

        @Test
        @DisplayName("🧪 Demo 2 bis: Nesting funcional 2")
        void nestedDemoBis() {
            ownerService.save(new Owner("Gabi", "Garcia"));
            assertNull(ownerService.findByLastName("Fernandez"));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testEsPar(int numero) {
        assertThat(numero % 2).isZero();
    }

    /**
     * <h2>DEMO: Carga masiva desde CSV</h2>
     * <p>Utilizamos <code>@CsvFileSource</code> para inyectar datos desde un 
     * archivo externo, separando la lógica del test de los datos de prueba.</p>
     */
    @ParameterizedTest(name = "[{index}] Verificando a {0} {1}")
    @CsvFileSource(resources = "/csv/theory_owners.csv", numLinesToSkip = 1)
    @DisplayName("🧪 Demo 3: Inyección desde Fichero CSV")
    void csvFileSourceDemo(String firstName, String lastName) {
        Owner owner = new Owner(firstName, lastName);
        ownerService.save(owner);
        assertNotNull(ownerService.findByLastName(lastName));
    }
}
