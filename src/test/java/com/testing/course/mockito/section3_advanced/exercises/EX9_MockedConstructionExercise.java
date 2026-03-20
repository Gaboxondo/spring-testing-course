package com.testing.course.mockito.section3_advanced.exercises;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.section3.AdvancedService;
import com.testing.course.service.section3.ExternalReportGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>RETO EX9: Interceptando el 'new' oculto</h1>
 * 
 * <p>En este reto, interceptarás la instanciación interna de 
 * <code>ExternalReportGenerator</code> que ocurre dentro de 
 * <code>advancedService.handleInternalCreation</code>.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - EX9: Reto de Constructores (External Generator)")
class EX9_MockedConstructionExercise {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private AdvancedService advancedService;

    @Test
    @Disabled("Ejercicio pendiente de completar")
    @DisplayName("🧪 Reto 1: Mock de constructor de ExternalReportGenerator")
    void testMockedConstruction() {
        Visit basicVisit = new Visit("Gato en recuperación", null);

        // TODO 1: Activar el hook de Mockito sobre el constructor de 
        // ExternalReportGenerator usando MockedConstruction.
        // PISTA: try (MockedConstruction<ExternalReportGenerator> mocked = ...)
        
        // --- CÓDIGO A COMPLETAR (AQUÍ DENTRO) ---
        
        // TODO 2: Ejecutar advancedService.handleInternalCreation(basicVisit);
        
        // TODO 3: Verificar que el objeto instanciado (mock) llamó a 'generate(basicVisit)'.
        // PISTA: mocked.constructed().get(0)
        
        // ----------------------------------------
    }
}
