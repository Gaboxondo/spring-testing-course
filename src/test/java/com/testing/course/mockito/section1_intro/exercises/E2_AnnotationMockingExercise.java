package com.testing.course.mockito.section1_intro.exercises;


import org.junit.jupiter.api.Disabled;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import com.testing.course.model.Vet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Ejercicio L6: Mocking Profesional con Anotaciones.
 * 
 * Basado en: Section 1 - L2_AnnotationTheory.
 * 
 * OBJETIVO: Dejar de inyectar manualmente para usar @Mock y @InjectMocks.
 */
@ExtendWith(MockitoExtension.class)
@Disabled("Ejercicio pendiente de resolver")
class E2_AnnotationMockingExercise {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetService vetService;

    @Test
    void testFindAllWithAnnotations() {
        // TODO 1: Crea un objeto de tipo Vet.
        // TODO 2: Programa el mock 'vetRepository' para que al llamar a findAll() devuelva una lista con ese veterinario.
        // PISTA: when(mock.metodo()).thenReturn(lista);
        
        // TODO 3: Llama al servicio vetService.findAll() y comprueba que tiene 1 elemento.
    }
}


