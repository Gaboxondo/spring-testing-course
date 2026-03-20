package com.testing.course.mockito.section2_spy.solutions;

import com.testing.course.service.PromotionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>SOLUCIÓN: Simulación de API con @Spy en PromotionService</h1>
 * 
 * <p>Demuestra la aplicación de Partial Mocking para sustituir solo 
 * la llamada externa al API y mantener la lógica core de negocio 
 * intacta en el test.</p>
 * 
 * <h2>Puntos Clave:</h2>
 * <ul>
 *   <li>Uso de <code>doReturn()</code> para evitar la ejecución de la lógica real 
 *   del API externa (la cual podría fallar o tardar demasiado).</li>
 *   <li>Aserción del precio final tras la lógica matemática real.</li>
 *   <li>Verificación de interacción con <code>verify()</code>.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - S1: Solución de Spies y API Mocking")
class S1_SpySolution {

    @Spy
    private PromotionService promotionService = new PromotionService();

    @Test
    @DisplayName("🧪 Solución: Cálculo de precios con descuento (Spy API)")
    void testPriceCalculationWithSpy() {
        // 1. Stub parcial: Mockear solo la llamada a la API
        doReturn(new BigDecimal("0.15"))
            .when(promotionService).fetchDiscountFactorFromAPI("SUMMER24");

        // 2. Act: Ejecutar el método real
        BigDecimal basePrice = new BigDecimal("200.00");
        BigDecimal result = promotionService.calculatePriceAfterDiscount(basePrice, "SUMMER24");

        // 3. Assert: 200 * (1 - 0.15) = 170
        BigDecimal expected = new BigDecimal("170.00");
        assertEquals(0, expected.compareTo(result), "El precio debería tener un 15% de descuento");

        // 4. Verify: Verificar que se llamó a la API mockeada internamente
        verify(promotionService, times(1)).fetchDiscountFactorFromAPI("SUMMER24");
        
        // Verificamos que para otros códigos NO se llamó
        verify(promotionService, never()).fetchDiscountFactorFromAPI("OTHER");
    }
}
