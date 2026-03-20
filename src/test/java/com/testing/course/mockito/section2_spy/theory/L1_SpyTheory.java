package com.testing.course.mockito.section2_spy.theory;

import com.testing.course.service.BankAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Introducción a Spies (@Spy) y Partial Mocking</h1>
 * 
 * <p>A diferencia de un Mock (que es una "cáscara vacía"), un Spy es una 
 * <b>instancia real</b> de una clase. Simula un objeto con comportamiento 
 * real pero con la capacidad de ser vigilado (verified) y parcialmente 
 * programado (stubbed).</p>
 * 
 * <h2>Diferencias Clave:</h2>
 * <ul>
 *   <li><b>@Mock:</b> No ejecuta NADA del código real. Métodos devuelven default (null, 0, false).</li>
 *   <li><b>@Spy:</b> Ejecuta el CÓDIGO REAL de todos los métodos a menos que se indique lo contrario.</li>
 * </ul>
 * 
 * <h2>¿Cuándo usar un Spy?</h2>
 * <ul>
 *   <li><b>Código Legado:</b> Cuando queremos testear una clase pero necesitamos mockear un método difícil de aislar.</li>
 *   <li><b>Verificación de Efectos Secundarios:</b> Cuando queremos que el método haga su trabajo real, pero queremos verificar que llamó a otros métodos internos.</li>
 *   <li><b>Partial Mocking:</b> Cuando solo una parte de la clase depende de algo externo.</li>
 * </ul>
 * 
 * <h2>Sintaxis Especial (doReturn/When):</h2>
 * <p>Para Spies, se recomienda la sintaxis <code>doReturn().when(spy).metodo()</code> 
 * en lugar de <code>when(spy.metodo()).thenReturn()</code>. 
 * <br><i>Razón:</i> La versión original intenta llamar al método real <b>antes</b> 
 * de aplicar el mock, lo cual puede romper el test si el método real falla o tiene 
 * efectos secundarios.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - L1: Teoría Fundamental de Spies")
class L1_SpyTheory {

    @Spy
    private BankAccountService bankService = new BankAccountService();

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    /**
     * CASO 1: Verificación de interacción en objeto real.
     * <p>Muestra cómo un Spy permite que el código real se ejecute pero 
     * nos permite verificar que ocurrió una llamada interna.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Verificación sobre código real (Comportamiento por defecto)")
    void verifyRealBehavior() {
        // Ejecutamos código REAL del servicio
        bankService.deposit(new BigDecimal("100"));
        
        // El balance ha cambiado porque el método deposit() es REAL
        assertEquals(new BigDecimal("100"), bankService.getBalance());
        
        // A la vez, podemos verificar que deposit() llamó internamente a auditTransaction()
        verify(bankService).auditTransaction(eq("DEPOSIT"), any());
        
        // Podemos verificar cuántas veces se llamó (importante en Spies)
        verify(bankService, times(1)).auditTransaction(anyString(), any());

        // esto mismo se puede hacer solo con un verify
        verify(bankService, times(1)).auditTransaction(eq("DEPOSIT"), any());
    }

    /**
     * CASO 2: Partial Mocking (Sustituir solo un método).
     * <p>Forzamos que la validación compleja sea siempre falsa. El resto de la clase
     * sigue funcionando con código real.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Stubbing parcial con doReturn")
    void partialMockDemo() {
        // Forzamos fallo de validación sin llamar al código real de validateAccountStatus()
        doReturn(false).when(bankService).validateAccountStatus();

        // Al intentar retirar, fallará por el mock partial
        boolean result = bankService.withdraw(new BigDecimal("50"));
        
        // Assert: El resultado es falso y el balance no ha cambiado
        assertFalse(result, "El retiro debería haber fallado por validación");
        assertEquals(BigDecimal.ZERO, bankService.getBalance());
        
        // Verificamos que se llamó a nuestro mock partial
        verify(bankService).validateAccountStatus();
        // Pero NO se llamó a auditTransaction porque la validación falló antes
        verify(bankService, never()).auditTransaction(anyString(), any());
    }

    /**
     * CASO 3: Espiando Colecciones.
     * <p>Un uso muy común de los Spies es vigilar colecciones reales de Java
     * para verificar interacciones sin perder su lógica interna.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Espiando una Lista real")
    void spyOnList() {
        List<String> list = new ArrayList<>();
        List<String> spyList = spy(list);

        // Añadimos elementos reales
        spyList.add("Mockito");
        spyList.add("Junit");

        // El comportamiento real se mantiene
        assertEquals(2, spyList.size());
        assertEquals("Mockito", spyList.get(0));

        // Pero podemos verificar interacciones
        verify(spyList).add("Mockito");
        verify(spyList).add("Junit");

        // Incluso podemos mockear un método de la lista real
        doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    /**
     * CASO 4: Uso de Captors con Spies.
     * <p>Podemos capturar los argumentos que se pasan a los métodos reales
     * para realizar aserciones más complejas sobre los datos procesados.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: ArgumentCaptor en un Spy")
    void argumentCaptorWithSpy() {
        bankService.deposit(new BigDecimal("250.50"));

        // Capturamos el tipo de transacción que se mandó a auditoría
        verify(bankService).auditTransaction(stringCaptor.capture(), any());

        assertEquals("DEPOSIT", stringCaptor.getValue());
    }

    /**
     * CASO 5: Reiniciando el Spy (reset).
     * <p>A veces necesitamos limpiar las interacciones de un Spy a mitad de un test
     * o entre fases del test. Nota: No se recomienda abusar de esto.</p>
     */
    @Test
    @DisplayName("🧪 Demo 5: Reset de interacciones")
    void resetSpyDemo() {
        bankService.deposit(new BigDecimal("100"));
        verify(bankService).deposit(any());

        // Limpiamos el historial de llamadas del spy
        reset(bankService);

        // Ahora verify dirá que no hubo llamadas, aunque la lógica real YA afectó al estado del objeto
        verify(bankService, never()).deposit(any());
        assertEquals(new BigDecimal("100"), bankService.getBalance(), "El estado interno NO se resetea, solo el historial de Mockito");
    }
}
