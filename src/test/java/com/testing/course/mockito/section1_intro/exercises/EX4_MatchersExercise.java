package com.testing.course.mockito.section1_intro.exercises;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
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

    @InjectMocks
    private VetService vetService;

    /**
     * RETO 1: Búsqueda flexible.
     * <p>Configura el mock de vetRepository.findById(...) para que devuelva 
     * un Vet("Vet", "Mock") sin importar cuál sea el ID que se le pase.</p>
     */
    @Test
    @Disabled("Ejercicio pendiente de completar")
    @DisplayName("🧪 Reto 1: Repositorio flexible con Matchers")
    void challengeMatchers() {
        // TODO 1: Configurar el stubbing para devolver un nuevo Vet("Vet", "Mock")
        // PISTA: replace the null with a call to id matching any value
        // when(vetRepository.findById(???)).thenReturn(new Vet(...));
        
        // --- CODIGO A COMPLETAR ---
        
        // --------------------------

        // TODO 2: Llama a findById con el ID 100 y comprueba que NO es nulo.
        // assertNotNull(vetRepository.findById(100L));
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
}
