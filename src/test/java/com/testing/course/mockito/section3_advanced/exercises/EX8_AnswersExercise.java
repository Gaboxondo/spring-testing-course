package com.testing.course.mockito.section3_advanced.exercises;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import org.junit.jupiter.api.Disabled;
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
 * <h1>RETO EX8: La respuesta dinámica (Echo)</h1>
 * 
 * <p>En este reto, configurarás un repositorio de visitas para que sea 
 * un "espejo" de lo que recibe, usando la API de <code>AdditionalAnswers</code>.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - EX8: Reto Answers (Echo API)")
class EX8_AnswersExercise {

    @Mock
    private VisitRepository visitRepository;

    @Test
    @Disabled("Ejercicio pendiente de completar")
    @DisplayName("🧪 Reto 1: Repository Echo")
    void testEchoAction() {
        // TODO 1: Configurar visitRepository para que saveAndReturn(any()) 
        // devuelva EXACTAMENTE el primer argumento que reciba.
        // PISTA: AdditionalAnswers.returnsFirstArg()
        
        // --- CÓDIGO A COMPLETAR ---
        
        // --------------------------

        // Ejecuciones para validar
        Visit vis1 = new Visit("Gato", null);
        Visit vis2 = new Visit("Perro", null);

        // TODO 2: Llama a saveAndReturn con vis1 y vis2, y comprueba 
        // con assertEquals que el resultado sea el mismo objeto.
        
        // assertEquals(vis1, result1);
        // assertEquals(vis2, result2);
    }
}
