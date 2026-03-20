package com.testing.course.spring.section6_properties.exercises;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Ejercicio E2: Mockear @Value sin contexto de Spring.
 * 
 * OBJETIVO: Tienes una clase TransactionService con una propiedad de configuración
 * que determina si se cobra comisión o no. Escribe un test unitario 
 * usando MockitoExtension y setea la propiedad con ReflectionTestUtils para simular
 * ambas configuraciones en los tests de abajo.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Ej E2: Mockear @Value en tests (Mockito)")
@Disabled("Ejercicio pendiente de resolver")
class EX2_MockingValueExercise {

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

    // TODO: Instancia o mockea el servicio TransactionService
    @InjectMocks
    private TransactionService service;

    @Test
    @DisplayName("Sin comisión, debe devolver el importe íntegro")
    void testNoFee() {
        // TODO: Configura la propiedad feeEnabled a false usando ReflectionTestUtils

        // TODO: Verifica que calculateFinalAmount(100.0) devuelve 100.0
    }

    @Test
    @DisplayName("Con comisión, debe devolver el importe más el 5%")
    void testWithFee() {
        // TODO: Configura la propiedad feeEnabled a true usando ReflectionTestUtils

        // TODO: Verifica que calculateFinalAmount(100.0) devuelve 105.0
    }
}
