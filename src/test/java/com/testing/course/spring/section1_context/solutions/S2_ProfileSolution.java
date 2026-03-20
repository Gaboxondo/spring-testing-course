package com.testing.course.spring.section1_context.solutions;

import com.testing.course.spring.config.HearingConfig;
import com.testing.course.spring.service.WordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución L8: El Desafío Yanny (Perfiles).
 */
@ActiveProfiles("yanny")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HearingConfig.class})
class S2_ProfileSolution {

    @Autowired
    private WordService wordService;

    @Test
    void testHearingYanny() {
        assertEquals("Yanny", wordService.getWord());
    }
}
