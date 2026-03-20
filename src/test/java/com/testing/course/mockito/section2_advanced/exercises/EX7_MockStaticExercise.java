package com.testing.course.mockito.section2_advanced.exercises;

import com.testing.course.util.DateUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>EJERCICIO 7: Mockeo de Métodos Estáticos</h1>
 * 
 * <p>El objetivo es implementar un test que mockee un método 
 * estático de la clase <code>DateUtils</code>.</p>
 * 
 * <p><b>Por qué existe:</b> Para practicar la gestión de mocks 
 * estáticos con <code>MockedStatic</code> y asegurar el determinismo 
 * en tests con fechas actuales.</p>
 * 
 * <p><b>Instrucciones:</b> 
 * 1. Quitar el @Disabled.
 * 2. Mockear <code>DateUtils.getCurrentTimestamp()</code> para que 
 * devuelva siempre "2030-12-31 23:59:59".
 * 3. Ejecutar y validar.</p>
 */
@Disabled("Ejercicio de MockStatic pendiente de resolver")
@DisplayName("Ejercicio: Mockeo Estático de Fechas")
class EX7_MockStaticExercise {

    /**
     * TAREA: Implementa el test con MockStatic.
     * <p>Usa <code>mockStatic(DateUtils.class)</code> dentro de un 
     * bloque try-with-resources.</p>
     */
    @Test
    void testCurrentTimestampIsForced() {
        // TODO: Forzar el timestamp a "2030-12-31 23:59:59"
        // String result = DateUtils.getCurrentTimestamp();
        // assertEquals("2030-12-31 23:59:59", result);
    }
}
