package com.testing.course.junit5.section3_advanced.solutions;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución 10: Tests Parametrizados Dinámicos.
 * Basado en: Section 6: Advanced JUnit Testing - 71, 73, 74, 76.
 */
class ParameterizedSolution {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @ParameterizedTest(name = "{index} => Procesando Owner con apellido: {0}")
    @ValueSource(strings = {"Zapatero", "Rajoy", "Sánchez", "Aznar"})
    void testValueSourceService(String lastName) {
        // SOLUCIÓN: Usamos @ValueSource para crear y guardar diversos owners de forma masiva.
        Owner owner = new Owner("Test", lastName);
        ownerService.save(owner);
        
        assertNotNull(ownerService.findByLastName(lastName));
    }

    @ParameterizedTest
    @CsvSource({
        "Jose, Ruiz",
        "Ana, Lopez",
        "Maria, Garcia"
    })
    void testCsvSourceService(String firstName, String lastName) {
        // SOLUCIÓN: Validamos creación masiva desde CSV
        Owner owner = new Owner(firstName, lastName);
        ownerService.save(owner);
        
        Owner found = ownerService.findByLastName(lastName);
        assertEquals(firstName, found.getFirstName());
    }

    @ParameterizedTest
    @MethodSource("getOwnerInputs")
    void testMethodSourceService(Owner inputOwner) {
        // SOLUCIÓN: Usamos un flujo de objetos Owner como entrada del test. (Section 6 - 76)
        ownerService.save(inputOwner);
        assertEquals(1, ownerService.getOwnerCount());
    }

    static Stream<Owner> getOwnerInputs() {
        return Stream.of(
            new Owner("Juan", "Valdes"),
            new Owner("Sandra", "Bullock"),
            new Owner("Keanu", "Reeves")
        );
    }
}
