package com.testing.course.mockito.section11_advanced.theory;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

/**
 * TEORÍA SECCIÓN 11: Verificaciones Avanzadas.
 * 
 * Basado en: Section 11 - Lecciones 131, 132, 133.
 * 
 * DETALLE FINO:
 * - InOrder: Garantiza que las llamadas a distintos mocks sigan un orden cronológico exacto.
 * - timeout(t): Bloquea el test hasta que ocurre la interacción o se agota el tiempo (ms).
 * - verifyNoInteractions: Comprueba que el mock NO ha sido tocado en absoluto.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Teoría: Verificaciones Avanzadas")
class MockitoVerificationAdvancedTheory {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Test
    @DisplayName("🧪 Demo 6: Orden de ejecución y Cero interacciones")
    void advancedVerificationDemo() {
        Visit visit1 = new Visit("Vacuna", null);
        Visit visit2 = new Visit("Desparasitación", null);

        // Ejecuciones reales
        visitService.save(visit1);
        visitService.save(visit2);

        // Garantizar el ORDEN de guardado (Section 11 - 131)
        InOrder inOrder = inOrder(visitRepository);
        inOrder.verify(visitRepository).save(visit1);
        inOrder.verify(visitRepository).save(visit2);
        
        // Comprobar que NO hubo más llamadas inesperadas (Section 11 - 133)
        verifyNoMoreInteractions(visitRepository);
    }
}
