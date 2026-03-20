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
 * <h1>TEORÍA: Estrategias de Espionaje Avanzado</h1>
 * 
 * <p><b>Qué hace:</b> Profundiza en formas alternativas de creación de Spies y 
 * en las sutilezas técnicas de la sintaxis <code>doReturn</code>.</p>
 * 
 * <p><b>Por qué existe:</b> A veces no podemos usar anotaciones (ej. el objeto ya 
 * existe) o necesitamos evitar que Mockito llame al código real accidentalmente 
 * durante la configuración del test.</p>
 * 
 * <h2>Diferencias entre @Spy y Mockito.spy():</h2>
 * <ul>
 *   <li><b>@Spy (Anotación):</b> Inyectada por la extensión. Muy legible pero rígida.</li>
 *   <li><b>Mockito.spy(instancia):</b> Creación dinámica en cualquier punto del test.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - L2: Teoría Avanzada de Spies")
class L2_AdvancedSpyTheory {

    /**
     * <h2>CASO 1: Espiando una instancia ya creada manualmente</h2>
     * <p><b>Qué hace:</b> Crea un "envoltorio" (wrapper) de Mockito sobre un objeto 
     * real que ya tiene dependencias configuradas.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Spy Manual vs Anotación")
    void manualSpyDemo() {
        // Objeto real creado fuera de Mockito
        PromotionService realService = new PromotionService();
        
        // Creamos el spy sobre la marcha
        PromotionService spyService = Mockito.spy(realService);
        
        doReturn(new BigDecimal("0.5")).when(spyService).fetchDiscountFactorFromAPI(anyString());
        
        BigDecimal result = spyService.calculatePriceAfterDiscount(new BigDecimal("100"), "PROMO50");
        
        assertEquals(new BigDecimal("50.0"), result);
        verify(spyService).fetchDiscountFactorFromAPI("PROMO50");
    }

    /**
     * <h2>CASO 2: El uso obligatorio de doReturn()</h2>
     * <p><b>Qué hace:</b> Demuestra por qué la sintaxis <code>when(...).thenReturn(...)</code> 
     * es peligrosa en Spies: Mockito intenta ejecutar el método real antes de interceptarlo.</p>
     * 
     * <p><b>Consejo:</b> Si tu método real tiene efectos secundarios (ej: borrar BBDD), 
     * <code>doReturn</code> es tu mejor amigo para evitar desastres en tus tests.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: El peligro de 'when' en Spies")
    void dangerOfWhenInSpies() {
        PromotionService spyService = spy(new PromotionService());

        // CORRECTO Y SEGURO (Evita llamar al código real de fetchDiscountFactorFromAPI)
        doReturn(BigDecimal.ONE).when(spyService).fetchDiscountFactorFromAPI("OK");
        
        assertEquals(BigDecimal.ZERO, spyService.calculatePriceAfterDiscount(new BigDecimal("100"), "OK"));
    }
}
