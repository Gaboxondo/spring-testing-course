package com.testing.course.service;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * <h1>SERVICIO DEMO: Gestión de Cuentas Bancarias</h1>
 * 
 * <p><b>Qué hace:</b> Simula la operativa básica de una cuenta bancaria (depósitos, retiros y saldos).</p>
 * 
 * <p><b>Por qué existe:</b> Se utiliza específicamente para demostrar el uso de <code>@Spy</code> 
 * y <b>Partial Mocking</b>. Permite ejecutar la lógica real de balance mientras se interceptan 
 * métodos de auditoría o validaciones externas.</p>
 * 
 * <p><b>Cómo se usa:</b> Es el protagonista de la Sección 2 de Mockito (Spies). Se recomienda 
 * usar <code>doReturn(...).when(spy)...</code> para evitar la ejecución del código real en 
 * métodos como <code>validateAccountStatus</code>.</p>
 */
public class BankAccountService {

    private static final Logger logger = Logger.getLogger(BankAccountService.class.getName());
    private BigDecimal balance = BigDecimal.ZERO;

    /**
     * Realiza un depósito tras auditar la transacción.
     * 
     * @param amount El monto positivo a ingresar.
     * @throws IllegalArgumentException si el monto es negativo o cero.
     */
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        
        auditTransaction("DEPOSIT", amount);
        this.balance = this.balance.add(amount);
    }

    /**
     * Simula una llamada a un sistema externo de auditoría.
     * <p>En los tests, este método suele mockearse para evitar ruido en los logs.</p>
     */
    public void auditTransaction(String type, BigDecimal amount) {
        logger.info("Auditoría Real: Procesando " + type + " de " + amount);
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Intenta retirar fondos tras validar el estado de la cuenta.
     * 
     * @param amount El monto a retirar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean withdraw(BigDecimal amount) {
        if (validateAccountStatus()) {
            if (balance.compareTo(amount) >= 0) {
                balance = balance.subtract(amount);
                auditTransaction("WITHDRAW", amount);
                return true;
            }
        }
        return false;
    }

    /**
     * Simula una validación compleja con una entidad bancaria central.
     * <p>En tests unitarios, preferimos mockear este método para que siempre devuelva true.</p>
     */
    public boolean validateAccountStatus() {
        logger.info("Validando estado de cuenta con Banco Central...");
        return true; 
    }
}
