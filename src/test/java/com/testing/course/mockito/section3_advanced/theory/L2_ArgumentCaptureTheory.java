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
 * <h1>TEORÍA: Captura de Argumentos (@Captor)</h1>
 * 
 * <p><b>Qué hace:</b> Permite interceptar y "guardar" el objeto real que un mock 
 * recibió durante la ejecución de un test.</p>
 * 
 * <p><b>Por qué existe:</b> A veces <code>any()</code> es demasiado genérico y 
 * <code>eq()</code> demasiado rígido. El <code>ArgumentCaptor</code> nos permite extraer 
 * el objeto y realizar aserciones detalladas de sus campos internos (estado profundo).</p>
 * 
 * <h2>Flujo de Trabajo:</h2>
 * <ol>
 *   <li>Declarar el capturador con <code>@Captor</code> indicando el tipo.</li>
 *   <li>Usar <code>captor.capture()</code> dentro del método <code>verify()</code>.</li>
 *   <li>Extraer el valor con <code>captor.getValue()</code> para aserciones de JUnit.</li>
 * </ol>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L2: Captura de Argumentos con @Captor")
class L2_ArgumentCaptureTheory {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitService visitService;

    @Captor
    private ArgumentCaptor<Visit> visitCaptor;

    /**
     * <h2>DEMO: Inspección profunda de un objeto capturado</h2>
     * <p>Validamos que el servicio, al guardar la visita, no ha modificado 
     * erróneamente la descripción original.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Capturar y validar el objeto recibido")
    void captureDemo() {
        Visit visit = new Visit("Control mensual", null);
        visitService.save(visit);

        // Capturar la instancia real que el servicio pasó al repositorio
        verify(visitRepository).save(visitCaptor.capture());
        
        // Realizar aserciones sobre el estado interno
        Visit captured = visitCaptor.getValue();
        assertEquals("Control mensual", captured.getDescription());
    }
}
