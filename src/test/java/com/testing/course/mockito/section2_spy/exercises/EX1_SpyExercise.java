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
 * sin necesidad de conectarse realmente al API externo de promociones, manteniendo 
 * la lógica de cálculo real de la clase.</p>
 * 
 * <h2>Requisitos del ejercicio:</h2>
 * <ol>
 *   <li>Configurar <code>PromotionService</code> como un <b>Spy</b> mediante anotación.</li>
 *   <li>Mockear PARCIALMENTE el método <code>fetchDiscountFactorFromAPI</code> 
 *   para que devuelva un factor de descuento del 15% (0.15) para el código "SUMMER24".</li>
 *   <li>Ejecutar el método real <code>calculatePriceAfterDiscount</code> 
 *   con un precio base de 200.00 y el código promocional anterior.</li>
 *   <li>Verificar el precio final calculado (170.00).</li>
 *   <li>Asegurarse de que se llamó al método real mockeado exactamente una vez.</li>
 *   <li>Asegurarse de que NO se llamó al método real para otros códigos promocionales.</li>
 * </ol>
 * 
 * <p>TIP: Usa la sintaxis <code>doReturn().when()</code> para evitar efectos secundarios reales.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - EX1: Ejercicio de Spies y API Mocking")
public class EX1_SpyExercise {

    @Spy
    private PromotionService promotionService = new PromotionService();

    /**
     * TAREA: Implementar un test con Spy que simule el descuento de una API 
     * y valide el cálculo final de precios en PromotionService.
     */
    @Test
    @Disabled("Deshabilitado: Implementar lógica en la solución S1")
    @DisplayName("🧪 Test: Cálculo de precios con descuento (Spy API)")
    void testPriceCalculationWithSpy() {
        // TODO: Implementar stubbing parcial para "SUMMER24" -> 0.15
        
        // TODO: Ejecutar el cálculo para 200.00
        
        // TODO: Assertions (Price should be 170.00)
        
        // TODO: Verifications (Verify call to fetchDiscountFactorFromAPI)
    }
}
