package com.testing.course.spring.section1_context.theory;

import com.testing.course.spring.config.HearingConfig;
import com.testing.course.spring.service.WordService;
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
 * sin cambiar una sola línea de código de negocio.</p>
 * 
 * <h2>Aislamiento de Perfiles:</h2>
 * <p>A diferencia de @Primary (que marca una preferencia global), un perfil 
 * excluye físicamente al Bean del contenedor si no es el activo.</p>
 */
@ActiveProfiles("yanny")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L4: Perfiles y Testing Condicional")
class L4_ProfilesTheory {

    @Autowired
    private WordService wordService; // Spring elegirá YannyWordService porque profile "yanny" es activo

    /**
     * <h2>DEMO: Activación del perfil Yanny</h2>
     * <p>Comprobamos que al activar "yanny", la implementación LaurelWordService 
     * (marcada con !yanny) queda excluida y solo YannyWordService está disponible.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: Verificación de Beans condicionados por perfil")
    void testActiveProfile() {
        assertEquals("Yanny", wordService.getWord(), "Debe cargar el Bean del perfil 'yanny'");
    }
}
