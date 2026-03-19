package com.testing.course.mockito.section9_intro.solutions;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Solución Sección 9: Empezando con Mockito.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 9: Solución Mockito (VetService)")
class VetServiceMockitoSolution {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetService vetService;

    @Test
    @DisplayName("🧪 Validar búsqueda de todos los veterinarios")
    void testFindAllVets() {
        // SOLUCIÓN:
        List<Vet> vetsMockList = List.of(new Vet("Keanu", "Reeves"), new Vet("Tom", "Cruise"));
        when(vetRepository.findAll()).thenReturn(vetsMockList);

        Collection<Vet> vets = vetService.findAll();

        assertEquals(2, vets.size(), "Debería haber 2 veterinarios");
        verify(vetRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("🧪 Validar guardado de veterinario")
    void testSaveVet() {
        // SOLUCIÓN:
        Vet vet = new Vet("Emma", "Watson");
        vetService.save(vet);
        
        verify(vetRepository).save(any(Vet.class));
        verify(vetRepository, times(1)).save(vet);
    }
}
