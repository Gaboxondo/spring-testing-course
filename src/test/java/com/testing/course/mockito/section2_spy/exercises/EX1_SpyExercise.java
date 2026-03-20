package com.testing.course.mockito.section2_spy.exercises;

import com.testing.course.service.PromotionService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>EJERCICIO: Simulación de API con @Spy en PromotionService</h1>
 * 
 * <p>Objetivo: Validar que el sistema calcule correctamente descuentos de precio 
 * sin necesidad de conectarse realmente al API externo de promociones.</p>
 * 
 * <h2>Requisitos del ejercicio:</h2>
 * <ol>
 *   <li>Configurar <code>PromotionService</code> como un <b>Spy</b> para 
 *   mantener la lógica real del cálculo de precio final.</li>
 *   <li>Mockear PARCIALMENTE el método <code>fetchDiscountFactorFromAPI</code> 
 *   para que devuelva un factor de descuento específico (por ejemplo, 0.2 para 
 *   un descuento del 20%).</li>
 *   <li>Ejecutar el método real <code>calculatePriceAfterDiscount</code> 
 *   con un precio base (por ejemplo, 100).</li>
 *   <li>Verificar con aserciones que el precio final resultante coincide con 
 *   lo esperado (80).</li>
 *   <li>Verificar que se realizó la llamada al API mockeada mediante <code>verify</code>.</li>
 * </ol>
 * 
 * <p>TIP: Recuerda usar la sintaxis <code>doReturn().when()</code> para evitar 
 * que se intente ejecutar la lógica real del API durante el stubbing.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - EX1: Ejercicio de Spies y API Mocking")
public class EX1_SpyExercise {

    @Spy
    PromotionService promotionService = new PromotionService();

    /**
     * TAREA: Implementar un test con Spy que simule el descuento de una API 
     * y valide el cálculo final de precios en PromotionService.
     */
    @Test
    @Disabled("Deshabilitado: Implementar lógica en la solución S1")
    @DisplayName("🧪 Test: Cálculo de precios con descuento (Spy API)")
    void testPriceCalculationWithSpy() {
        // 1. Stub parcial: Hacer que fetchDiscountFactorFromAPI devuelva 0.20
        // 2. Act: Llamar a calculatePriceAfterDiscount con 100.00
        // 3. Assert: Verificar que el resultado es 80.00
        // 4. Verify: Asegurar que se llamó al método mockeado.
    }
}
