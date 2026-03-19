package com.gaboxondo.testing.junit5.section6_advanced.solutions;

import com.gaboxondo.testing.model.Owner;
import com.gaboxondo.testing.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución 8: Interfaces de Test (Test Interfaces) Dinámicas.
 * Basado en: Section 6: Advanced JUnit Testing - 65.
 */
@Tag("interface-tests")
interface MyTestInterface {

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        // SOLUCIÓN: Log común para todos los tests que implementen esta interfaz.
        System.out.println("🚀 [INFO] " + testInfo.getDisplayName() + " - " + testInfo.getTags());
    }
}

class InterfaceBasedSolution implements MyTestInterface {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    void testOwnerSaveWithInterface() {
        ownerService.save(new Owner("Keanu", "Reeves"));
        assertEquals(1, ownerService.getOwnerCount());
    }
}
