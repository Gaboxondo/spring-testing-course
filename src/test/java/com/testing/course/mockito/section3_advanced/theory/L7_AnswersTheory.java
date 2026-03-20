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
 * <h1>TEORÍA: Respuesta Dinámica (AdditionalAnswers)</h1>
 * 
 * <p><b>Qué hace:</b> Permite programar respuestas que dependen dinámicamente de los 
 * argumentos de entrada en lugar de devolver un valor predefinido.</p>
 * 
 * <p><b>Por qué existe:</b> Facilita el stubbing de métodos "Echo" (como repositorios 
 * que devuelven la misma entidad que guardan) o cálculos simples basados en parámetros, 
 * evitando fragmentación en el código de test.</p>
 * 
 * <h2>Función returnsFirstArg():</h2>
 * <p>Es la respuesta más común para simular el comportamiento de persistencia 
 * de Spring Data JPA, devolviendo exactamente el mismo objeto que recibe (ID [0]).</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L7: Answers API (Resultados Dinámicos)")
class L7_AnswersTheory {

    @Mock
    private VisitRepository visitRepository;

    /**
     * <h2>DEMO: Repositorio con comportamiento "Espejo"</h2>
     * <p>Evitamos programar un <code>thenReturn</code> distinto para cada visita, 
     * configurando una regla general dinámica para el repositorio.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Mock dinámico con returnsFirstArg")
    void testReturnsFirstArg() {
        when(visitRepository.saveAndReturn(any(Visit.class)))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        Visit v1 = new Visit("Gato en revisión", null);
        Visit res1 = visitRepository.saveAndReturn(v1);

        assertEquals(v1.getDescription(), res1.getDescription(), "Debe devolver la misma visita recibida");
    }
}
