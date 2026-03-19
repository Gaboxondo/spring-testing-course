package com.testing.course.mockito.section9_intro.theory;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * TEORÍA SECCIÓN 9: Verificaciones y Argument Matchers.
 * 
 * Basado en: Section 9 - Lecciones 108, 112.
 * 
 * DETALLE FINO:
 * - 'verify': Comprueba LA LLAMADA al mock.
 * - 'any()': Es un Argument Matcher que acepta CUALQUIER objeto de ese tipo.
 * - 'times(n)': Es un verificador que comprueba el NÚMERO exacto de veces que ocurre la llamada.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Teoría: Verificaciones y Matchers")
class MockitoVerificationTheory {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetService vetService;

    @Test
    @DisplayName("🧪 Demo 3: Argument Matchers y Verificación")
    void verificationDemo() {
        // Ejecutar llamada real del servicio
        vetService.save(new Vet("Paco", "Ruiz"));

        // Verificar que el repositorio recibió CUALQUIER objeto tipo Vet
        // PISTA: No es necesario usar 'when' si el método devuelve void.
        verify(vetRepository).save(any(Vet.class));
        
        // Verificar que se llamó exactamente 1 vez
        verify(vetRepository, times(1)).save(any(Vet.class));
    }
}
