package com.testing.course.spring.section6_properties.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h1>TEORÍA: Mockeo de @Value en Tests de Mockito</h1>
 * 
 * <p><b>Qué hace:</b> Enseña a inyectar valores en campos privados anotados con 
 * <code>@Value</code> cuando estamos en un test unitario puro (sin contexto de Spring).</p>
 * 
 * <p><b>Por qué existe:</b> En tests ultra-rápidos de Mockito, el contenedor de 
 * Spring no está presente para resolver las propiedades. Sin intervención, estos 
 * campos estarían vacíos (null o 0), rompiendo la lógica del servicio.</p>
 * 
 * <h2>Solución técnica:</h2>
 * <p>Se utiliza <code>ReflectionTestUtils.setField()</code> para inyectar mediante 
 * introspección el valor deseado "bypassando" el encapsulamiento privado.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 6 - L3: Inyección mediante Reflector (Mockito puro)")
class L3_MockingValueTheory {

    static class FeatureToggleService {
        @Value("${feature.new-algorithm.enabled}")
        private boolean newAlgorithmEnabled;

        public String processData() {
            return newAlgorithmEnabled ? "NUEVO" : "ANTIGUO";
        }
    }

    @InjectMocks
    private FeatureToggleService featureToggleService;

    /**
     * <h2>DEMO: Invocación forzada por Reflexión</h2>
     * <p>Simulamos que la propiedad está activa forzando el campo 'newAlgorithmEnabled' 
     * a TRUE antes de ejecutar la lógica de negocio.</p>
     */
    @Test
    @DisplayName("🧪 Demo 20: Test unitario con Feature Toggle forzado")
    void testFeatureEnabled() {
        ReflectionTestUtils.setField(featureToggleService, "newAlgorithmEnabled", true);
        assertEquals("NUEVO", featureToggleService.processData());
    }
}
