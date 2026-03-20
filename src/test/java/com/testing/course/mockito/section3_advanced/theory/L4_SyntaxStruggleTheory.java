package com.testing.course.mockito.section3_advanced.theory;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: El duelo de Sintaxis (when vs doReturn)</h1>
 * 
 * <p><b>Qué hace:</b> Compara las dos formas principales de configurar stubs en 
 * Mockito, analizando su seguridad de tipado y su impacto en objetos reales (spies).</p>
 * 
 * <p><b>Por qué existe:</b> Es uno de los puntos de mayor confusión. Mientras que 
 * <code>when().thenReturn()</code> es intuitivo y tipado, <code>doReturn().when()</code> 
 * es imprescindible para evitar la ejecución accidental de código real en Spies.</p>
 * 
 * <h2>Comparativa Técnica:</h2>
 * <ul>
 *   <li><b>when().thenReturn():</b> 100% Type-Safe. El compilador valida los tipos. 
 *   Ideal para <code>@Mock</code>.</li>
 *   <li><b>doReturn().when():</b> No es Type-Safe en tiempo de compilación. 
 *   <b>Evita la ejecución del método real</b> durante la configuración. Obligatorio para <code>@Spy</code>.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 3 - L4: when().thenReturn() vs doReturn().when()")
class L4_SyntaxStruggleTheory {

    @Mock
    private VetRepository vetRepository;

    @Spy
    private Vet vetSpy = new Vet("Real", "Vet");

    /**
     * <h2>CASO 1: La comodidad y seguridad de when()</h2>
     * <p>Al usar un mock puro, el método no tiene cuerpo real, por lo que 
     * <code>when()</code> es seguro y además nos protege con tipos genéricos.</p>
     */
    @Test
    @DisplayName("🧪 Demo 5: Stubbing tradicional y seguro")
    void testWhenThenReturn() {
        when(vetRepository.findById(1L)).thenReturn(Optional.of(new Vet("Mock", "Vet")));
        assertTrue(vetRepository.findById(1L).isPresent());
    }

    /**
     * <h2>CASO 2: La necesidad de doReturn() en Spies</h2>
     * <p>Si usamos <code>when(spy.getFirstName())</code>, Java intentará entrar 
     * físicamente en el método del objeto real antes de que Mockito pueda interceptarlo. 
     * <code>doReturn</code> soluciona este problema "invisible".</p>
     */
    @Test
    @DisplayName("🧪 Demo 6: Stubbing de Spies con doReturn")
    void testDoReturnWhen() {
        // Mockito intercepta la llamada sin ejecutar el código real de Vet.getFirstName()
        doReturn("Mocked Name").when(vetSpy).getFirstName();
        
        assertEquals("Mocked Name", vetSpy.getFirstName());
    }
}
