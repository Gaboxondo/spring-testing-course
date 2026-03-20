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
 * <p><b>Qué hace:</b> Un <code>@Spy</code> crea una instancia real de una clase 
 * permitiendo que sus métodos conserven su comportamiento original, mientras 
 * Mockito rastrea (rastrea) las interacciones.</p>
 * 
 * <p><b>Por qué existe:</b> A diferencia de un @Mock (que es una "cáscara vacía"), 
 * un Spy es útil cuando queremos ejecutar código real pero necesitamos interceptar 
 * o verificar llamadas internas específicas (Partial Mocking).</p>
 * 
 * <h2>Diferencias Clave:</h2>
 * <ul>
 *   <li><b>@Mock:</b> No ejecuta NADA del código real. Métodos devuelven tipos por defecto (null, 0).</li>
 *   <li><b>@Spy:</b> Ejecuta el CÓDIGO REAL de todos los métodos a menos que se haga un stubbing específico.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - L1: Teoría Fundamental de Spies")
class L1_SpyTheory {

    @Spy
    private BankAccountService bankService = new BankAccountService();

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    /**
     * <h2>CASO 1: Verificación de interacción en objeto real</h2>
     * <p><b>Qué hace:</b> Muestra que el Spy conserva el estado interno y permite 
     * verificar que un método llamó a otro colaborador interno.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Verificación sobre código real")
    void verifyRealBehavior() {
        // Ejecutamos código REAL
        bankService.deposit(new BigDecimal("100"));
        
        // El balance cambia realmente (estado mutado)
        assertEquals(new BigDecimal("100"), bankService.getBalance());
        
        // Verificamos que se auditó la transacción (llamada colateral)
        verify(bankService).auditTransaction(eq("DEPOSIT"), any());
    }

    /**
     * <h2>CASO 2: Partial Mocking (Sustitución selectiva)</h2>
     * <p><b>Qué hace:</b> Sustituye la lógica de un método problemático 
     * (validación externa) manteniendo el resto de la clase real.</p>
     * <p><b>Cómo se usa:</b> Es vital usar <code>doReturn().when(spy)...</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Stubbing parcial con doReturn")
    void partialMockDemo() {
        // Forzamos fallo de validación sin llamar al código real de validateAccountStatus()
        doReturn(false).when(bankService).validateAccountStatus();

        boolean result = bankService.withdraw(new BigDecimal("50"));
        
        assertFalse(result, "El retiro debería haber fallado por validación");
        assertEquals(BigDecimal.ZERO, bankService.getBalance());
        
        verify(bankService).validateAccountStatus();
        verify(bankService, never()).auditTransaction(anyString(), any());
    }

    /**
     * <h2>CASO 3: Espiando Colecciones de Java</h2>
     * <p><b>Qué hace:</b> Permite vigilar interacciones con tipos estándar como <code>ArrayList</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Espiando una Lista real")
    void spyOnList() {
        List<String> list = new ArrayList<>();
        List<String> spyList = spy(list);

        spyList.add("Mockito");
        spyList.add("Junit");

        assertEquals(2, spyList.size());
        verify(spyList).add("Mockito");

        // Podemos falsear un método de la lista real si es necesario
        doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    /**
     * <h2>CASO 4: El peligro de 'when' en Spies</h2>
     * <p><b>Advertencia:</b> Usar <code>when(spy.metodo()).thenReturn(...)</code> 
     * lanzará la ejecución REAL del método antes de que Mockito pueda interceptarlo.</p>
     */
    // (Demostrado en L2_AdvancedSpyTheory)

    /**
     * <h2>CASO 5: Reset de Spies</h2>
     * <p><b>Qué hace:</b> Limpia el historial de llamadas registradas por Mockito 
     * pero NO restaura el estado interno del objeto real.</p>
     */
    @Test
    @DisplayName("🧪 Demo 5: Reset de interacciones")
    void resetSpyDemo() {
        bankService.deposit(new BigDecimal("100"));
        verify(bankService).deposit(any());

        // Limpiamos historial de Mockito
        reset(bankService);

        verify(bankService, never()).deposit(any());
        assertEquals(new BigDecimal("100"), bankService.getBalance(), "El balance real NO se borra");
    }
}
