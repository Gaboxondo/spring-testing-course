package com.testing.course.mockito.section3_advanced.solutions;

import com.testing.course.util.DateUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>SOLUCIÓN 7: Mockeo de Métodos Estáticos</h1>
 * 
 * <p>Esta es la solución implementada para el ejercicio 7 
 * usando Mockito 3.4+.</p>
 */
@DisplayName("Solución 7: Mockeo Estático de Fechas")
class S7_MockStaticSolution {

    /**
     * TAREA RESUELTA: Uso correcto de <code>MockedStatic<T></code>.
     * <p>El bloque <code>try-with-resources</code> es el método recomendado 
     * para asegurar el ciclo de vida del mock.</p>
     */
    @Test
    void testCurrentTimestampIsForced() {
        String mockValue = "2030-12-31 23:59:59";
        
        try (MockedStatic<DateUtils> mockedDateUtils = mockStatic(DateUtils.class)) {
            mockedDateUtils.when(DateUtils::getCurrentTimestamp).thenReturn(mockValue);
            
            String result = DateUtils.getCurrentTimestamp();
            
            assertEquals(mockValue, result, "El timestamp debe ser el forzado por el mock");
            mockedDateUtils.verify(DateUtils::getCurrentTimestamp, times(1));
        }
    }
}
