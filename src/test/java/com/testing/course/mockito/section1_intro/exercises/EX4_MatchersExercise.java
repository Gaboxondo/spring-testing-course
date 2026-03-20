package com.testing.course.mockito.section1_intro.exercises;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import com.testing.course.service.section1.MatchersSupportService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * <h1>EJERCICIO: Domina los Argument Matchers</h1>
 * 
 * <p>En este reto, aplicarás <code>any()</code>, <code>eq()</code> 
 * y configurarás stubs flexibles para que tus tests sean más robustos.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 1 - EX4: Reto Argument Matchers")
class EX4_MatchersExercise {

    @Mock
    private VetRepository vetRepository;

    @Mock
    private MatchersSupportService matchersService;

    @InjectMocks
    private VetService vetService;

    /**
     * RETO 1: Búsqueda flexible.
     * <p>Configura el mock de vetRepository.findById(...) para que devuelva 
     * un Vet("Vet", "Mock") envuelto en un Optional sin importar el ID.</p>
     */
    @Test
    @Disabled("Ejercicio pendiente de completar")
    @DisplayName("🧪 Reto 1: Repositorio flexible con Matchers")
    void challengeMatchers() {
        // TODO 1: Configurar el stubbing para devolver un nuevo Vet("Vet", "Mock") envuelto en Optional.
        // PISTA: when(vetRepository.findById(anyLong())).thenReturn(Optional.of(new Vet(...)));
        
        // --- CODIGO A COMPLETAR ---
        
        // --------------------------

        // Comprobación
        assertNotNull(vetRepository.findById(100L).orElse(null));
    }

    /**
     * RETO 2: Verificación de coincidencia.
     * <p>Verifica que se llamó a <code>vetRepository.save</code> con un objeto 
     * que sea de la clase <code>Vet.class</code>.</p>
     */
    @Test
    @Disabled("Ejercicio pendiente de completar")
    @DisplayName("🧪 Reto 2: Verificación tipada con any()")
    void challengeVerifyAny() {
        // Ejecutamos la acción del servicio
        vetService.save(new Vet("Paco", "Ruiz"));

        // TODO 2: Verifica que el save(Vet) ocurrió con CUALQUIER Vet.
        // PISTA: verify(mock).metodo(any(Tipo.class));
        
        // --- CODIGO A COMPLETAR ---
        
        // --------------------------
    }

    /**
     * RETO 3: La Regla de Mezcla (eq).
     * <p>Configura matchersService.findBySpecialtyAndActive() para que 
     * no importe la especialidad pero el estado sea obligatoriamente 'false'.</p>
     */
    @Test
    @Disabled("Ejercicio pendiente de completar")
    @DisplayName("🧪 Reto 3: Mezclando con eq()")
    void challengeMixing() {
        // TODO 3: Configurar el stubbing usando matchers para ambos argumentos.
        // PISTA: No puedes poner (... anyString(), false ...)
        
        // --- CODIGO A COMPLETAR ---
        
        // --------------------------
        
        assertNotNull(matchersService.findBySpecialtyAndActive("Dermatology", false));
    }
}
