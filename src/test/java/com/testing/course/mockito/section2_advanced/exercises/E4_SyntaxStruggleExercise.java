package com.testing.course.mockito.section2_advanced.exercises;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Ejercicio L11_SyntaxStruggleExercise_SyntaxStruggleExercise_SyntaxStruggleExercise: when().thenReturn() vs doReturn().when().
 * 
 * Basado en: Section 2 - L4_SyntaxStruggleTheory.
 * 
 * OBJETIVO: Evitar que un Spy ejecute el método real durante el stubbing.
 */
@ExtendWith(MockitoExtension.class)
class E4_SyntaxStruggleExercise {

    @Spy
    Vet vetSpy = new Vet("Real", "Vet");

    @Test
    void testStubbingAvoidingRealMethod() {
        // TODO 1: Usa doReturn("Mock").when(...) para que getFirstName() devuelva "Mock".
        // PISTA: No uses when(...).thenReturn(...) o fallará el flujo del Spy real.
        
        // TODO 2: Comprueba que vetSpy.getFirstName() devuelve "Mock".
    }
}

