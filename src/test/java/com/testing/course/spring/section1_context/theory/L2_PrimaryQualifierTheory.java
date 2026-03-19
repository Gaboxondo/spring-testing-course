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
 * Sección 1 - L2: @Primary vs @Qualifier.
 * 
 * ¿Y si tenemos varias clases que implementan la misma interfaz?
 * Spring nos da dos formas de elegir Cuál inyectar:
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L2: @Primary vs @Qualifier")
class L2_PrimaryQualifierTheory {

    @Autowired
    HearingInterpreter defaultInterpreter; // Recibirá Laurel por ser @Primary.

    @Autowired
    @Qualifier("yannyWordProducer") 
    WordProducer specialProducer; // Recibirá Yanny al forzarle el id de componente.

    @Test
    @DisplayName("🧪 Verificar la diferenciación de Beans")
    void testBeanQualifiers() {
        assertEquals("Escuché: Laurel", defaultInterpreter.whatDidIHear());
        assertEquals("Yanny", specialProducer.getWord());
    }
}

