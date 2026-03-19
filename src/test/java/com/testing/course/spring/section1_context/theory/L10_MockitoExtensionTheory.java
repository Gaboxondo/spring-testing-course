package com.testing.course.spring.section1_context.theory;

import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Sección 1 - L10: MockitoExtension vs SpringExtension.
 * 
 * En Spring Boot solemos abusar de @SpringBootTest o @ExtendWith(SpringExtension.class).
 * Sin embargo, si lo que estás testeando es un SERVICIO en solitario que no necesita 
 * de la base de datos ni de el contexto de Spring, lo ideal es usar MockitoExtension.
 * 
 * VENTAJAS:
 * 1. Mucho más rápido (segundos vs milisegundos).
 * 2. Puramente unitario.
 * 3. No levanta el servidor ni inyecta beans reales.
 */
@ExtendWith(MockitoExtension.class) // JUnit 5 extension for Mockito.
@DisplayName("Sección 1 - L10: MockitoExtension")
class L10_MockitoExtensionTheory {

    @Mock
    VetRepository vetRepository; // Mock standard de Mockito.

    @InjectMocks
    VetService vetService; // Mockito intentará inyectar los mocks arriba declarados.

    @Test
    @DisplayName("🧪 Verificar inyección de mocks sin contexto de Spring")
    void testStandardMockito() {
        // No hay @Autowired aquí. Spring NO está funcionando. ES Mockito puro.
        assertNotNull(vetRepository);
        assertNotNull(vetService);
    }
}

