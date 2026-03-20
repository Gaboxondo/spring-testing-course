package com.testing.course.mockito.section3_advanced.theory;

import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
import com.testing.course.model.Visit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Sección 2 - L1: Mockeando Excepciones.
 * 
 * Mockito permite simular fallos controlados para ver cómo responde nuestro sistema.
 * Es crucial cuando nuestra lógica de negocio debe atrapar errores de infraestructura (DB, Red).
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - L1: Forzando Excepciones")
class L1_ExceptionsTheory {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitService visitService;

    /**
     * ¿Cuándo usar doThrow()?
     * 1. CUANDO EL MÉTODO ES 'void': since when(mock.voidMethod()) no compila.
     * 2. CUANDO TRABAJAS CON @Spy: para evitar llamar al método real antes de atrapar el error.
     */
    @Test
    @DisplayName("🧪 Forzando error en método void con doThrow()")
    void testVoidMethodException() {
        Visit visit = new Visit("Cita", null);
        
        // El repositorio tiene el método void save(Visit).
        // when(visitRepository.save(any())).thenThrow(...) -> ¡ERROR de compilación!
        
        doThrow(new RuntimeException("DB offline")).when(visitRepository).save(any());

        assertThrows(RuntimeException.class, () -> {
            visitService.save(visit);
        }, "Se debería propagar la excepción configurada");
    }

    /**
     * ¿Cuándo usar when().thenThrow()?
     * Cuando el método devuelva ALGO (Objeto, Primitivo, etc.). Es la opción preferída 
     * por ser más legible y ofrecer mayor chequeo de tipos.
     */
    @Test
    @DisplayName("🧪 Forzando error en método con retorno con when().thenThrow()")
    void testReturnMethodException() {
        // El repositorio tiene findById(1L) que devuelve un objeto Visit.
        when(visitRepository.findById(anyLong())).thenThrow(new RuntimeException("No encontrado"));

        assertThrows(RuntimeException.class, () -> {
            visitRepository.findById(123L);
        });
    }
}

