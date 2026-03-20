package com.testing.course.mockito.section3_advanced.theory;

import com.testing.course.util.DateUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Mockeo de Métodos Estáticos en Mockito 3.4+</h1>
 * 
 * <p>Históricamente, Mockito no permitía mockear métodos estáticos (se usaba PowerMock). 
 * A partir de Mockito 3.4, se ha añadido esta funcionalidad oficial.</p>
 * 
 * <h2>Principios Clave:</h2>
 * <ul>
 *   <li><b>MockedStatic:</b> Se usa un objeto `MockedStatic<T>` para interceptar las llamadas.</li>
 *   <li><b>Try-with-resources:</b> El mock estático es un recurso que DEBE cerrarse al finalizar 
 *   el test para evitar contaminar otros tests que usen la misma clase real.</li>
 *   <li><b>Nativo:</b> Desde Mockito 5, ya no hace falta añadir la dependencia `mockito-inline` 
 *   manualmente ya que es la por defecto.</li>
 * </ul>
 * 
 * <p><b>¿Cuándo usarlo?</b> Cuando necesites testear lógica que depende de <code>LocalDateTime.now()</code>, 
 * <code>System.currentTimeMillis()</code> o clases de utilidad estáticas que no puedes inyectar.</p>
 * 
 * @see <a href="https://javadoc.io/static/org.mockito/mockito-core/5.11.0/org/mockito/Mockito.html#static_mocks">Mockito Static Mocks</a>
 */
@DisplayName("Teoría: Mocking de Métodos Estáticos")
class L6_MockStaticTheory {

    /**
     * Ejemplo de cómo mockear LocalDateTime.now() o métodos estáticos de utilidades.
     * <p>En este caso, forzamos a <code>DateUtils.getCurrentTimestamp()</code> a devolver 
     * un valor fijo ("2025-01-01 10:00:00") para que el test sea determinista.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Mocking DateUtils.getCurrentTimestamp")
    void testMockingStaticMethod() {
        String fixedValue = "2025-01-01 10:00:00";

        // Usamos try-with-resources para asegurar el cierre del mock estático
        try (MockedStatic<DateUtils> mockedDateUtils = mockStatic(DateUtils.class)) {
            
            // Programamos el comportamiento
            mockedDateUtils.when(DateUtils::getCurrentTimestamp).thenReturn(fixedValue);

            // Ejecutamos la llamada
            String result = DateUtils.getCurrentTimestamp();

            // Verificamos
            assertEquals(fixedValue, result, "El timestamp debería ser el que forzamos con el mock");
            
            // También podemos verificar que se llamó al método estático
            mockedDateUtils.verify(DateUtils::getCurrentTimestamp, times(1));
        }
        
        // Fuera del try, el comportamiento vuelve a ser el real (dinámico por fecha actual)
        boolean realCallStillWorks = DateUtils.getCurrentTimestamp() != null;
        assertEquals(true, realCallStillWorks);
    }
}
