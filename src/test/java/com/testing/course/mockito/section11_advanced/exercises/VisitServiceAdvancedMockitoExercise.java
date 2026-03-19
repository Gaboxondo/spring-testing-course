package com.testing.course.mockito.section11_advanced.exercises;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
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
 * Ejercicio Sección 11: Mockito Avanzado.
 * Basado en: Section 11 - Lección 127 y 129 (Assignment).
 * 
 * PISTA: Consulta 'MockitoArgumentCaptureTheory.java' para ver el uso de capturadores.
 *        Consulta 'MockitoExceptionsTheory.java' para manejar errores del repo.
 */
@ExtendWith(MockitoExtension.class)
class VisitServiceAdvancedMockitoExercise {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Captor
    ArgumentCaptor<Visit> visitCaptor;

    @Test
    void testSaveVisitWithCapture() {
        Visit visit = new Visit("Control", null);
        
        // TODO 1: Llamar al servicio visitService.save(visit).
        
        // TODO 2: Capturar el objeto pasado al repositorio.
        // verify(visitRepository).save(visitCaptor.capture());
        
        // TODO 3: Comprobar que la descripción del objeto capturado es "Control".
    }

    @Test
    void testSaveVisitThrowException() {
        Visit visit = new Visit("", null); // Descripción vacía
        
        // TODO 4: Hacer que el visitService lance una RuntimeException al validar.
        // PISTA: No es un mock, es lógica de negocio real del servicio.
        
        // TODO 5: Validar que se lanza RuntimeException con mensaje "Descripción obligatoria".
        // Use assertThrows(...).getMessage();
    }
}
