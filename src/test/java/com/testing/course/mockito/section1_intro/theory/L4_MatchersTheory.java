package com.testing.course.mockito.section1_intro.theory;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import com.testing.course.service.section1.MatchersSupportService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Argument Matchers (any, eq, etc.)</h1>
 * 
 * <p>Los Argument Matchers nos permiten ser flexibles al programar comportamientos 
 * (stubbing) u observar llamadas. En lugar de pasar un valor exacto, usamos 
 * comodines como <code>any()</code>, <code>anyString()</code>, etc.</p>
 * 
 * <h2>LA REGLA DE ORO DE LOS MATCHERS</h2>
 * <p>Si el método tiene <b>vários argumentos</b> y usas un Argument Matcher 
 * para uno de ellos, ¡DEBES usar Matchers para TODOS! No puedes mezclar matchers 
 * con valores constantes.</p>
 * <pre>
 *   // INCORRECTO: findBy(anyLong(), "Admin") -> Lanza InvalidUseOfMatchersException
 *   // CORRECTO:   findBy(anyLong(), eq("Admin")) -> Ambos son Matchers
 * </pre>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 1 - L4: Argument Matchers Avanzados")
class L4_MatchersTheory {

    @Mock
    private VetRepository vetRepository;

    @Mock
    private MatchersSupportService matchersService;

    @InjectMocks
    private VetService vetService;

    /**
     * <h2>CASO 1: Matchers en Stubbing (when)</h2>
     * <p><b>Qué hace:</b> Permite que el mock responda ante un rango de valores.</p>
     * <p><b>Cómo se usa:</b> <code>when(mock.metodo(any())).thenReturn(...)</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Mockeo flexible con anyLong() y Optional")
    void stubbingWithMatchers() {
        Vet newVet = new Vet("Vet", "Flexible");
        
        // Configuramos el mock para que responda a CUALQUIER ID de tipo Long
        when(vetRepository.findById(anyLong())).thenReturn(Optional.of(newVet));

        // Comprobamos que IDs distintos obtienen la misma respuesta programada
        assertNotNull(vetService.findById(1L));
        assertNotNull(vetService.findById(999L));
        
        verify(vetRepository, times(2)).findById(anyLong());
    }

    /**
     * <h2>CASO 2: La regla de mezcla (Uso de eq())</h2>
     * <p><b>Qué hace:</b> Demuestra cómo pasar un valor exacto cuando hay otros matchers 
     * en el mismo método.</p>
     * <p><b>Por qué:</b> Mockito no permite mezclar [any(), "string"]. Todo debe ser Matcher.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Mezclando matchers con eq()")
    void mixingMatchersDemo() {
        List<Vet> emptyList = new ArrayList<>();
        
        // MAL: when(matchersService.findBySpecialtyAndActive(anyString(), true)).thenReturn(emptyList);
        // BIEN: Debemos envolver el 'true' en eq() porque hay un 'anyString()' al lado.
        when(matchersService.findBySpecialtyAndActive(anyString(), eq(true))).thenReturn(emptyList);

        List<Vet> result = matchersService.findBySpecialtyAndActive("Surgery", true);
        
        assertNotNull(result);
        verify(matchersService).findBySpecialtyAndActive(eq("Surgery"), eq(true));
    }

    /**
     * <h2>CASO 3: Matchers de tipos específicos</h2>
     * <p><b>Qué hace:</b> Muestra el uso de matchers para tipos primitivos y Strings.</p>
     * <p><b>Cómo se usa:</b> <code>anyString()</code>, <code>anyInt()</code>, <code>anyBoolean()</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Matchers específicos (String/Int/List)")
    void specificMatchersDemo() {
        // Ejecutamos una llamada con valores reales
        matchersService.register("Dr. Stephen", 45, "London");

        // Verificamos usando matchers de tipos específicos para mayor claridad
        verify(matchersService).register(anyString(), anyInt(), anyString());
        
        // Otros ejemplos útiles:
        // anyList(), anySet(), anyMap(), anyIterable()
        // isNull(), isNotNull(), endsWith("..."), startsWith("...")
    }

    /**
     * <h2>CASO 4: Combinación de Matchers de texto</h2>
     * <p><b>Qué hace:</b> Demuestra matchers de texto más finos como startsWith.</p>
     */
    @Test
    @DisplayName("🧪 Demo 4: Matchers de texto avanzados")
    void textMatchersDemo() {
        matchersService.register("Gregory House", 50, "New Jersey");

        // Verificamos que el nombre empiece por "Gregory"
        verify(matchersService).register(startsWith("Gregory"), anyInt(), eq("New Jersey"));
    }
}
