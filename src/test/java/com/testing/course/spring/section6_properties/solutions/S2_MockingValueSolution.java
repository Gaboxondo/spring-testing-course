package com.testing.course.spring.section6_properties.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Solución Ejercicio E2: Mockear @Value sin contexto de Spring.
 * 
 * OBJETIVO: Tienes una clase TransactionService con una propiedad de configuración
 * que determina si se cobra comisión o no. Este es el test unitario resuelto
 * usando MockitoExtension y setea la propiedad con ReflectionTestUtils.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Solución E2: Mockear @Value en tests (Mockito)")
class S2_MockingValueSolution {

    static class TransactionService {

        @Value("${transaction.fee.enabled}")
        private boolean feeEnabled;

        public double calculateFinalAmount(double amount) {
            if (feeEnabled) {
                return amount + (amount * 0.05); // cobra 5% comisión
            }
            return amount; 
        }
    }

    // SOLUCIÓN:
    @InjectMocks
    private TransactionService service;

    @Test
    @DisplayName("Sin comisión, debe devolver el importe íntegro")
    void testNoFee() {
        // SOLUCIÓN:
        // Configura la propiedad feeEnabled a false usando ReflectionTestUtils
        ReflectionTestUtils.setField(service, "feeEnabled", false);

        // Verifica que calculateFinalAmount(100.0) devuelve 100.0
        double result = service.calculateFinalAmount(100.0);
        assertEquals(100.0, result);
    }

    @Test
    @DisplayName("Con comisión, debe devolver el importe más el 5%")
    void testWithFee() {
        // SOLUCIÓN:
        // Configura la propiedad feeEnabled a true usando ReflectionTestUtils
        ReflectionTestUtils.setField(service, "feeEnabled", true);

        // Verifica que calculateFinalAmount(100.0) devuelve 105.0
        double result = service.calculateFinalAmount(100.0);
        assertEquals(105.0, result);
    }
}
