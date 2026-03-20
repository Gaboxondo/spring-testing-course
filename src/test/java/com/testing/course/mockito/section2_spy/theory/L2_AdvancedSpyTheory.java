package com.testing.course.mockito.section2_spy.theory;

import com.testing.course.service.PromotionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA AVANZADA: Estrategias de Espionaje</h1>
 * 
 * <p>En esta lección profundizamos en formas alternativas de crear spies y 
 * situaciones especiales como el espionaje de interfaces.</p>
 * 
 * <h2>Diferencias entre @Spy y Mockito.spy()</h2>
 * <ul>
 *   <li><b>@Spy (Anotación):</b> Requiere que la instancia esté disponible al inicio. Ideal para legibilidad.</li>
 *   <li><b>Mockito.spy(objeto):</b> Permite crear un spy en cualquier momento del test sobre un objeto ya existente.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - L2: Teoría Avanzada de Spies")
class L2_AdvancedSpyTheory {

    /**
     * CASO 1: Espiando una instancia ya creada manualmente.
     * <p>Útil cuando el objeto tiene un constructor complejo o dependencias 
     * que no queremos que Mockito gestione automáticamente.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Spy Manual vs Anotación")
    void manualSpyDemo() {
        // Objeto real creado fuera de Mockito
        PromotionService realService = new PromotionService();
        
        // Creamos el spy sobre la marcha
        PromotionService spyService = Mockito.spy(realService);
        
        // El resto funciona igual
        doReturn(new BigDecimal("0.5")).when(spyService).fetchDiscountFactorFromAPI(anyString());
        
        BigDecimal result = spyService.calculatePriceAfterDiscount(new BigDecimal("100"), "PROMO50");
        
        assertEquals(new BigDecimal("50.0"), result);
        verify(spyService).fetchDiscountFactorFromAPI("PROMO50");
    }

    /**
     * CASO 2: ¿Por qué doReturn() es OBLIGATORIO en Spies?
     * <p>Si usamos when(...).thenReturn(...), Mockito INTENTA EJECUTAR el 
     * método real antes de aplicar el mock. Si el método real lanza excepción, 
     * el test muere antes de empezar.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: El peligro de 'when' en Spies")
    void dangerOfWhenInSpies() {
        PromotionService spyService = spy(new PromotionService());

        // ESTO FALLARÍA si fetchDiscountFactorFromAPI lanzara una excepción real (ej: falta de red)
        // because when(spyService.fetchDiscountFactorFromAPI("ERR")) calls the REAL method.
        
        // when(spyService.fetchDiscountFactorFromAPI("ERR")).thenReturn(BigDecimal.ONE); // <--- EVITAR EN SPIES
        
        // ESTO ES SEGURO:
        doReturn(BigDecimal.ONE).when(spyService).fetchDiscountFactorFromAPI("OK");
        
        assertEquals(BigDecimal.ZERO, spyService.calculatePriceAfterDiscount(new BigDecimal("100"), "OK"));
    }
}
