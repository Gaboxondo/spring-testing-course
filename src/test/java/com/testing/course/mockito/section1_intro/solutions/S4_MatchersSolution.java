package com.testing.course.mockito.section1_intro.solutions;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * <h1>SOLUCIÓN: Domina los Argument Matchers</h1>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 1 - S4: Solución Argument Matchers")
class S4_MatchersSolution {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetService vetService;

    @Test
    @DisplayName("🧪 Solución Reto 1: Repositorio flexible con Matchers")
    void challengeMatchers() {
        // SOLUCIÓN: Usamos anyLong() para capturar cualqueir ID de tipo Long
        when(vetRepository.findById(anyLong())).thenReturn(new Vet("Vet", "Mock"));

        assertNotNull(vetRepository.findById(100L));
    }

    @Test
    @DisplayName("🧪 Solución Reto 2: Verificación tipada con any()")
    void challengeVerifyAny() {
        vetService.save(new Vet("Paco", "Ruiz"));

        // SOLUCIÓN: Usamos any(Vet.class) para verificar que se envió un objeto del tipo correcto
        verify(vetRepository).save(any(Vet.class));
    }
}
