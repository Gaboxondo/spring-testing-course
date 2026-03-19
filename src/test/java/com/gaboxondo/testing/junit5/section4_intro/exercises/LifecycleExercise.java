package com.gaboxondo.testing.junit5.section4_intro.exercises;

import com.gaboxondo.testing.model.Owner;
import com.gaboxondo.testing.service.OwnerService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio: El Ciclo de Vida de los Tests en JUnit 5.
 * Basado en: Section 4: Getting Started with JUnit 5 - 38.
 * 
 * PISTA: Consulta 'Section5AssertionsTheory.java' para ejemplos de aserciones.
 */
class LifecycleExercise {

    OwnerService ownerService;

    // TODO 1: Crea un método con la anotación @BeforeAll para imprimir "Inicio de la suite de tests"
    // Recuerda que el método debe ser ESTÁTICO.

    // TODO 2: Crea un método con la anotación @BeforeEach para inicializar 'ownerService'
    // cada vez que se ejecute un test individual.

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

    // TODO 3: Crea un método con la anotación @AfterEach para imprimir "Test completado".
}
