package com.testing.course.spring.section6_properties.theory;

import com.testing.course.spring.config.ExternalServiceConfig;
import com.testing.course.spring.config.YamlPropertySourceFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Sección 6 - L2: Cargar Propiedades desde YAML Externo.
 * 
 * ¿Quieres cargar un .yml en tus tests? Por defecto @PropertySource solo lee .properties.
 * Para solucionarlo usamos nuestro YamlPropertySourceFactory.
 */
@ExtendWith(SpringExtension.class)
@DisplayName("Sección 6 - L2: Carga de YAML con Factory")
class L2_YamlPropertyTheory {

    @Configuration
    @PropertySource(value = "classpath:test-external-service.yml", factory = YamlPropertySourceFactory.class)
    @EnableConfigurationProperties(ExternalServiceConfig.class) // Habilita la clase de configuración
    static class TestConfig {
        // No necesitamos definir beans, @EnableConfigurationProperties lo hace por nosotros.
    }

    @Autowired
    ExternalServiceConfig serviceConfig;

    @Test
    @DisplayName("🧪 Verificar que el YAML se inyecta en el objeto ConfigurationProperties")
    void testYamlInjected() {
        assertEquals("TEST-KEY-123", serviceConfig.getApiKey());
        assertEquals("https://testing.api.com", serviceConfig.getUrl());
        assertEquals(5000, serviceConfig.getTimeout());
    }
}

