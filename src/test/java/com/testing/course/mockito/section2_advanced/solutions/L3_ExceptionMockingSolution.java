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
 * Solución L6: Forzando Excepciones.
 */
@ExtendWith(MockitoExtension.class)
class L3_ExceptionMockingSolution {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Test
    void testSaveVisitDatabaseError() {
        // SOLUCIÓN:
        Visit visit = new Visit("Cita", null);
        doThrow(new RuntimeException("DB Error")).when(visitRepository).save(any());

        assertThrows(RuntimeException.class, () -> {
            visitService.save(visit);
        });
        
        verify(visitRepository).save(any());
    }
}
