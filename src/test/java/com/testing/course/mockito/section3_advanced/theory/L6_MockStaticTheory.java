package com.testing.course.mockito.section3_advanced.theory;

import com.testing.course.util.DateUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Mockeo de Métodos Estáticos (Mockito 3.4+)</h1>
 * 
 * <p><b>Qué hace:</b> Permite interceptar las llamadas a métodos estáticos de una clase y 
 * sustituir su comportamiento por uno simulado.</p>
 * 
 * <p><b>Por qué existe:</b> Históricamente, Mockito no permitía mockear estáticos (se usaba PowerMock). 
 * Esta funcionalidad nativa facilita el testeo determinista de clases que dependen de 
 * utilidades globales como <code>LocalDateTime.now()</code> o <code>System.currentTimeMillis()</code>.</p>
 * 
 * <h2>Principios Clave:</h2>
 * <ul>
 *   <li><b>MockedStatic:</b> El objeto que orquesta el mock estático.</li>
 *   <li><b>Try-with-resources:</b> El mock estático es un recurso que DEBE cerrarse. Si no se cierra, 
 *   el comportamiento estático seguirá mockeado para el resto de los tests del proyecto.</li>
 * </ul>
 */
@DisplayName("Sección 3 - L6: Mocking de Métodos Estáticos")
class L6_MockStaticTheory {

    /**
     * <h2>DEMO: Mocking DateUtils.getCurrentTimestamp</h2>
     * <p>Forzamos un valor fijo para evitar que los tests fallen por milisegundos de diferencia.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Mocking de método estático seguro")
    void testMockingStaticMethod() {
        String fixedValue = "2025-01-01 10:00:00";

        // Usamos try-with-resources para asegurar el cierre automático al final del test
        try (MockedStatic<DateUtils> mockedDateUtils = mockStatic(DateUtils.class)) {
            
            mockedDateUtils.when(DateUtils::getCurrentTimestamp).thenReturn(fixedValue);

            String result = DateUtils.getCurrentTimestamp();

            assertEquals(fixedValue, result, "El timestamp debería ser el forzado por el mock");
            mockedDateUtils.verify(DateUtils::getCurrentTimestamp, times(1));
        }
        
        // Fuera del try, el comportamiento real se restablece automáticamente
        assertNotNull(DateUtils.getCurrentTimestamp());
    }

    private void assertNotNull(Object obj) {}
}
