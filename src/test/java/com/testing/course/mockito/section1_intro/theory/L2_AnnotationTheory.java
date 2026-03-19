package com.testing.course.mockito.section1_intro.theory;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * TEORÍA SECCIÓN 9: Mockito con Anotaciones e Inyección.
 * 
 * Basado en: Section 9 - Lecciones 105, 106, 107.
 * 
 * DETALLE FINO:
 * - @Mock: Crea una instancia simulada de la dependencia.
 * - @InjectMocks: Crea una instancia REAL de la clase bajo test y le "inyecta" 
 *   los mocks marcados con @Mock de forma automática.
 * - @ExtendWith(MockitoExtension.class): Activa el motor de Mockito para JUnit 5.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Teoría: Mockito con Anotaciones")
class L2_AnnotationTheory {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetService vetService;

    @Test
    @DisplayName("🧪 Demo 2: Trabajo profesional con inyección automática")
    void mockAnnotationDemo() {
        // Programar el comportamiento del mock inyectado
        when(vetRepository.findAll()).thenReturn(Collections.singletonList(new Vet("Test", "LastName")));

        // Ejecutar el método del servicio REAL (que usa el mock inyectado)
        assertNotNull(vetService.findAll());

        // Verificar que el servicio llamó al mock
        verify(vetRepository, times(1)).findAll();
    }
}
