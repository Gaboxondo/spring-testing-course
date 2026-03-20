package com.testing.course.mockito.section3_advanced.solutions;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.section3.AdvancedService;
import com.testing.course.service.section3.ExternalReportGenerator;
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
 * <h1>SOLUCIÓN RETO EX9: Interceptando el 'new' oculto</h1>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - S9: Solución de Constructores (External Generator)")
class S9_MockedConstructionSolution {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private AdvancedService advancedService;

    @Test
    @DisplayName("🧪 Solución Reto 1: Mock de constructor de ExternalReportGenerator")
    void testMockedConstruction() {
        Visit basicVisit = new Visit("Gato en recuperación", null);

        // SOLUCIÓN: Usamos MockedConstruction para capturar el 'new' 
        // y poder interactuar con el mock generado.
        try (MockedConstruction<ExternalReportGenerator> mocked = mockConstruction(ExternalReportGenerator.class)) {
            
            // Ejecutamos la lógica de producción que hace el 'new' internamente
            advancedService.handleInternalCreation(basicVisit);

            // Obtenemos el mock que Mockito inyectó en el operador 'new'
            ExternalReportGenerator generatorMock = mocked.constructed().get(0);
            
            // Verificamos que se llamó al método del generador mockeado
            verify(generatorMock).generate(basicVisit);
        }
    }
}
