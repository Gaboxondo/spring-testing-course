package com.testing.course.spring.section1_context.theory;

import com.testing.course.spring.config.HearingConfig;
import com.testing.course.spring.service.HearingInterpreter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: El Motor de Integración (SpringExtension y ContextConfiguration)</h1>
 * 
 * <p><b>Qué hace:</b> Esta clase demuestra cómo conectar el motor de JUnit 5 con el 
 * contenedor de Inyección de Dependencias de Spring de forma manual y controlada.</p>
 * 
 * <h2>Diferencias entre el Aislamiento de Spring:</h2>
 * 
 * <h3>1. @ExtendWith(SpringExtension.class) - El Puente</h3>
 * <p>Es la extensión oficial que permite a JUnit 5 "hablar" con Spring. 
 * Sin esta anotación, JUnit ejecutará el test pero ignorará por completo anotaciones 
 * como <code>@Autowired</code> o <code>@Value</code>, dejando los campos en <code>null</code>.</p>
 * 
 * <h3>2. @ContextConfiguration - El Plano de Construcción</h3>
 * <p>Define <b>exactamente qué Beans</b> deben cargarse en el contenedor para este test. 
 * En este caso, usamos la clase <code>HearingConfig</code> como guía.</p>
 * 
 * <h3>3. Diferencia con @SpringBootTest</h3>
 * <p><code>@SpringBootTest</code> es una anotación "paraguas" que ya incluye 
 * <code>@ExtendWith(SpringExtension.class)</code> e intenta buscar automáticamente 
 * la clase principal de la aplicación para cargar el <b>contexto completo</b>.</p>
 * 
 * <h2>⚠️ Sobre la resolución de Beans (Laurel vs Yanny):</h2>
 * <p>Es posible que en este test obtengas 'Yanny' si no has configurado bien los 
 * perfiles. Para que este test funcione por defecto con 'Laurel', hemos marcado 
 * a <code>LaurelWordProducer</code> como la implementación primaria cuando el 
 * perfil 'yanny' NO esté activo.</p>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L1: @ExtendWith vs @ContextConfiguration")
class L1_SpringContextTheory {

    @Autowired
    private HearingInterpreter hearingInterpreter;

    /**
     * <h2>DEMO: Ejecución con DI real</h2>
     * <p>Al ejecutar este método, <code>SpringExtension</code> ha detectado 
     * el @Autowired y ha inyectado la instancia gracias a los planos de 
     * <code>ContextConfiguration</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Verificación de Inyección de Dependencias manual")
    void testWhatDidIHear() {
        assertNotNull(hearingInterpreter, "SpringExtension no pudo inyectar el Bean");
        
        String result = hearingInterpreter.whatDidIHear();
        
        // El test espera encontrar a LAUREL porque es el @Primary y ya que
        // NO hemos activado el perfil de 'yanny' mediante @ActiveProfiles, 
        // LaurelWordProducer debería ser la elección automática del contenedor.
        assertTrue(result.contains("Laurel"), 
            "ERROR CRÍTICO: Se esperaba recibir LAUREL pero se recibió -> " + result);
    }
}
