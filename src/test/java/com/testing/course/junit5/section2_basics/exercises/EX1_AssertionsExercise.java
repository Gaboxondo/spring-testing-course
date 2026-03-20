package com.testing.course.junit5.section2_basics.exercises;

import com.testing.course.model.Owner;
import com.testing.course.model.Pet;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 1: Aserciones Estándar de JUnit 5.
 * 
 * <p>En este ejercicio practicaremos las aserciones más básicas:
 * assertEquals, assertTrue, assertFalse y assertNotNull.</p>
 */
@Disabled("Ejercicio pendiente de resolver")
class EX1_AssertionsExercise {

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

        // TODO 1: Comprobar que el savedOwner no es nulo usando assertNotNull
        
        // TODO 2: Comprobar que el primer nombre es "Jose" usando assertEquals
        
        // TODO 3: Comprobar que el apellido es "Ruiz" usando assertEquals
    }

    @Test
    void testAddPetSimple() {
        Owner owner = new Owner("Maria", "Perez");
        Pet pet = new Pet("Bobby", "Dog");
        
        ownerService.addPetToOwner(owner, pet);

        // TODO 4: Comprobar usando 'assertTrue' que la lista de mascotas contiene a "Bobby"
        
        // TODO 5: Comprobar usando 'assertFalse' que la lista NO está vacía
    }
}



