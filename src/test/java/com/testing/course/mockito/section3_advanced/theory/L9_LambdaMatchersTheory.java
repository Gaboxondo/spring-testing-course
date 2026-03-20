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
 * <p>En Mockito, <code>any()</code> es a veces demasiado genérico y 
 * <code>eq()</code> demasiado específico. <code>argThat</code> nos permite pasar 
 * un predicado (función booleana) para validar que el argumento cumple 
 * con condiciones de negocio complejas.</p>
 * 
 * <h2>El poder de argThat</h2>
 * <p>En lugar de capturar el argumento con <code>@Captor</code> y luego hacer asertos 
 * fuera del <code>verify</code>, <code>argThat</code> permite validar el estado 
 * interno del objeto JURANTE la verificación o el stubbing.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L9: Argument Matchers con Lambdas (argThat)")
class L9_LambdaMatchersTheory {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private AdvancedService advancedService;

    /**
     * <h2>DEMO: Verificación compleja con predicados</h2>
     * 
     * <p><b>Qué hace:</b> Verifica que se llamó a <code>save</code> con una visita que 
     * tenga una descripción que contenga el texto "URGENTE".</p>
     * 
     * <p><b>Por qué es importante:</b> Es más declarativo y legible que usar un captor. 
     * Combina la aserción con la verificación de la llamada.</p>
     * 
     * <p><b>Cómo se usa:</b> <code>argThat(argument -> argument.getAttr().contains("..."))</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Verificación con predicado Lambda")
    void testLambdaMatcher() {
        Visit seriousVisit = new Visit("URGENTE: Herida grave", null);
        
        // Ejecutamos la lógica que debería llamar al repo
        boolean processed = advancedService.processVisitWithRules(seriousVisit);

        assertTrue(processed);

        // VERIFICACIÓN: No nos vale que guardara CUALQUIER visita (any()).
        // Queremos asegurar que guardó una visita que cumple con nuestras reglas:
        verify(visitRepository).save(argThat(v -> 
                v.getDescription() != null && 
                v.getDescription().startsWith("URGENTE")
        ));
        
        // También funciona para PROGRAMAR comportamientos (Stubbing):
        // when(repo.process(argThat(v -> v.isPriority()))).thenReturn(true);
    }
}
