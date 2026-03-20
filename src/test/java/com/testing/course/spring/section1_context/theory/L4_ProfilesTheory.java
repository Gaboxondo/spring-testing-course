package com.testing.course.spring.section1_context.theory;

import com.testing.course.spring.config.HearingConfig;
import com.testing.course.spring.service.HearingInterpreter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: Filtro de Beans mediante @ActiveProfiles</h1>
 * 
 * <p><b>Qué hace:</b> Indica a Spring qué perfiles de entorno debe considerar 
 * "activos" al levantar el ApplicationContext para el test.</p>
 * 
 * <p><b>Por qué existe:</b> Permite alternar implementaciones según el entorno 
 * (ej: conectar a una H2 real para tests vs MySql real para prod) de forma declarativa.</p>
 */
@ActiveProfiles("yanny")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L4: Perfiles y Testing Condicional")
class L4_ProfilesTheory {

    @Autowired
    private HearingInterpreter hearingInterpreter;

    /**
     * <h2>DEMO: Activación del perfil Yanny</h2>
     * <p>Aunque Laurel sea <code>@Primary</code>, al no estar bajo el perfil activo, 
     * Spring selecciona a YannyWordProducer.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: Verificación de Beans condicionados por perfil")
    void testActiveProfile() {
        assertEquals("Escuché: Yanny", hearingInterpreter.whatDidIHear(), "Debe cargar el Bean del perfil 'yanny'");
    }
}
