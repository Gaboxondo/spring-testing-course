package com.testing.course.junit5.section3_advanced.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
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
class E4_ParameterizedExercise {

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
}


