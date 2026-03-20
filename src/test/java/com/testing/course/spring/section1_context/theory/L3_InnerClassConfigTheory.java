package com.testing.course.spring.section1_context.theory;

import com.testing.course.spring.service.HearingInterpreter;
import com.testing.course.spring.service.WordProducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>TEORÍA: Configuración en Clase Interna (@Configuration)</h1>
 * 
 * <p><b>Qué hace:</b> Permite definir un mini-contexto de Spring específico 
 * declarándolo dentro de la propia clase de test.</p>
 * 
 * <p><b>Por qué existe:</b> Es ideal para aislar comportamientos. Permite 
 * prescindir de las clases de configuración globales (configuración "pesada") 
 * y declarar solo los Beans necesarios para un test unitario con Spring.</p>
 * 
 * <h2>Dato Técnico:</h2>
 * <p>Cuando <code>@ContextConfiguration</code> no tiene parámetros, Spring 
 * busca automáticamente una clase <code>@Configuration</code> estática dentro de la misma clase.</p>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DisplayName("Sección 1 - L3: Contexto Específico (Clase Interna)")
class L3_InnerClassConfigTheory {

    /**
     * Configuración "On the fly" solo para este Test.
     */
    @Configuration
    static class TestConfig {
        @Bean
        WordProducer yannyMock() {
            return () -> "Yanny"; 
        }

        @Bean
        HearingInterpreter hearingInterpreter(WordProducer wordProducer) {
            return new HearingInterpreter(wordProducer);
        }
    }

    @Autowired
    private HearingInterpreter interpreter;

    /**
     * <h2>DEMO: Ejecución con contexto local</h2>
     * <p>El Bean inyectado proviene exclusivamente de la configuración interna, 
     * ignorando el escaneo de componentes global.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Inyectar Beans desde configuración estática interna")
    void testInnerConfig() {
        assertEquals("Escuché: Yanny", interpreter.whatDidIHear());
    }
}
