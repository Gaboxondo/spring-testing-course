package com.testing.course.service;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * <h1>SERVICIO DEMO: Gestión de Cuentas Bancarias</h1>
 * 
 * <p>Este servicio se utiliza para demostrar el uso de @Spy y Partial Mocking.</p>
 * <p>Contiene lógica real que queremos ejecutar, pero métodos internos que 
 * simulan integraciones externas (como auditoría o comunicaciones) que 
 * preferimos mockear en ciertos escenarios.</p>
 */
public class BankAccountService {

    private static final Logger logger = Logger.getLogger(BankAccountService.class.getName());
    private BigDecimal balance = BigDecimal.ZERO;

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        
        // Llamada a un método interno de "auditoría" que queremos mockear con un Spy
        auditTransaction("DEPOSIT", amount);
        
        this.balance = this.balance.add(amount);
    }

    /**
     * Simula una llamada a un sistema externo de auditoría.
     * En un test normal, esto podría ensuciar los logs o requerir infraestructura.
     */
    public void auditTransaction(String type, BigDecimal amount) {
        logger.info("Auditoría Real: Procesando " + type + " de " + amount);
        // Imagina que aquí hay una llamada a una API REST pesada o una BBDD
    }

    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Intenta retirar dinero. Llama a un método complejo de validación.
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
     * Método complejo que simula validación con el banco central.
     * Queremos mockear este método pero usar el resto de la lógica de balance.
     */
    public boolean validateAccountStatus() {
        logger.info("Validando estado de cuenta con Banco Central...");
        // Simulación de respuesta real
        return true; 
    }
}
