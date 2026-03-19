package com.testing.course.spring.section6_properties.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Sección 6 - L3: Testeando @Value sin contexto de Spring (Unit Test puro).
 * 
 * Cuando hacemos test unitarios puros con MockitoExtension (sin levantar Spring),
 * los campos anotados con @Value equivalen a null o a su valor por defecto (falso, 0, etc),
 * ya que no hay contenedor para inyectar las propiedades.
 * 
 * Para probar diferentes flujos (ej: ifs basados en la propiedad), 
 * podemos usar ReflectionTestUtils de Spring Test para inyectar estos valores
 * o si usamos inyección por constructor, instanciar pasándole el valor.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("L3: Mockear @Value en Tests Unitarios (Mockito)")
class L3_MockingValueTheory {

    // 1. Servicio que usa la propiedad internamente
    @Service
    static class FeatureToggleService {
        
        @Value("${feature.new-algorithm.enabled}")
        private boolean newAlgorithmEnabled;

        public String processData() {
            if (newAlgorithmEnabled) {
                return "Procesando con algoritmo NUEVO";
            }
            return "Procesando con algoritmo ANTIGUO";
        }
    }

    // 2. Mockeamos / instanciamos el servicio (InjectMocks en Mockito crea la instancia)
    @InjectMocks
    private FeatureToggleService featureToggleService;

    @Test
    @DisplayName("Debe usar algoritmo NUEVO cuando la propiedad sea true")
    void testFeatureEnabled() {
        // Establecemos dinámicamente el valor de la propiedad protegida/privada
        ReflectionTestUtils.setField(featureToggleService, "newAlgorithmEnabled", true);

        String result = featureToggleService.processData();

        assertEquals("Procesando con algoritmo NUEVO", result);
    }

    @Test
    @DisplayName("Debe usar algoritmo ANTIGUO cuando la propiedad sea false")
    void testFeatureDisabled() {
        // Establecemos dinámicamente el valor a false
        ReflectionTestUtils.setField(featureToggleService, "newAlgorithmEnabled", false);

        String result = featureToggleService.processData();

        assertEquals("Procesando con algoritmo ANTIGUO", result);
    }
}
