package com.testing.course.junit5.section1_intro.solutions;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución: El Ciclo de Vida de los Tests en JUnit 5.
 * Basado en: Section 4: Getting Started with JUnit 5 - 38.
 */
class L5_LifecycleSolution {

    OwnerService ownerService;

    @BeforeAll
    static void beforeAllTests() {
        // SOLUCIÓN: Este método se ejecuta UNA sola vez al principio de la suite.
        System.out.println("🚀 Inicio de la suite de tests L5_LifecycleSolution");
    }

    @BeforeEach
    void setUp() {
        // SOLUCIÓN: Este método inicializa el servicio antes de CADA test individual.
        ownerService = new OwnerService();
        System.out.println("  - Antes del test individual");
    }

    @Test
    void testSaveOwner() {
        Owner owner = new Owner("Paco", "García");
        ownerService.save(owner);
        assertEquals(1, ownerService.getOwnerCount());
    }

    @Test
    void testFindOwner() {
        Owner owner = new Owner("Ana", "López");
        ownerService.save(owner);
        assertNotNull(ownerService.findByLastName("López"));
    }

    @AfterEach
    void tearDown() {
        // SOLUCIÓN: Limpiar o imprimir log después de cada test.
        System.out.println("  - Test completado");
    }

    @AfterAll
    static void afterAllTests() {
        // SOLUCIÓN: Se ejecuta al final de todo.
        System.out.println("🏁 Fin de la suite de tests L5_LifecycleSolution");
    }
}
