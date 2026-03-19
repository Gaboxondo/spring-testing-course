package com.testing.course.mockito.section1_intro.exercises;

import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Ejercicio L4: Mocking Manual (Inline).
 * 
 * Basado en: Section 1 - L1_IntroTheory (Inline).
 * 
 * OBJETIVO: Aprender a usar mock() e inyectar dependencias manualmente sin anotaciones.
 */
class E1_ManualMockingExercise {

    @Test
    void testFindAllManual() {
        // TODO 1: Crea un mock de VetRepository usando mock()
        // TODO 2: Inicializa VetService pasándole el mock creado (Inyección manual)
        // TODO 3: Ejecuta vetService.findAll() y comprueba que no sea nulo.
    }
}

