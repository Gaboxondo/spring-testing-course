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
 * <h1>TEORÍA: Forzando Excepciones con Mockito</h1>
 * 
 * <p><b>Qué hace:</b> Permite programar un mock para que lance una excepción específica 
 * cuando se invoca uno de sus métodos.</p>
 * 
 * <p><b>Por qué existe:</b> Es fundamental para testear la robustez del sistema 
 * ante fallos controlados, como errores de base de datos (DB offline), falta de 
 * conectividad de red o errores de integridad de datos.</p>
 * 
 * <h2>Sintaxis Recomendada:</h2>
 * <ul>
 *   <li><b>doThrow():</b> Imprescindible para métodos que devuelven <code>void</code> 
 *   o cuando trabajamos con <code>@Spy</code> (para evitar ejecutar el código real).</li>
 *   <li><b>when().thenThrow():</b> Preferible para métodos que devuelven un valor, 
 *   ya que es más legible y ofrece mejores chequeos de tipos en tiempo de compilación.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L1: Mockeando Errores y Excepciones")
class L1_ExceptionsTheory {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitService visitService;

    /**
     * <h2>CASO 1: Forzando error en método void (doThrow)</h2>
     * <p>Utilizamos <code>doThrow</code> porque el método <code>save(Visit)</code> 
     * no devuelve nada y la sintaxis <code>when()</code> no compila.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Error en método void con doThrow()")
    void testVoidMethodException() {
        Visit visit = new Visit("Cita", null);
        
        doThrow(new RuntimeException("DB offline")).when(visitRepository).save(any());

        assertThrows(RuntimeException.class, () -> {
            visitService.save(visit);
        }, "Se debería propagar la excepción configurada");
    }

    /**
     * <h2>CASO 2: Forzando error en método con retorno (thenThrow)</h2>
     * <p>Al devolver un objeto, podemos usar la sintaxis fluida de <code>when</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Error en método con retorno mediante thenThrow()")
    void testReturnMethodException() {
        when(visitRepository.findById(anyLong())).thenThrow(new RuntimeException("No encontrado"));

        assertThrows(RuntimeException.class, () -> {
            visitRepository.findById(123L);
        });
    }
}
