package com.testing.course.mockito.section1_intro.theory;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import com.testing.course.service.VetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Introducción a Mockito (Mocks Manuales)</h1>
 * 
 * <p>Esta sección introduce los conceptos básicos de <b>Mocking</b> 
 * y cómo desacoplar las dependencias del código bajo prueba (SUT).</p>
 * 
 * <h2>Principios Clave:</h2>
 * <ul>
 *   <li><b>¿Qué es un Mock?</b> Es un objeto simulado que reemplaza 
 *   una dependencia real (como un repositorio o un cliente web), 
 *   permitiéndonos controlar su comportamiento.</li>
 *   <li><b>Mocking Manual (Inline):</b> Creamos el mock programáticamente 
 *   usando el método estático <code>mock(Clase.class)</code> de Mockito.</li>
 *   <li><b>Stubbing:</b> Proceso de definir qué debe devolver el mock ante 
 *   determinadas entradas (usando <code>when(...).thenReturn(...)</code>).</li>
 * </ul>
 * 
 * <p><b>¿Cuándo usarlo?</b> Especialmente útil para inyecciones en constructores 
 * complejas o cuando no queremos usar extensiones de JUnit por algún motivo específico.</p>
 * 
 * @see org.mockito.Mockito
 * @since 1.0
 */
@DisplayName("Teoría: Mockito Inline (Manual)")
class L1_IntroTheory {

    /**
     * TAREA DEMO 1: Creación e inyección manual de un Mock.
     * <p>Paso a paso: creación de mock, inyección en servicio, stubbing, 
     * ejecución de lógica y verificación de interacción final.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: Crear un mock manualmente")
    void mockManualDemo() {
        // 1. Crear el mock del repositorio (Interfaz VetRepository)
        VetRepository vetRepository = mock(VetRepository.class);
        
        // 2. Inyectar manualmente el mock en el constructor del servicio
        VetService vetService = new VetService(vetRepository);
        
        // 3. Programar comportamiento (Stubbing): decimos qué debe devolver
        when(vetRepository.findAll()).thenReturn(Collections.singletonList(new Vet("Dra.", "Mascotas")));

        // 4. Ejecutar el método del servicio que usa la dependencia mockeada
        assertNotNull(vetService.findAll(), "La lista devuelta por el servicio no debería ser nula");
        
        // 5. Verificar que el servicio realmente hizo la llamada al repositorio
        verify(vetRepository, times(1)).findAll();
    }
}
