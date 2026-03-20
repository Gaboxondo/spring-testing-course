package com.testing.course.mockito.section2_spy.exercises;

import com.testing.course.service.BankAccountService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

/**
 * <h1>EJERCICIO: Test de Código Legado con Side-Effects</h1>
 * 
 * <p>Objetivo: Testear el método <code>deposit</code> de <code>BankAccountService</code>. 
 * Queremos que la lógica de balance funcione REALMENTE, pero queremos mockear 
 * el sistema de auditoría (que simula ser pesado o externo) y verificar 
 * que se le pasan los parámetros correctos.</p>
 * 
 * <h2>Requisitos del ejercicio:</h2>
 * <ol>
 *   <li>Usa un <b>@Spy</b> sobre <code>BankAccountService</code>.</li>
 *   <li>Mockea el método <code>auditTransaction</code> (partial mocking) para 
 *   que no haga nada (doNothing) o simplemente no ejecute su lógica real.</li>
 *   <li>Realiza un depósito de 500.00.</li>
 *   <li>Verifica que el balance resultante en el objeto real es 500.00.</li>
 *   <li>Verifica que <code>auditTransaction</code> fue llamado con los argumentos: 
 *   <code>"DEPOSIT"</code> y <code>500.00</code>.</li>
 * </ol>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - EX2: Espionaje de Efectos Secundarios")
public class EX2_LegacySpyExercise {

    @Spy
    private BankAccountService bankAccountService = new BankAccountService();

    @Test
    @Disabled("Deshabilitado: Implementar lógica en la solución S2")
    @DisplayName("🧪 Test: Verificación de Auditoría en Depósito Real")
    void testDepositAuditing() {
        // TAREA: Implementar el test siguiendo los requisitos
    }
}
