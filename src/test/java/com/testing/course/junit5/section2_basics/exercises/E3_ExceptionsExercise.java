package com.testing.course.junit5.section2_basics.exercises;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ejercicio 4: Validando Excepciones Dinámicas.
 * Basado en: Section 5: Testing Java with JUnit 5 - 53.
 * 
 * PISTA: Mira la 'Sección 5' de la clase 'L1_AssertionsTheory' para ver cómo se 
 * usa assertThrows para capturar objetos Excepción de la lógica de servicios.
 */
class E3_ExceptionsExercise {

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerService();
    }

    @Test
    void testExpectedExceptionOnSave() {
        Owner owner = new Owner("", "Zapatero"); // Nombre vacío

        // TODO 1: Comprobar que al llamar a ownerService.save(owner) se lanza una 'IllegalArgumentException'
        // TODO 2: Opcional: Validar que el mensaje de la excepción es "El nombre es obligatorio"
    }

    @Test
    void testExpectedExceptionOnNull() {
        // TODO 3: Usa assertThrows para comprobar que guardar un objeto 'null' lanza excepción.
    }
}

