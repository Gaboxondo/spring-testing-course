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
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * <h1>TEORÍA: Mockito con Anotaciones (@Mock, @InjectMocks)</h1>
 * 
 * <p><b>Qué hace:</b> Automatiza la creación e inyección de objetos simulados 
 * mediante el uso de anotaciones y la extensión de JUnit 5.</p>
 * 
 * <p><b>Por qué existe:</b> Reduce el código repetitivo (biolerplate) de instanciación manual 
 * y mejora la legibilidad de la clase de test al declarar las dependencias de forma clara.</p>
 * 
 * <h2>Anotaciones Principales:</h2>
 * <ul>
 *   <li><b>@Mock:</b> Crea una instancia simulada (mock) de la interfaz o clase marcada.</li>
 *   <li><b>@InjectMocks:</b> Crea una instancia REAL de la clase bajo prueba e intenta 
 *   inyectarle automáticamente los mocks definidos anteriormente.</li>
 *   <li><b>@ExtendWith(MockitoExtension.class):</b> Indica a JUnit 5 que debe inicializar 
 *   el motor de Mockito antes de ejecutar los tests.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 1 - L2: Mockito con Anotaciones e Inyección")
class L2_AnnotationTheory {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetService vetService;

    /**
     * <h2>DEMO: Trabajo profesional con inyección automática</h2>
     * <p>En este flujo, Mockito se encarga de instanciar <code>VetService</code> 
     * y pasarle el <code>VetRepository</code> (mock) por su constructor.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Inyección automática de dependencias")
    void mockAnnotationDemo() {
        // Programar el comportamiento del mock inyectado
        when(vetRepository.findAll()).thenReturn(Collections.singletonList(new Vet("Test", "LastName")));

        // Ejecutar el método del servicio REAL
        assertNotNull(vetService.findAll());

        // Verificar la interacción
        verify(vetRepository, times(1)).findAll();
    }
}
