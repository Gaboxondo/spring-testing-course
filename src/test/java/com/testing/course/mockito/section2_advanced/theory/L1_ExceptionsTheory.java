package com.testing.course.mockito.section2_advanced.theory;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * TEORÍA SECCIÓN 11: Lanzando Excepciones con Mockito.
 * 
 * Basado en: Section 11 - Lección 125.
 * 
 * DETALLE FINO:
 * - 'doThrow': Se usa cuando el método que queremos "romper" devuelve VOID.
 * - 'thenThrow': Se usa dentro de un 'when(...)' si el método devuelve algo.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Teoría: Mockito Excepciones")
class L1_ExceptionsTheory {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    @Test
    @DisplayName("🧪 Demo 4: Programar error en el repositorio (VOID)")
    void throwExceptionDemo() {
        // Programar que el mock lance una excepción al guardar cualquier visita
        doThrow(new RuntimeException("DB Error")).when(visitRepository).save(any());

        // Validar que el servicio propaga la excepción
        assertThrows(RuntimeException.class, () -> {
            visitService.save(new Visit("Cita", null));
        });
    }
}
