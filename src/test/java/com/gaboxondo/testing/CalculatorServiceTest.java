package com.gaboxondo.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Pruebas Unitarias Básicas con JUnit 5")
class CalculatorServiceTest {

    private final CalculatorService calculator = new CalculatorService();

    @Test
    @DisplayName("Debería sumar dos números correctamente (Ejemplo Simple)")
    void shouldAddTwoNumbers() {
        // Given
        int a = 10;
        int b = 5;

        // When
        int result = calculator.add(a, b);

        // Then
        assertThat(result)
            .as("La suma de 10 + 5 debería ser 15")
            .isEqualTo(15);
    }

    @Test
    @DisplayName("Debería multiplicar dos números")
    void shouldMultiplyTwoNumbers() {
        int result = calculator.multiply(3, 4);
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("Debería lanzar excepción al dividir por cero")
    void shouldThrowExceptionWhenDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "Dividir por cero debería lanzar IllegalArgumentException");
    }
}
