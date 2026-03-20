package com.testing.course.service;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * <h1>SERVICIO DEMO: Gestión de Promociones</h1>
 * 
 * <p>Contiene lógica compleja para aplicar descuentos externos.</p>
 * <p>La parte difícil es obtener la lista de promociones activas desde un API REST externo.</p>
 */
public class PromotionService {

    private static final Logger logger = Logger.getLogger(PromotionService.class.getName());

    /**
     * Calcula el precio final aplicando un código promocional.
     * <p>Mecanismo: Llama a un API de promociones externas y luego aplica lógica local.</p>
     */
    public BigDecimal calculatePriceAfterDiscount(BigDecimal basePrice, String promoCode) {
        BigDecimal discountFactor = fetchDiscountFactorFromAPI(promoCode);
        
        // El precio final es basePrice * (1 - discountFactor)
        BigDecimal finalPrice = basePrice.multiply(BigDecimal.ONE.subtract(discountFactor));
        
        logger.info("Precio final calculado: " + finalPrice);
        return finalPrice;
    }

    /**
     * Simula llamar a una API REST externa compleja.
     * En un entorno de tests reales, esto lanzaría un error por falta de conectividad 
     * o devolvería resultados impredecibles.
     */
    public BigDecimal fetchDiscountFactorFromAPI(String promoCode) {
        logger.info("Intentando conectar con API REST externa en http://cloud-promos.com/v1/ ...");
        // Simulación: Si no hay red real, fallaría con ConnectException.
        // Aquí devolvemos 0.0 por defecto para evitar roturas de test si no se mockea.
        return BigDecimal.ZERO; 
    }
}
