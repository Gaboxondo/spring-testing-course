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
public class S1_SpySolution {

    @Spy
    PromotionService promotionService = new PromotionService();

    /**
     * TAREA SOLUCIONADA: Carga el PromotionService como Spy, mockea el API de 
     * descuentos para devolver un 20%, y valida el cálculo final.
     */
    @Test
    @DisplayName("🧪 Test Solución: Cálculo de precios con descuento (Spy API)")
    void testPriceCalculationWithSpy() {
        // 1. Configuramos el mock parcial: Queremos un 20% de descuento.
        // Usamos doReturn para NO llamar a la lógica real del API.
        doReturn(new BigDecimal("0.2")).when(promotionService).fetchDiscountFactorFromAPI("SUMMER2026");
        
        // 2. Ejecutar la lógica REAL de cálculo basado en el mock parcial
        BigDecimal finalPrice = promotionService.calculatePriceAfterDiscount(new BigDecimal("100"), "SUMMER2026");
        
        // 3. Validamos que el precio resultante es correcto (100 * (1 - 0.2) = 80)
        assertEquals(new BigDecimal("80.0"), finalPrice, "El precio tras el descuento debería ser 80");
        
        // 4. Verificamos que efectivamente se consultó al API
        verify(promotionService).fetchDiscountFactorFromAPI("SUMMER2026");
    }
}
