package com.testing.course.mockito.section3_advanced.theory;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;
import com.testing.course.service.VisitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Verificaciones Avanzadas de Interacción</h1>
 * 
 * <p><b>Qué hace:</b> Proporciona herramientas para asegurar que las interacciones 
 * con los colaboradores ocurren bajo condiciones estrictas de orden y frecuencia.</p>
 * 
 * <p><b>Por qué existe:</b> En sistemas transaccionales, el orden de los factores 
 * SI altera el producto. Necesitamos garantizar que, por ejemplo, el pago ocurre 
 * antes que el envío de un producto.</p>
 * 
 * <h2>Técnicas Avanzadas:</h2>
 * <ul>
 *   <li><b>InOrder:</b> Rastrea el orden cronológico exacto de las llamadas 
 *   incluso entre diferentes mocks.</li>
 *   <li><b>verifyNoMoreInteractions:</b> Asegura que no hubo llamadas "fantasma" 
 *   fuera de las específicamente verificadas en el test.</li>
 *   <li><b>verifyNoInteractions:</b> Comprueba que un colaborador específico nunca 
 *   fue tocado durante el flujo.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L3: Verificaciones y Orden de Ejecución")
class L3_VerificationAdvancedTheory {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitService visitService;

    /**
     * <h2>DEMO: InOrder y Cero interacciones inesperadas</h2>
     * <p>Garantizamos que el sistema guarda las visitas en la secuencia exacta en la 
     * que fueron recibidas, bloqueando cualquier otra interacción no deseada.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: Orden estricto y Verificación No More Interactions")
    void advancedVerificationDemo() {
        Visit visit1 = new Visit("Vacuna", null);
        Visit visit2 = new Visit("Desparasitación", null);

        // Ejecutar flujo
        visitService.save(visit1);
        visitService.save(visit2);

        // Configurar el verificador de orden para el repositorio
        InOrder inOrder = inOrder(visitRepository);
        
        // Las verificaciones deben seguir el orden del código de producción
        inOrder.verify(visitRepository).save(visit1);
        inOrder.verify(visitRepository).save(visit2);
        
        // Bloquear cualquier otra llamada sorpresa
        verifyNoMoreInteractions(visitRepository);
    }
}
