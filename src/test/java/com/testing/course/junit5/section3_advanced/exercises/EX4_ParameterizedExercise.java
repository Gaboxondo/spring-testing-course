package com.testing.course.junit5.section3_advanced.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 10: Tests Parametrizados Dinámicos.
 * Basado en: Section 6: Advanced JUnit Testing - 71, 73, 74, 76.
 *
 * PISTA: Consulta 'L1_AdvancedTheory.java' para ver ejemplos de @CsvSource y 
 * @MethodSource (Section 6 - Lección 76).
 */
@Disabled("Ejercicio pendiente de resolver")
class EX4_ParameterizedExercise {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @ParameterizedTest
    // TODO 1: Usa @ValueSource con una lista de nombres de pila para crear Owners.
    void testValueSourceService(String firstName) {
        assertTrue( true );
        // ... (Tu código aquí)
    }

    @ParameterizedTest
    // TODO 2: Usa @CsvSource con pares "nombre, apellido" para guardar múltiples Owners.
    void testCsvSourceService(String firstName, String lastName) {
        assertTrue( true );
        // ... (Tu código aquí)
    }

    @ParameterizedTest
    // TODO 3: Usa @MethodSource apuntando al método 'getOwnerInputs' de abajo.
    void testMethodSourceService(Owner inputOwner) {
        assertTrue( true );
        // ... (Tu código aquí)
    }

    static Stream<Owner> getOwnerInputs() {
        return Stream.of(
            new Owner("Cristiano", "Ronaldo"),
            new Owner("Leo", "Messi")
        );
    }

    /**
     * TAREA: Implementar un test parametrizado que cargue el fichero
     * 'exercise_owners.csv' y valide la integridad de los datos inyectados.
     *
     * <p>El CSV tiene 4 columnas: firstName, lastName, city, telephone.</p>
     */
    @ParameterizedTest(name = "[{index}] Procesando: {0} {1} de {2}")
    @Disabled("Deshabilitado: Implementar lógica del ejercicio en S6")
    @CsvFileSource(resources = "/csv/exercise_owners.csv", numLinesToSkip = 1)
    @DisplayName("🧪 Test: Validación Masiva de Owners")
    void testMassiveOwnerLoad(String firstName, String lastName, String city, String telephone) {
        // TODO: Implementar lógica de guardado y aserciones múltiples.
        // 1. Crear Owner y setear campos city y telephone.
        // 2. Guardar en ownerService.
        // 3. Recuperar y validar integridad total de campos.
        // 4. Validar que el telefono no sea nulo.
    }
}


