package com.testing.course.mockito.section3_advanced.solutions;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * <h1>SOLUCIÓN RETO EX8: La respuesta dinámica (Echo)</h1>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - S8: Solución Answers (Echo API)")
class S8_AnswersSolution {

    @Mock
    private VisitRepository visitRepository;

    @Test
    @DisplayName("🧪 Solución Reto 1: Repository Echo")
    void testEchoAction() {
        // SOLUCIÓN: Usamos thenAnswer(AdditionalAnswers.returnsFirstArg()) 
        // para que devuelva el mismo objeto que recibe.
        when(visitRepository.saveAndReturn(any(Visit.class)))
                .thenAnswer(AdditionalAnswers.returnsFirstArg());

        Visit vis1 = new Visit("Gato", null);
        Visit vis2 = new Visit("Perro", null);

        Visit res1 = visitRepository.saveAndReturn(vis1);
        Visit res2 = visitRepository.saveAndReturn(vis2);

        assertEquals(vis1, res1, "Debe ser el mismo objeto");
        assertEquals(vis2, res2, "Debe ser el mismo objeto");
    }
}
