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
 * <h1>TEORÍA: Mocking de Constructores (new Object())</h1>
 * 
 * <p>A menudo nos topamos con código (especialmente legado) donde se instancian 
 * objetos internamente mediante el operador <code>new</code>. Esto hace que sea 
 * imposible inyectar un mock de forma tradicional mediante el constructor.</p>
 * 
 * <h2>MockedConstruction al rescate</h2>
 * <p>Desde Mockito 3.5.0, existe <code>MockedConstruction<T></code>. 
 * Esta API intercepta CUALQUIER llamada al constructor de una clase específica 
 * durante la ejecución del test y devuelve un mock en su lugar.</p>
 * 
 * @see <a href="https://javadoc.io/static/org.mockito/mockito-core/5.11.0/org/mockito/Mockito.html#mock_construction">Mockito Mocked Construction</a>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L8: Mocking de Constructores (Internal New)")
class L8_MockedConstructionTheory {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private AdvancedService advancedService;

    /**
     * <h2>DEMO: Interceptando el 'new' de ExternalReportGenerator</h2>
     * 
     * <p><b>Qué hace:</b> Cuando <code>handleInternalCreation</code> hace 
     * <code>new ExternalReportGenerator()</code>, Mockito interviene y 
     * entrega un objeto simulado.</p>
     * 
     * <p><b>Por qué es importante:</b> Es el "último recurso" si no podemos 
     * refactorizar el código de producción para usar inyección de dependencias.</p>
     * 
     * <p><b>Cómo se usa:</b> Mediante <code>try (MockedConstruction<T> mocked = mockConstruction(Clase.class))</code>. 
     * IMPORTANTE: Siempre usar try-with-resources para liberar el hook del constructor al final del test.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Mock de objeto creado internamente con 'new'")
    void testMockedConstruction() {
        Visit visit = new Visit("Chequeo Anual", null);

        // Activamos el hook sobre el constructor de ExternalReportGenerator
        try (MockedConstruction<ExternalReportGenerator> mocked = mockConstruction(ExternalReportGenerator.class)) {
            
            // Cada 'new ExternalReportGenerator()' que ocurra AQUÍ DENTRO 
            // será interceptado. Mockito guardará los mocks creados en 'mocked.constructed()'.
            
            // Ejecutamos el método que tiene el 'new' oculto
            String result = advancedService.handleInternalCreation(visit);

            // Obtenemos el mock que Mockito inyectó en el 'new' (el primero, index 0)
            ExternalReportGenerator generatorMock = mocked.constructed().get(0);
            
            // Podemos programar el mock capturado (o Mockito generará uno por defecto)
            // Por defecto los mocks devuelven null, por eso el resultado sería null
            // a menos que Mockito genere un valor por defecto.
            
            // Verificamos interacciones en el objeto interno que 'no podíamos ver'
            verify(generatorMock).generate(visit);
        }
        
        // Fuera del bloque try, el hook desaparece y 'new' vuelve a ser real.
    }
}
