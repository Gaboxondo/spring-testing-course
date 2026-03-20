package com.testing.course.mockito.section3_advanced.solutions;

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
 * <h1>SOLUCIÓN RETO EX10: Argument Matchers con Lambdas (argThat)</h1>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - S10: Solución argThat (Longitud de Descripción)")
class S10_LambdaMatchersSolution {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private AdvancedService advancedService;

    @Test
    @DisplayName("🧪 Solución Reto 1: Verificación con predicado Lambda")
    void testLambdaMatcher() {
        Visit longVisit = new Visit("DESCRIPCIÓN_MUY_LARGA_MAYOR_A_5", null);
        
        // SOLUCIÓN: Llama al servicio que contiene la lógica
        boolean processed = advancedService.processVisitWithRules(longVisit); 

        assertTrue(processed);
        
        // SOLUCIÓN: Usamos argThat para validar la longitud del campo internamente
        verify(visitRepository).save(argThat(v -> 
                v.getDescription() != null && 
                v.getDescription().length() > 10
        ));
    }
}
