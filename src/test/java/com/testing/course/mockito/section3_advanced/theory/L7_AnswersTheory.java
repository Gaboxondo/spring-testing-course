package com.testing.course.mockito.section3_advanced.theory;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * <h1>TEORÍA: La API de Answers (AdditionalAnswers)</h1>
 * 
 * <p>A veces no queremos que un mock devuelva un valor fijo, sino algo dinámico 
 * que dependa de lo que el método reciba. Mockito ofrece la clase 
 * <code>AdditionalAnswers</code> para casos comunes sin escribir lógica personalizada.</p>
 * 
 * <h2>El caso de 'returnsFirstArg()'</h2>
 * <p>En Spring Data (y APIs REST), es muy común que un repositorio reciba un objeto, 
 * lo guarde y lo devuelva de vuelta. Simular esto manualmente para cada objeto 
 * puede ser tedioso:</p>
 * <pre>when(repo.save(obj1)).thenReturn(obj1);</pre>
 * <p>Con <code>returnsFirstArg()</code>, el mock siempre devolverá el primer argumento 
 * que reciba, sin importar cuál sea.</p>
 * 
 * @see <a href="https://javadoc.io/static/org.mockito/mockito-core/latest/org.mockito/AdditionalAnswers.html">AdditionalAnswers Javadoc</a>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L7: Answers API (Resultados Dinámicos)")
class L7_AnswersTheory {

    @Mock
    private VisitRepository visitRepository;

    /**
     * <h2>DEMO: Mockeo dinámico con returnsFirstArg</h2>
     * 
     * <p><b>Qué hace:</b> Configura el repositorio para que cualquier objeto <code>Visit</code> 
     * pasado a <code>saveAndReturn</code> sea el mismo que se devuelva.</p>
     * 
     * <p><b>Por qué es importante:</b> Evita fragilidad en los tests. Si cambias el objeto 
     * en el "Arrange", no necesitas actualizar el stubbing.</p>
     * 
     * <p><b>Cómo se usa:</b> Se usa <code>thenAnswer(AdditionalAnswers.returnsFirstArg())</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Mock de repositorio 'espejo' (Echo)")
    void testReturnsFirstArg() {
        // En lugar de: when(repo.saveAndReturn(visit1)).thenReturn(visit1);
        // Usamos una respuesta dinámica (Answer):
        when(visitRepository.saveAndReturn(any(Visit.class)))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        // Ejecuciones con distintos objetos
        Visit v1 = new Visit("Gato en revisión", null);
        Visit v2 = new Visit("Perro vacunación", null);

        Visit res1 = visitRepository.saveAndReturn(v1);
        Visit res2 = visitRepository.saveAndReturn(v2);

        assertNotNull(res1);
        assertEquals(v1.getDescription(), res1.getDescription(), "Debe devolver el primer objeto");
        assertEquals(v2.getDescription(), res2.getDescription(), "Debe devolver el segundo objeto");
    }
}
