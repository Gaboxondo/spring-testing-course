package com.testing.course.mockito.section2_advanced.solutions;

import com.testing.course.model.Vet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Solución L7: when().thenReturn() vs doReturn().when().
 */
@ExtendWith(MockitoExtension.class)
class L12_SyntaxStruggleSolution {

    @Spy
    Vet vetSpy = new Vet("Real", "Vet");

    @Test
    void testStubbingAvoidingRealMethod() {
        // SOLUCIÓN:
        doReturn("Mock").when(vetSpy).getFirstName();

        assertEquals("Mock", vetSpy.getFirstName());
    }
}
