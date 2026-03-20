package com.testing.course.mockito.section3_advanced.theory;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.section3.AdvancedService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Argument Matchers con Lambdas (argThat)</h1>
 * 
 * <p><b>Qué hace:</b> Permite definir una lógica de validación personalizada para 
 * los argumentos de un método utilizando predicados (funciones booleanas).</p>
 * 
 * <p><b>Por qué existe:</b> Ofrece más flexibilidad que <code>any()</code> y 
 * evita la verbosidad de capturar el argumento con <code>@Captor</code> para realizar 
 * aserciones externas simples.</p>
 * 
 * <h2>Ventajas:</h2>
 * <ul>
 *   <li><b>Legibilidad:</b> La condición de negocio queda incrustada en el verify/when.</li>
 *   <li><b>Poder Predictivo:</b> Puedes validar múltiples propiedades del objeto al mismo tiempo.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L9: Argument Matchers con Lambdas (argThat)")
class L9_LambdaMatchersTheory {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private AdvancedService advancedService;

    /**
     * <h2>DEMO: Verificación mediante reglas de negocio (Lambda)</h2>
     * <p>Comprobamos que el servicio pasó una visita que cumple con la regla 
     * de marcarse como "URGENTE".</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Verificación con predicado Lambda detallado")
    void testLambdaMatcher() {
        Visit seriousVisit = new Visit("URGENTE: Herida grave", null);
        
        advancedService.processVisitWithRules(seriousVisit);

        // Verificamos que se llamó a save() con una visita cuyo texto empiece por URGENTE
        verify(visitRepository).save(argThat(v -> 
                v.getDescription() != null && 
                v.getDescription().startsWith("URGENTE")
        ));
    }
}
