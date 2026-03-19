package com.testing.course.mockito.section2_advanced.solutions;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
import org.junit.jupiter.api.DisplayName;
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
 * Solución Sección 11: Mockito Avanzado.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 11: Solución Mockito (VisitService)")
class L6_VisitServiceSolution {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Captor
    ArgumentCaptor<Visit> visitCaptor;

    @Test
    @DisplayName("🧪 Validar captura de visita guardada")
    void testSaveVisitWithCapture() {
        // SOLUCIÓN:
        Visit visit = new Visit("Control", null);
        visitService.save(visit);

        verify(visitRepository).save(visitCaptor.capture());
        
        Visit captured = visitCaptor.getValue();
        assertEquals("Control", captured.getDescription());
    }

    @Test
    @DisplayName("🧪 Validar excepción controlada por el servicio")
    void testSaveVisitThrowException() {
        // SOLUCIÓN: El servicio lanza RuntimeException si la descripción es vacía.
        Visit visit = new Visit("", null); 

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            visitService.save(visit);
        });

        assertEquals("Descripción obligatoria", exception.getMessage());
        
        // El repositorio NUNCA debería haber sido llamado si falla la validación.
        verifyNoInteractions(visitRepository);
    }
}
