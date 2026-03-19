package com.testing.course.mockito.section2_advanced.exercises;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Ejercicio L14_PartialMockExercise_PartialMockExercise_PartialMockExercise: Mocks Parciales (@Spy) vs @Mock.
 * 
 * Basado en: Section 2 - L5_PartialMockTheory.
 * 
 * OBJETIVO: Mockear el método validateOwner() en OwnerService mientras el resto sigue Real.
 */
@ExtendWith(MockitoExtension.class)
class L14_PartialMockExercise {

    @Spy
    OwnerService ownerServiceSpy;

    @Test
    void testPartialMockValidation() {
        Owner owner = new Owner("Test", "Spy");

        // TODO 1: Usa doNothing().when(...) para mockear el método validateOwner(any());
        
        // TODO 2: Llama a ownerServiceSpy.save(owner);
        
        // TODO 3: Comprueba que ownerServiceSpy.getOwnerCount() es 1.
        // Esto demuestra que save() fue REAL, pero validateOwner() fue MOCKEADO.
    }
}
