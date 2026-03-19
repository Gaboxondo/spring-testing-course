package com.testing.course.mockito.section1_intro.solutions;

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
 * Solución L9: Verificaciones y Argument Matchers.
 */
@ExtendWith(MockitoExtension.class)
class L9_VerificationSolution {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetService vetService;

    @Test
    void testSaveVetVerification() {
        // SOLUCIÓN:
        Vet vet = new Vet("Keanu", "Reeves");
        vetService.save(vet);
        
        verify(vetRepository).save(any(Vet.class));
        verify(vetRepository, times(1)).save(vet);
    }
}
