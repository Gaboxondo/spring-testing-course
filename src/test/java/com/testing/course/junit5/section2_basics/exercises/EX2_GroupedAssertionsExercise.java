package com.testing.course.junit5.section2_basics.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 2: Aserciones Agrupadas y Dependientes Dinámicas.
 * Basado en: Section 5: Testing Java with JUnit 5 - 49, 50.
 *
 * TODO: Utiliza 'assertAll' para validar el comportamiento del OwnerService.
 */
@Disabled("Ejercicio pendiente de resolver")
class EX2_GroupedAssertionsExercise {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    void testGroupedAssertions() {
        Owner owner = new Owner("Beatriz", "Sánchez");
        owner.setCity("Madrid");
        owner.setTelephone("678554443");
        ownerService.save(owner);
        
        Owner saved = ownerService.findByLastName("Sánchez");

        // TODO 1: Usa assertAll para validar el nombre y apellido en una sola llamada de agrupación "Owner Check"
        // assertAll("Owner Test", ...)

        // TODO 2: Usa assertAll para validar la información de contacto (city, telephone) usando sub-agrupaciones (dependent assertions)
    }
}


