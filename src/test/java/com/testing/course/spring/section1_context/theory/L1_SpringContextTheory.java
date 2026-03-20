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
 * <h1>TEORÍA: Introducción al Contexto de Spring (Dependency Injection)</h1>
 * 
 * <p><b>Qué hace:</b> Activa el soporte de Spring en JUnit 5 y levanta un 
 * contenedor (ApplicationContext) para gestionar e inyectar Beans reales.</p>
 * 
 * <p><b>Por qué existe:</b> En lugar de simular (mockear) cada componente, a menudo 
 * necesitamos testear cómo interactúan varios Beans reales (Tests de Integración), 
 * asegurando que las reglas de inyección se cumplen correctamente.</p>
 * 
 * <h2>Anotaciones Clave:</h2>
 * <ul>
 *   <li><b>@ExtendWith(SpringExtension.class):</b> El puente oficial entre JUnit 5 y Spring.</li>
 *   <li><b>@ContextConfiguration:</b> Define el archivo XML o la clase Java <code>@Configuration</code> 
 *   que servirá de base al contexto.</li>
 *   <li><b>@Autowired:</b> Solicita a Spring que busque e inyecte una instancia del tipo indicado.</li>
 * </ul>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L1: Inyección de Dependencias y Contexto")
class L1_SpringContextTheory {

    @Autowired
    private HearingInterpreter hearingInterpreter;

    /**
     * <h2>DEMO: Verificación de carga de Bean real</h2>
     * <p>El test comprueba que el intérprete ha sido inyectado y funciona con 
     * el productor de palabras real (sin intervención de Mockito).</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Inyección de Bean real gestionado por Spring")
    void testWhatDidIHear() {
        String result = hearingInterpreter.whatDidIHear();
        assertTrue(result.contains("Laurel"), "El Bean @Primary debe ser Laurel");
    }
}
