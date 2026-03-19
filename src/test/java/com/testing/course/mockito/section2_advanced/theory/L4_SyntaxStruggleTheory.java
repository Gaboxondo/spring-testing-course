package com.testing.course.mockito.section2_advanced.theory;

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
 * Sección 2 - L10: La lucha de Sintaxis (when vs doReturn).
 * 
 * Es uno de los puntos donde más se lían los alumnos al empezar con Spies.
 * Mockito ofrece dos formas de programar comportamiento (stubbing), cada una con pros y contras.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - L10: when().thenReturn() vs doReturn().when()")
class L4_SyntaxStruggleTheory {

    @Mock
    VetRepository vetRepository;

    @Spy
    Vet vetSpy = new Vet("Real", "Vet");

    /**
     * SINTAXIS: when(mock.metodo()).thenReturn(valor)
     * 
     * 1. TYPE-SAFE: Al escribir 'when(vetRepository.findAll())', Mockito detecta que findAll() 
     *    devuelve una 'Collection<Vet>'. El compilador fallará si intentas usar thenReturn(123).
     * 
     * 2. EL PITFALL (Peligro): Para evaluar el 'when', Java primero TIENE que ejecutar 
     *    'vetRepository.findAll()'. 
     *    - Si el objeto es un @Mock (hueco), no pasa nada.
     *    - Si el objeto es un @Spy (real), ¡SE EJECUTA EL CÓDIGO REAL DEL MÉTODO! 
     *      Si ese código lanza una excepción o borra algo, tu test fallará antes de ser mockeado.
     */
    @Test
    @DisplayName("🧪 Uso de when().thenReturn() (Tradicional y Seguro para Mocks)")
    void testWhenThenReturn() {
        // JpaRepository.findById devuelve Optional<Vet>. Debemos usar Optional.of().
        when(vetRepository.findById(1L)).thenReturn(Optional.of(new Vet("Mock", "Vet")));
        
        assertTrue(vetRepository.findById(1L).isPresent());
    }

    /**
     * SINTAXIS: doReturn(valor).when(mock).metodo()
     * 
     * 1. NO ES TYPE-SAFE: 'doReturn' acepta un 'Object'. Podrías intentar devolver un Elefante 
     *    donde se espera un Perro y el compilador no dirá nada hasta que ejecutes el test.
     * 
     * 2. LA VENTAJA (Obligatorio para Spies): Con esta sintaxis, Mockito primero recibe la orden 
     *    de qué devolver y LUEGO se le indica el método. Esto evita que el método REAL se llegue 
     *    a ejecutar durante la configuración.
     */
    @Test
    @DisplayName("🧪 Uso de doReturn().when() (Imprescindible para Spies)")
    void testDoReturnWhen() {
        // Si usáramos when(vetSpy.getFirstName()).thenReturn("Mock"), Java entraría 
        // en el método getFirstName() real de la clase Vet antes de mockearlo.
        
        // Con doReturn, Mockito 'atrapa' la llamada al vuelo sin ejecutarla.
        doReturn("Mock").when(vetSpy).getFirstName();
        
        assertEquals("Mock", vetSpy.getFirstName());
    }
}

