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
 * <h1>TEORÍA: Propiedades Tipadas y Formatos YAML</h1>
 * 
 * <p><b>Qué hace:</b> Demuestra cómo cargar archivos de configuración en formato 
 * YAML (más legible que .properties) y mapearlos a objetos Java (POJOs).</p>
 * 
 * <p><b>Por qué existe:</b> Los archivos YAML permiten estructuras jerárquicas 
 * complejas. El uso de <code>@ConfigurationProperties</code> ofrece validación 
 * de tipos y mejor seguridad en tiempo de compilación frente al uso de <code>@Value</code>.</p>
 * 
 * <h2>Dato Importante:</h2>
 * <p>Por defecto, Spring no soporta YAML en la anotación <code>@PropertySource</code>. 
 * Se requiere un <code>Factory</code> personalizado para procesar este formato.</p>
 */
@ExtendWith(SpringExtension.class)
@DisplayName("Sección 6 - L2: Carga de YAML y Tipado Seguros")
@PropertySource(value = "classpath:test-external-service.yml", factory = YamlPropertySourceFactory.class)
@EnableConfigurationProperties(ExternalServiceConfig.class)
class L2_YamlPropertyTheory {

    @Autowired
    private ExternalServiceConfig serviceConfig;
    /**
     * <h2>DEMO: Inyectar Configuración en POJO</h2>
     * <p>Validamos que el objeto inyectado contiene los valores definidos en 
     * el archivo YAML externo del classpath.</p>
     */
    @Test
    @DisplayName("🧪 Demo 19: Mapeo de YAML a objeto ConfigurationProperties")
    void testYamlInjected() {
        assertEquals("TEST-KEY-123", serviceConfig.getApiKey());
        assertEquals(5000, serviceConfig.getTimeout());
    }
}
