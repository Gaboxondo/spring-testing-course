package com.testing.course.mockito.section2_spy.solutions;

import com.testing.course.service.BankAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * <h1>SOLUCIÓN: Test de Código Legado con Side-Effects</h1>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - S2: Solución de Espionaje de Efectos Secundarios")
class S2_LegacySpySolution {

    @Spy
    private BankAccountService bankAccountService = new BankAccountService();

    @Test
    @DisplayName("🧪 Solución: Verificación de Auditoría en Depósito Real")
    void testDepositAuditing() {
        // 1. Stub parcial: Mockear auditTransaction para que NO haga nada real (evita logs/APIs)
        // Usamos doNothing() en métodos void de un Spy
        doNothing().when(bankAccountService).auditTransaction(anyString(), any(BigDecimal.class));

        // 2. Act: Depositar dinero (Lógica real se ejecuta)
        BigDecimal amount = new BigDecimal("500.00");
        bankAccountService.deposit(amount);

        // 3. Assert: Verificar balance en el objeto REAL
        assertEquals(new BigDecimal("500.00"), bankAccountService.getBalance());

        // 4. Verify: Asegurar que se mandó a auditar la transacción correcta
        verify(bankAccountService).auditTransaction(eq("DEPOSIT"), eq(amount));
    }
}
