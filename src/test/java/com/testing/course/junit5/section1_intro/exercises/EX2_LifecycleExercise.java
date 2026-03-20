package com.testing.course.junit5.section1_intro.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio: El Ciclo de Vida de los Tests en JUnit 5.
 * Basado en: Section 4: Getting Started with JUnit 5 - 38.
 * 
 * PISTA: Consulta 'L1_AssertionsTheory.java' para ejemplos de aserciones.
 */
@Disabled("Ejercicio pendiente de resolver")
class EX2_LifecycleExercise {

    OwnerService ownerService;

    // TODO 1: Crea un mï¿½todo con la anotaciï¿½n @BeforeAll para imprimir "Inicio de la suite de tests"
    // Recuerda que el mï¿½todo debe ser ESTï¿½TICO.

    // TODO 2: Crea un mï¿½todo con la anotaciï¿½n @BeforeEach para inicializar 'ownerService'
    // cada vez que se ejecute un test individual.

    @Test
    void testSaveOwner() {
        Owner owner = new Owner("Paco", "Garcï¿½a");
        ownerService.save(owner);
        assertEquals(1, ownerService.getOwnerCount());
    }

    @Test
    void testFindOwner() {
        Owner owner = new Owner("Ana", "Lï¿½pez");
        ownerService.save(owner);
        assertNotNull(ownerService.findByLastName("Lï¿½pez"));
    }

    // TODO 3: Crea un mï¿½todo con la anotaciï¿½n @AfterEach para imprimir "Test completado".
}


