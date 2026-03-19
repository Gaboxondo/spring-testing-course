package com.testing.course.mockito.section2_advanced.solutions;

import com.testing.course.model.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Solución L12: Uso de Mockito Spies.
 */
@ExtendWith(MockitoExtension.class)
class S6_SpyMockingSolution {

    @Spy
    Owner owner = new Owner("Real", "Name");

    @Test
    void testSpyBehaviour() {
        // SOLUCIÓN:
        assertEquals("Real", owner.getFirstName());

        doReturn("Espía").when(owner).getFirstName();

        assertEquals("Espía", owner.getFirstName());
        
        verify(owner, times(2)).getFirstName();
    }
}

