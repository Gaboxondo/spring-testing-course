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
 * Sección 1 - L4: Perfiles en Testing (@ActiveProfiles).
 * 
 * ¿Cómo cambiamos los Beans que se cargan según el entorno?
 * Usamos el sistema de perfiles de Spring.
 */
@ActiveProfiles("yanny")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L4: Activando Perfiles")
class L4_ProfilesTheory {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    @DisplayName("🧪 Verificar que el perfil yanny está activo")
    void testActiveProfile() {
        // Al activar 'yanny', el Bean Laurel (aunque sea @Primary) no se carga 
        // porque su @Profile("laurel") no coincide.
        assertEquals("Escuché: Yanny", hearingInterpreter.whatDidIHear());
    }
}

