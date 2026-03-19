package com.testing.course.junit5.section3_advanced.exercises;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 7: Organización Dinámica con @Tag y @Nested.
 * Basado en: Section 6: Advanced JUnit Testing - 63, 64.
 * 
 * PISTA: Mira la clase 'AdvancedJUnit5Theory.java' para ver cómo las clases @Nested 
 * heredan propiedades de la clase padre.
 */@Tag("smoke")
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
