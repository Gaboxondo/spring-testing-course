package com.testing.course.spring.section1_context.theory;

import com.testing.course.spring.config.HearingConfig;
import com.testing.course.spring.service.HearingInterpreter;
import com.testing.course.spring.service.WordProducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: Prioridad y Cualificación (@Primary vs @Qualifier)</h1>
 * 
 * <p><b>Qué hace:</b> Proporciona mecanismos para resolver la ambigüedad cuando 
 * existen múltiples Beans del mismo tipo candidatos a ser inyectados.</p>
 * 
 * <p><b>Por qué existe:</b> Evita excepciones de tipo <code>NoUniqueBeanDefinitionException</code> 
 * permitiendo indicar una implementación por defecto o forzar una específica por nombre.</p>
 * 
 * <h2>Mecanismos de Selección:</h2>
 * <ul>
 *   <li><b>@Primary:</b> Selecciona este Bean por defecto cuando no se indica nada más (la opción 'Vip').</li>
 *   <li><b>@Qualifier:</b> Permite elegir a mano qué Bean inyectar usando su ID o un alias único.</li>
 * </ul>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L2: Resolución de Ambigüedad entre Beans")
class L2_PrimaryQualifierTheory {

    @Autowired
    private HearingInterpreter defaultInterpreter; // Inyectará LaurelWordProducer (tiene @Primary)

    @Autowired
    @Qualifier("yannyWordProducer") 
    private WordProducer specialProducer; // Fuerza la inyección de YannyWordProducer

    /**
     * <h2>DEMO: Diferenciación de Beans por Cualificador</h2>
     * <p>Comprobamos que Spring respeta tanto la prioridad marcando a Laurel como 
     * protagonista, como el cualificador forzando el uso de Yanny.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Trabajo con Qualifiers y Primaries")
    void testBeanQualifiers() {
        assertEquals("Escuché: Laurel", defaultInterpreter.whatDidIHear());
        assertEquals("Yanny", specialProducer.getWord());
    }
}
