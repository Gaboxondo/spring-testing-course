package com.testing.course.service;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * <h1>SERVICIO DEMO: Gestión de Promociones</h1>
 * 
 * <p><b>Qué hace:</b> Calcula descuentos basados en códigos promocionales obtenidos de una API externa.</p>
 * 
 * <p><b>Por qué existe:</b> Sirve de ejemplo para demostrar cómo Mockito maneja las dependencias 
 * que requieren conectividad de red o servicios en la nube.</p>
 * 
 * <p><b>Cómo se usa:</b> Se utiliza en tests para mostrar que sin el uso de mocks, el método 
 * <code>fetchDiscountFactorFromAPI</code> fallaría o devolvería valores por defecto indeseados.</p>
 */
public class PromotionService {

    private static final Logger logger = Logger.getLogger(PromotionService.class.getName());

    /**
     * Calcula el precio final aplicando el factor de descuento obtenido de la API.
     * 
     * @param basePrice El precio original del servicio/producto.
     * @param promoCode Código a validar externamente.
     * @return BigDecimal con el precio final tras el descuento.
     */
    public BigDecimal calculatePriceAfterDiscount(BigDecimal basePrice, String promoCode) {
        BigDecimal discountFactor = fetchDiscountFactorFromAPI(promoCode);
        
        BigDecimal finalPrice = basePrice.multiply(BigDecimal.ONE.subtract(discountFactor));
        
        logger.info("Precio final calculado: " + finalPrice);
        return finalPrice;
    }

    /**
     * Simula una llamada REST a un proveedor de promociones.
     * <p>Este método es el "punto de dolor" que debe ser mockeado en los tests unitarios.</p>
     */
    public BigDecimal fetchDiscountFactorFromAPI(String promoCode) {
        logger.info("Intentando conectar con API REST externa en http://cloud-promos.com/v1/ ...");
        return BigDecimal.ZERO; 
    }
}
