package com.gaboxondo.testing.junit5.section6_advanced.exercises;

import com.gaboxondo.testing.model.Owner;
import com.gaboxondo.testing.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 7: Organización Dinámica con @Tag y @Nested.
 * Basado en: Section 6: Advanced JUnit Testing - 63, 64.
 *
 * TODO: Utiliza @Tag y @Nested para organizar los tests de búsqueda.
 */
@Tag("smoke")
class TagAndNestedExercise {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    // TODO 1: Añade una etiqueta "@Tag" para identificar este test como 'creation'
    void testInitialStatus() {
        assertEquals(0, ownerService.getOwnerCount());
    }

    // TODO 2: Crea una clase @Nested llamada "FindingTests" para anidar las búsquedas.
    // TODO 3: Añade una etiqueta @Tag("persistence") a la clase anidada.
    
    // class FindingTests { ... }
}
