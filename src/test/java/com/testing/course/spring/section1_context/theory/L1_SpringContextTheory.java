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
 * <ul>
 *   <li>Habilita el ciclo de vida de Spring dentro del test.</li>
 *   <li>Permite la inyección de dependencias en campos y métodos de test.</li>
 *   <li>Gestiona el "TestContext", que se encarga de cachear el ApplicationContext entre tests.</li>
 * </ul>
 * 
 * <h3>2. @ContextConfiguration - El Plano de Construcción</h3>
 * <p>Define <b>exactamente qué Beans</b> deben cargarse en el contenedor para este test. 
 * En este ejemplo, le decimos a Spring que use la clase <code>HearingConfig</code> 
 * como receta para crear los objetos.</p>
 * <ul>
 *   <li>Permite cargar solo los fragmentos de la aplicación que nos interesan.</li>
 *   <li>Es manual: Si olvidas registrar un Bean necesario, el test fallará al arrancar.</li>
 * </ul>
 * 
 * <h3>3. Diferencia con @SpringBootTest</h3>
 * <p><code>@SpringBootTest</code> es una anotación "paraguas" que ya incluye 
 * <code>@ExtendWith(SpringExtension.class)</code> e intenta buscar automáticamente 
 * la clase principal de la aplicación para cargar el <b>contexto completo</b>.</p>
 * <table>
 *   <tr>
 *     <th>Funcionalidad</th>
 *     <th>SpringExtension + ContextConfig</th>
 *     <th>@SpringBootTest</th>
 *   </tr>
 *   <tr>
 *     <td>Velocidad</td>
 *     <td>Alta (Solo carga lo indicado)</td>
 *     <td>Media/Baja (Levanta toda la App)</td>
 *   </tr>
 *   <li>Escaneo Automático</td>
 *     <td>No (Manual por clase de config)</td>
 *     <td>Sí (Busca @SpringBootApplication)</td>
 *   </tr>
 * </table>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L1: @ExtendWith vs @ContextConfiguration")
class L1_SpringContextTheory {

    /**
     * Bean real levantado por Spring gracias a HearingConfig.
     */
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
        assertTrue(result.contains("Laurel"), "El Bean @Primary debe ser Laurel");
    }
}
