package com.testing.course.mockito.section1_intro.solutions;

import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import com.testing.course.model.Vet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Solución L7: Mocking Profesional con Anotaciones.
 */
@ExtendWith(MockitoExtension.class)
class L7_AnnotationMockingSolution {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetService vetService;

    @Test
    void testFindAllWithAnnotations() {
        // SOLUCIÓN:
        Vet vet = new Vet("Emma", "Watson");
        when(vetRepository.findAll()).thenReturn(List.of(vet));

        List<Vet> vets = (List<Vet>) vetService.findAll();

        assertEquals(1, vets.size());
        assertEquals("Emma", vets.get(0).getFirstName());
        verify(vetRepository).findAll();
    }
}
