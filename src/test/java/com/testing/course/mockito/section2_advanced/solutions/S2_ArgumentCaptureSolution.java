package com.testing.course.mockito.section2_advanced.solutions;

import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
import com.testing.course.model.Visit;
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
 * Solución L8: Captura de Argumentos.
 */
@ExtendWith(MockitoExtension.class)
class S2_ArgumentCaptureSolution {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Captor
    ArgumentCaptor<Visit> visitCaptor;

    @Test
    void testSaveVisitCapture() {
        // SOLUCIÓN:
        Visit visit = new Visit("Revisión Anual", null);
        visitService.save(visit);

        verify(visitRepository).save(visitCaptor.capture());
        
        Visit captured = visitCaptor.getValue();
        assertEquals("Revisión Anual", captured.getDescription());
    }
}

