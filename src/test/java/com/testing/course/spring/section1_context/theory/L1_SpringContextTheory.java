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
 * Sección 1 - L1: Introducción al Contexto de Spring.
 * 
 * ¿Para qué sirve esto?
 * En lugar de usar Mockito para simular todo, a veces queremos que Spring cree 
 * los Beans REALES (Inyección de Dependencias) y los inyecte en nuestro Test.
 * 
 * ANOTACIONES:
 * - @ExtendWith(SpringExtension.class): Activa el soporte de Spring en JUnit 5.
 * - @ContextConfiguration: Le dice a Spring dónde están los Beans o la Configuración.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
@DisplayName("Sección 1 - L1: Cargando el Contexto de Spring")
class L1_SpringContextTheory {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    @DisplayName("🧪 Verificar la carga del Bean real")
    void testWhatDidIHear() {
        // En este caso, el Bean REAL está cargado. No hay Mocks.
        String result = hearingInterpreter.whatDidIHear();
        
        System.out.println("El sistema dice: " + result);
        
        // Por defecto, LaurelWordProducer es @Primary, así que escuchamos Laurel.
        assertTrue(result.contains("Laurel"));
    }
}

