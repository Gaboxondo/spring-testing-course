package com.testing.course.spring.section1_context.solutions;

import com.testing.course.spring.config.HearingConfig;
import com.testing.course.spring.service.HearingInterpreter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución L7: El Contexto de Spring Veterinario.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
class S1_HearingSolution {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    void testHearingLaurel() {
        // SOLUCIÓN:
        String result = hearingInterpreter.whatDidIHear();
        assertTrue(result.contains("Laurel"));
    }
}

