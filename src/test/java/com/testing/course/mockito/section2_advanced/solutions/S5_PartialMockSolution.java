package com.testing.course.mockito.section2_advanced.solutions;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Solución L9: Mocks Parciales (@Spy) vs @Mock.
 */
@ExtendWith(MockitoExtension.class)
class S5_PartialMockSolution {

    @Spy
    OwnerService ownerServiceSpy;

    @Test
    void testPartialMockValidation() {
        // SOLUCIÓN:
        Owner owner = new Owner("Test", "Spy");

        doNothing().when(ownerServiceSpy).validateOwner(any());

        ownerServiceSpy.save(owner);

        assertEquals(1, ownerServiceSpy.getOwnerCount());
        verify(ownerServiceSpy).validateOwner(any());
    }
}

