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
 * <h1>TEORÍA: Mockito puro vs Integración con Spring</h1>
 * 
 * <p><b>Qué hace:</b> Compara el uso de <code>MockitoExtension</code> contra 
 * <code>SpringExtension</code> para el testeo de servicios unitarios.</p>
 * 
 * <p><b>Por qué existe:</b> En Spring Boot existe la tentación de usar @SpringBootTest para todo. 
 * Sin embargo, para testear lógica pura de un servicio, los tests de Mockito son órdenes 
 * de magnitud más rápidos (ms vs s).</p>
 * 
 * <h2>Diferencias Clave:</h2>
 * <ul>
 *   <li><b>SpringExtension:</b> Lenta. Levanta Beans reales. Test de Integración.</li>
 *   <li><b>MockitoExtension:</b> Ultra-rápida. Mocks puros. Test Unitario puro.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 1 - L6: Mockito puro sin ApplicationContext")
class L6_MockitoExtensionTheory {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetService vetService;

    /**
     * <h2>DEMO: Inyección simple de Mockito</h2>
     * <p>Comprobamos que las dependencias están disponibles incluso sin tener 
     * un servidor Spring arrancado de fondo.</p>
     */
    @Test
    @DisplayName("🧪 Demo 6: Test unitario ultra-rápido con Mockito puro")
    void testStandardMockito() {
        assertNotNull(vetRepository);
        assertNotNull(vetService);
    }
}
