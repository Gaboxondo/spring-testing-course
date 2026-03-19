package com.testing.course.junit5.section5_basics.exercises;

import com.testing.course.model.Owner;
import com.testing.course.model.Pet;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 1: Aserciones Estándar de JUnit 5 con Lógica.
 * Basado en: Section 5: Testing Java with JUnit 5 - 47, 48.
 *
 * PISTA: Consulta 'Section5AssertionsTheory.java' para ejemplos de aserciones dinámicas 
 * con el OwnerService.
 */
class JUnit5AssertionsExercise {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    void testStandardAssertionsWithService() {
        Owner owner = new Owner("Jose", "Ruiz");
        ownerService.save(owner);
        Owner savedOwner = ownerService.findByLastName("Ruiz");

        // TODO 1: Comprobar que el savedOwner no es nulo
        // TODO 2: Comprobar que el primer nombre es "Jose"
        // assertEquals(..., savedOwner.getFirstName());
    }

    @Test
    void testAddPet() {
        Owner owner = new Owner("Maria", "Perez");
        Pet pet = new Pet("Bobby", "Dog");
        
        ownerService.addPetToOwner(owner, pet);

        // TODO 3: Comprobar usando 'assertTrue' que la lista de mascotas contiene a "Bobby"
        // TODO 4: Comprobar usando 'assertFalse' que la lista NO está vacía
    }
}
