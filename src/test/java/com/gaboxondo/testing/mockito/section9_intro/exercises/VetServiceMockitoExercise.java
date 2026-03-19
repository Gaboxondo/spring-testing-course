package com.gaboxondo.testing.mockito.section9_intro.exercises;

import com.gaboxondo.testing.model.Vet;
import com.gaboxondo.testing.repository.VetRepository;
import com.gaboxondo.testing.service.VetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Ejercicio Sección 9: Empezando con Mockito.
 * Basado en: Section 9 - Lección 109 (Assignment).
 * 
 * PISTA: Consulta 'MockitoAnnotationTheory.java' para ver el uso de @Mock y @InjectMocks.
 */
@ExtendWith(MockitoExtension.class)
class VetServiceMockitoExercise {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetService vetService;

    @Test
    void testFindAllVets() {
        // TODO 1: Programar el mock del repositorio para devolver una lista con 2 veterinarios.
        // when(...).thenReturn(...);

        // TODO 2: Llamar al servicio y capturar el resultado.
        // Collection<Vet> vets = vetService.findAll();

        // TODO 3: Comprobar que el tamaño de 'vets' es 2.
        // TODO 4: Verificar que el mock 'vetRepository' fue llamado exactamente una vez.
    }

    @Test
    void testSaveVet() {
        Vet vet = new Vet("Keanu", "Reeves");
        
        // TODO 5: Llamar a vetService.save(vet).
        // TODO 6: Verificar que vetRepository.save(vet) fue llamado.
    }
}
