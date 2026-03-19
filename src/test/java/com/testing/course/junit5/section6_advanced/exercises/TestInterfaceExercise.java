package com.testing.course.junit5.section6_advanced.exercises;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 8: Interfaces de Test Dinámicas.
 * Basado en: Section 6: Advanced JUnit Testing - 65.
 */
interface MyTestInterface {

    // TODO 1: Crea un método default con @BeforeEach que use TestInfo para imprimir el nombre del test.
}

class InterfaceBasedExercise implements MyTestInterface {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    void testOwnerSaveWithInterface() {
        // Al implementar la interfaz, el log común debería saltar solo.
        ownerService.save(new Owner("Keanu", "Reeves"));
        assertEquals(1, ownerService.getOwnerCount());
    }
}
