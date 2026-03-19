package com.testing.course.spring.section1_context.theory;

import com.testing.course.spring.service.HearingInterpreter;
import com.testing.course.spring.service.WordProducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Sección 1 - L3: Configuración en Clase Interna (@Configuration).
 * 
 * ¿Y si solo queremos unos Beans concretos para este test sin tocar HearingConfig?
 * Podemos definir la configuración DENTRO del test.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DisplayName("Sección 1 - L3: Configuración en Clase Interna")
class L3_InnerClassConfigTheory {

    @Configuration
    static class TestConfig {
        @Bean
        WordProducer yannyMock() {
            return () -> "Yanny"; // Lambda para simular una respuesta.
        }

        @Bean
        HearingInterpreter hearingInterpreter(WordProducer wordProducer) {
            return new HearingInterpreter(wordProducer);
        }
    }

    @Autowired
    HearingInterpreter interpreter;

    @Test
    @DisplayName("🧪 Verificar el contexto basado en clase interna")
    void testInnerConfig() {
        assertEquals("Escuché: Yanny", interpreter.whatDidIHear());
    }
}

