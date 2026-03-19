package com.testing.course.mockito.section2_advanced.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
import com.testing.course.model.Visit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Ejercicio L5_ArgumentCaptureExercise_ArgumentCaptureExercise_ArgumentCaptureExercise: Captura de Argumentos.
 * 
 * Basado en: Section 2 - L2_ArgumentCaptureTheory.
 * 
 * OBJETIVO: Capturar la visita guardada en el repo y validar sus propiedades.
 */
@ExtendWith(MockitoExtension.class)
@Disabled("Ejercicio pendiente de resolver")
class E2_ArgumentCaptureExercise {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    // TODO 1: Declara un ArgumentCaptor para la clase 'Visit' usando @Captor.

    @Test
    void testSaveVisitCapture() {
        Visit visit = new Visit("Revisión Anual", null);
        
        // TODO 2: Llama al servicio save().
        
        // TODO 3: Verifica la llamada al repo y captura el objeto.
        // PISTA: verify(mock).save(captor.capture());
        
        // TODO 4: Comprueba que la descripción capturada es "Revisión Anual".
    }
}


