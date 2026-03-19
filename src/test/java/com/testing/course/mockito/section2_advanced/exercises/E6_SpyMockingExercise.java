package com.testing.course.mockito.section2_advanced.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.model.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Ejercicio L16_SpyMockingExercise_SpyMockingExercise_SpyMockingExercise: Uso de Mockito Spies.
 * 
 * Basado en: Section 2 - L4_SpiesTheory.
 * 
 * OBJETIVO: Espiar una instancia real y "pisar" uno de sus métodos.
 */
@ExtendWith(MockitoExtension.class)
@Disabled("Ejercicio pendiente de resolver")
class E6_SpyMockingExercise {

    // TODO 1: Declara un @Spy de la clase 'Owner' inicializado con 'new Owner("Real", "Name")'.

    @Test
    void testSpyBehaviour() {
        // TODO 2: Comprueba con un aserto que owner.getFirstName() devuelve "Real".
        
        // TODO 3: Usa 'doReturn' para que owner.getFirstName() devuelva "Espía".
        // PISTA: doReturn("Espía").when(mock).metodo();
        
        // TODO 4: Comprueba que ahora devuelve "Espía".
    }
}


