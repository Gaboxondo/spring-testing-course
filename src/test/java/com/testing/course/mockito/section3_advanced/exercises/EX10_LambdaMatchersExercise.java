package com.testing.course.mockito.section3_advanced.exercises;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.section3.AdvancedService;
import org.junit.jupiter.api.Disabled;
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
 * <h1>RETO EX10: Argument Matchers con Lambdas (argThat)</h1>
 * 
 * <p>En este reto, validarás una llamada al repositorio usando 
 * un predicado Lambda para comprobar que la descripción tiene 
 * una longitud determinada.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - EX10: Reto argThat (Longitud de Descripción)")
class EX10_LambdaMatchersExercise {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private AdvancedService advancedService;

    @Test
    @Disabled("Ejercicio pendiente de completar")
    @DisplayName("🧪 Reto 1: Verificación con predicado Lambda")
    void testLambdaMatcher() {
        Visit longVisit = new Visit("DESCRIPCIÓN_MUY_LARGA_MAYOR_A_5", null);
        
        // TODO 1: Llama a advancedService.processVisitWithRules(longVisit); 
        // y comprueba que devuelve true.
        
        // --- CÓDIGO A COMPLETAR ---
        
        // TODO 2: Verifica que visitRepository.save fue llamado con una visita que 
        // tenga una descripción de más de 10 caracteres.
        // PISTA: verify(visitRepository).save(argThat(v -> ...));
        
        // --------------------------
    }
}
