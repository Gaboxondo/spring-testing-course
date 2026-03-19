package com.testing.course.mockito.section1_intro.solutions;

import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Solución L5: Mocking Manual (Inline).
 */
class S1_ManualMockingSolution {

    @Test
    void testFindAllManual() {
        // SOLUCIÓN:
        VetRepository vetRepository = mock(VetRepository.class);
        VetService vetService = new VetService(vetRepository);
        
        assertNotNull(vetService.findAll(), "La lista no debería ser nula");
        verify(vetRepository).findAll();
    }
}

