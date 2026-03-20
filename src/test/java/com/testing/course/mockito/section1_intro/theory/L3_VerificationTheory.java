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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Verificaciones y Comprobación de Interacciones</h1>
 * 
 * <p><b>Qué hace:</b> Se centra en el uso de <code>verify()</code> para asegurar 
 * que el objeto bajo test interactúa correctamente con sus dependencias.</p>
 * 
 * <p><b>Por qué existe:</b> En métodos que no devuelven nada (void), no podemos 
 * usar aserciones tradicionales. La única forma de saber si el código funciona es 
 * verificando que realizó las llamadas esperadas a sus colaboradores.</p>
 * 
 * <h2>conceptos clave:</h2>
 * <ul>
 *   <li><b>'verify':</b> Comprueba que una llamada ocurrió con parámetros exactos o matchers.</li>
 *   <li><b>'any()':</b> Argument Matcher básico que acepta cualquier objeto del tipo especificado.</li>
 *   <li><b>'times(n)':</b> Verificador de cardinalidad (frecuencia de llamadas).</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 1 - L3: Verificaciones y Matchers Básicos")
class L3_VerificationTheory {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetService vetService;

    /**
     * <h2>DEMO: Argument Matchers y Verificación de cardinalidad</h2>
     * <p>Comprobamos que al salvar un veterinario, el servicio llama al repositorio 
     * exactamente el número de veces esperado.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Verificación de llamadas y uso de any()")
    void verificationDemo() {
        // Ejecutar acción
        vetService.save(new Vet("Paco", "Ruiz"));

        // Verificar que el repositorio recibió CUALQUIER objeto tipo Vet
        verify(vetRepository).save(any(Vet.class));
        
        // Verificar frecuencia exacta (1 vez)
        verify(vetRepository, times(1)).save(any(Vet.class));
    }
}
