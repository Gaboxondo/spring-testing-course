package com.gaboxondo.testing.junit5.section6_advanced.solutions;

import com.gaboxondo.testing.model.Owner;
import com.gaboxondo.testing.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución 7: Organización Dinámica con @Tag y @Nested.
 * Basado en: Section 6: Advanced JUnit Testing - 63, 64.
 */
@Tag("smoke")
class TagAndNestedSolution {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    @Tag("creation")
    void testInitialStatus() {
        assertEquals(0, ownerService.getOwnerCount(), "Debería empezar vacío");
    }

    @Nested
    @Tag("persistence")
    class FindingTests {

        @BeforeEach
        void nestSetUp() {
            // Este BeforeEach se ejecuta además del externo
            ownerService.save(new Owner("Jose", "Ruiz"));
        }

        @Test
        void findByLastNameMatch() {
            assertNotNull(ownerService.findByLastName("Ruiz"));
        }

        @Test
        void findByLastNameNoMatch() {
            assertNull(ownerService.findByLastName("Desconocido"));
        }
    }
}
