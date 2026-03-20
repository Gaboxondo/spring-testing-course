package com.testing.course.mockito.section3_advanced.theory;

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
 * TEORÍA SECCIÓN 11: Captura de Argumentos con Mockito.
 * 
 * Basado en: Section 11 - Lección 129.
 * 
 * DETALLE FINO:
 * - 'ArgumentCaptor': Permite capturar el valor REAL que un mock recibió 
 *   durante la ejecución para realizar aserciones sobre sus propiedades internas.
 * - @Captor: Anotación para declarar el capturador de forma elegante.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Teoría: Mockito Argument Capture")
class L2_ArgumentCaptureTheory {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Captor
    ArgumentCaptor<Visit> visitCaptor;

    @Test
    @DisplayName("🧪 Demo 5: Capturar y validar el objeto recibido")
    void captureDemo() {
        // Ejecutar proceso real
        Visit visit = new Visit("Control mensual", null);
        visitService.save(visit);

        // Capturar lo que recibió el mock al llamar a 'save'
        verify(visitRepository).save(visitCaptor.capture());
        
        // Obtener el valor capturado y lanzar aserciones profundas
        Visit captured = visitCaptor.getValue();
        assertEquals("Control mensual", captured.getDescription());
    }
}

