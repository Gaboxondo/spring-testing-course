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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Argument Matchers (any, eq, etc.)</h1>
 * 
 * <p>Los Argument Matchers nos permiten ser flexibles al programar comportamientos 
 * (stubbing) o verificar llamadas. En lugar de pasar un objeto exacto, usamos 
 * comodines como <code>any()</code>, <code>anyString()</code>, etc.</p>
 * 
 * <h2>LA REGLA DE ORO DE LOS MATCHERS</h2>
 * <p>Si el método tiene <b>vários argumentos</b> y usas un Argument Matcher 
 * para uno de ellos, ¡DEBES usar Matchers para TODOS! No puedes mezclar matchers 
 * con valores constantes.</p>
 * <pre>
 *   // INCORRECTO: findBy(anyLong(), "Admin") -> Mezcla Matcher con Constante
 *   // CORRECTO:   findBy(anyLong(), eq("Admin")) -> Ambos son Matchers
 * </pre>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 1 - L4: Argument Matchers (Flexibilidad en Tests)")
class L4_MatchersTheory {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetService vetService;

    /**
     * <h2>CASO 1: Matchers en Stubbing (when)</h2>
     * <p>Permite que el mock responda ante un rango de valores, no solo uno específico.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Mockeo flexible con anyLong()")
    void stubbingWithMatchers() {
        // Configuramos el mock para que responda a CUALQUIER ID de tipo Long
        Vet newVet = new Vet("Vet", "Flexible");
        when(vetRepository.findById(anyLong())).thenReturn( Optional.of( newVet ) );

        // Llamadas con distintos IDs responden igual
        assertNotNull(vetRepository.findById(1L));
        assertNotNull(vetRepository.findById(999L));
        
        verify(vetRepository, times(2)).findById(anyLong());
    }

    /**
     * <h2>CASO 2: La regla de mezcla (eq Matcher)</h2>
     * <p>Cuando queremos usar un valor fijo junto con un matcher, debemos envolver 
     * el valor fijo en <code>eq(...)</code>.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Mezclando matchers con eq()")
    void mixingMatchersDemo() {
        // Imagina un método con dos parámetros: updateVet(Long id, String name)
        // INCORRECTO: verify(mock).updateVet(anyLong(), "Nuevo Nombre"); 
        // CORRECTO:   verify(mock).updateVet(anyLong(), eq("Nuevo Nombre"));
        
        // En este curso usamos save(Vet) que solo tiene 1 argumento, pero es 
        // vital recordar esta regla para métodos multi-parámetro.
        
        vetRepository.save(new Vet("Dr. House", "Gregory"));
        
        // Verificación exacta (por defecto si no usas matchers)
        // verify(vetRepository).save(new Vet("Dr. House", "Gregory")); // FALLARÍA si la instancia es distinta
        
        // Verificación flexible pero tipada
        verify(vetRepository).save(any(Vet.class));
    }

    /**
     * <h2>CASO 3: Matchers de tipos primitivos</h2>
     * <p>Mockito ofrece matchers específicos para mayor claridad: 
     * <code>anyString()</code>, <code>anyInt()</code>, <code>anyBoolean()</code>, etc.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Matchers de tipos String/Int")
    void primitiveMatchersDemo() {
        // findByFirstName(anyString())
        // anyList(), anyMap(), anyIterable()
        assertTrue(true, "Documentación: Consulta la API de ArgumentMatchers para ver todos los tipos.");
    }

    // Método de soporte para el aserto final
    private void assertTrue(boolean val, String msg) {}
}
