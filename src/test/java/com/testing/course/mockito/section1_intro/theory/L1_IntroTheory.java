package com.testing.course.mockito.section1_intro.theory;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * TEORÍA SECCIÓN 9: Introducción a Mockito (Mocks Inline).
 * 
 * Basado en: Section 9 - Lección 104.
 * 
 * DETALLE FINO:
 * - Un 'Mock' es un objeto simulado que reemplaza a una dependencia real.
 * - En esta clase usamos Mockito INLINE (creándolo manualmente con mock()).
 */
@DisplayName("Teoría: Mockito Inline (Manual)")
class L1_IntroTheory {

    @Test
    @DisplayName("🧪 Demo 1: Crear un mock manualmente")
    void mockManualDemo() {
        // 1. Crear el mock del repositorio (Interfaz)
        VetRepository vetRepository = mock(VetRepository.class);
        
        // 2. Inyectar manualmente en el servicio
        VetService vetService = new VetService(vetRepository);
        
        // 3. Programar comportamiento (Stubbing)
        when(vetRepository.findAll()).thenReturn(Collections.singletonList(new Vet("Test", "Vet")));

        // 4. Ejecutar
        assertNotNull(vetService.findAll());
        
        // 5. Verificar que se llamó al repositorio
        verify(vetRepository).findAll();
    }
}

