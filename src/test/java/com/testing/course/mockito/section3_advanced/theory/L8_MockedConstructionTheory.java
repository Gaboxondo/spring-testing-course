package com.testing.course.mockito.section3_advanced.theory;

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
 * <h1>TEORÍA: Mocking de Constructores (Interceptación de 'new')</h1>
 * 
 * <p><b>Qué hace:</b> Intercepta cualquier instanciación mediante el operador 
 * <code>new</code> de una clase específica durante un hilo de ejecución dado.</p>
 * 
 * <p><b>Por qué existe:</b> Es la solución definitiva para testear <b>código legado</b> 
 * o arquitecturas rígidas donde las dependencias no se inyectan, sino que se crean 
 * localmente dentro de los métodos del servicio.</p>
 * 
 * <h2>Consideraciones de Seguridad:</h2>
 * <p>Debido a que altera el comportamiento global de la JVM en el hilo actual, 
 * debe usarse siempre dentro de un bloque <code>try-with-resources</code> para 
 * garantizar que el hook se libere al finalizar el test.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L8: Mocking de Constructores (MockedConstruction)")
class L8_MockedConstructionTheory {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private AdvancedService advancedService;

    /**
     * <h2>DEMO: Capturando la creación de ExternalReportGenerator</h2>
     * <p>El servicio principal instancia el generador internamente. Aquí lo 
     * interceptamos para extraer el mock creado y realizar verificaciones.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Interceptar el 'new' oculto en el servicio")
    void testMockedConstruction() {
        Visit visit = new Visit("Chequeo Anual", null);

        try (MockedConstruction<ExternalReportGenerator> mocked = mockConstruction(ExternalReportGenerator.class)) {
            
            advancedService.handleInternalCreation(visit);

            // Extraemos el mock que fue inyectado automáticamente en el operador 'new'
            ExternalReportGenerator generatorMock = mocked.constructed().get(0);
            
            verify(generatorMock).generate(visit);
        }
    }
}
