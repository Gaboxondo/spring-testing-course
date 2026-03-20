package com.testing.course.mockito.section2_advanced.exercises;


import org.junit.jupiter.api.Disabled;
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
 * Ejercicio L2_ExceptionMockingExercise_ExceptionMockingExercise_ExceptionMockingExercise: Forzando Excepciones.
 * 
 * Basado en: Section 2 - L1_ExceptionsTheory.
 * 
 * OBJETIVO: Simular un fallo en el repositorio al guardar una visita.
 */
@ExtendWith(MockitoExtension.class)
@Disabled("Ejercicio pendiente de resolver")
class EX1_ExceptionMockingExercise {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Test
    void testSaveVisitDatabaseError() {
        Visit visit = new Visit("Cita", null);
        
        // TODO 1: Haz que el mock 'visitRepository' lance una RuntimeException("DB Error") al llamar a save().
        // PISTA: doThrow(...).when(mock).metodo(...);
        
        // TODO 2: Lanza el test y comprueba usando 'assertThrows' que se propaga la excepción.
    }
}


