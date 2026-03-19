package com.testing.course.mockito.section2_advanced.solutions;

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
 * Solución L10: Verificaciones Cronológicas e Interacciones.
 */
@ExtendWith(MockitoExtension.class)
class L9_VerificationAdvancedSolution {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Test
    void testNoInteractionsOnValidationError() {
        // SOLUCIÓN:
        Visit visit = new Visit("", null); 

        assertThrows(RuntimeException.class, () -> {
            visitService.save(visit);
        });

        // Verificamos que no se llamó al repositorio (Section 2 - L3)
        verifyNoInteractions(visitRepository);
    }
}
