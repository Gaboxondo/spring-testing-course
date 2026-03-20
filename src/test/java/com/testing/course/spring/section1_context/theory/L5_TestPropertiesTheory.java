package com.testing.course.spring.section1_context.theory;

import com.testing.course.spring.config.HearingConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: Inyección de Valor (@Value y @TestPropertySource)</h1>
 * 
 * <p><b>Qué hace:</b> Permite definir propiedades de configuración específicas 
 * para el test que sobreescriben o complementan a las de producción.</p>
 * 
 * <p><b>Por qué existe:</b> Facilita el testeo de clases que dependen de 
 * configuraciones externas (URLs de APIs, credenciales, límites) sin necesidad 
 * de crear múltiples archivos application.properties físicamente.</p>
 */
@TestPropertySource(properties = {"testing.property=TestValue"})
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L5: Propiedades en Tiempo de Test")
class L5_TestPropertiesTheory {

    @Value("${testing.property}")
    private String testProperty;

    /**
     * <h2>DEMO: Inyección desde TestPropertySource</h2>
     * <p>El valor del campo es inyectado por Spring al momento de inicializar el test.</p>
     */
    @Test
    @DisplayName("🧪 Demo 5: Verificar inyección de propiedades inline")
    void testPropertyInjection() {
        assertEquals("TestValue", testProperty);
    }
}
