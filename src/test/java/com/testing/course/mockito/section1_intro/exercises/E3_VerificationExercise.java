package com.testing.course.mockito.section1_intro.exercises;

import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import com.testing.course.model.Vet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Ejercicio L8: Verificaciones y Argument Matchers.
 * 
 * Basado en: Section 1 - L3_VerificationTheory.
 * 
 * OBJETIVO: Asegurar que las llamadas ocurren exactamente N veces.
 */
@ExtendWith(MockitoExtension.class)
class E3_VerificationExercise {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetService vetService;

    @Test
    void testSaveVetVerification() {
        Vet vet = new Vet("Keanu", "Reeves");
        
        // TODO 1: Llama a vetService.save(vet).
        
        // TODO 2: Verifica que el repositorio llamó a save() con cualquier objeto Vet.
        // PISTA: verify(mock).save(any(Clase.class));
        
        // TODO 3: Verifica que llamó a save() una única vez.
        // PISTA: verify(mock, times(1)).metodo(...);
    }
}

