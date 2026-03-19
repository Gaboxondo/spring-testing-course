package com.testing.course.mockito.section2_advanced.exercises;

import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
import com.testing.course.model.Visit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Ejercicio L8_VerificationAdvancedExercise_VerificationAdvancedExercise_VerificationAdvancedExercise: Verificaciones Cronológicas e Interacciones.
 * 
 * Basado en: Section 2 - L3_VerificationAdvancedTheory.
 * 
 * OBJETIVO: Asegurar que NO hay interacciones en caso de fallo de validación 
 * y comprobar que el orden es correcto.
 */
@ExtendWith(MockitoExtension.class)
class E3_VerificationAdvancedExercise {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Test
    void testNoInteractionsOnValidationError() {
        Visit visit = new Visit("", null); // Descripción vacía -> Fallo validación
        
        // TODO 1: Intenta guardar la visita en el servicio y captura la excepción.
        // TODO 2: Verifica que el mock 'visitRepository' NO ha sido llamado.
        // PISTA: verifyNoInteractions(mock);
    }
}

