package com.testing.course.spring.section8_features.theory;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

/**
 * <h1>TEORÍA: Sustitución Avanzada con MockitoSpyBean</h1>
 * 
 * <p><b>Qué hace:</b> Envuelve un Bean existente del ApplicationContext 
 * (el real de producción) en un "Spy" de Mockito.</p>
 * 
 * <p><b>Por qué existe:</b> A diferencia de <code>@TestConfiguration</code> 
 * o <code>@MockitoBean</code> (que crean un mock vacío), 
 * <code>@MockitoSpyBean</code> permite que el Bean mantenga su lógica real 
 * pero dándonos la capacidad de interceptar y sobrescribir métodos específicos.</p>
 * 
 * <h2>Diferencia con @TestConfiguration:</h2>
 * <p>Mientras que <code>@TestConfiguration</code> requiere una clase estática 
 * compleja con <code>@Bean</code> y <code>@Primary</code>, 
 * <code>@MockitoSpyBean</code> lo hace automáticamente con una sola anotación 
 * en una variable miembro del test.</p>
 */
@SpringBootTest
@DisplayName("Sección 8 - L4: Sobrescritura ágil mediante MockitoSpyBean")
class L4_MockitoSpyBeanTheory {

    // SOLUCIÓN: Declaramos un espía que reemplaza al Bean real en el contexto
    // No necesitamos @TestConfiguration ni @Primary, Spring se encarga de todo.
    @MockitoSpyBean
    private OwnerService ownerService;

    /**
     * <h2>DEMO: Interceptación parcial de un Bean real</h2>
     * <p>Configuramos el espía para que solo cuando busquemos a "Especial", 
     * devuelva un dato preparado, pero que el resto de llamadas sigan 
     * ejecutando la lógica real del servicio.</p>
     */
    @Test
    @DisplayName("🧪 Demo 16: Espiando y alterando comportamiento de servicios reales")
    void testSpyOverride() {
        // Configuramos solo un comportamiento específico en el espía
        Owner mockOwner = new Owner("Nombre", "Especial");
        doReturn(mockOwner).when(ownerService).findByLastName("Especial");

        // Verificamos que al llamar a "Especial", devuelve nuestro mock
        Owner result = ownerService.findByLastName("Especial");
        
        assertEquals("Nombre", result.getFirstName());
        assertEquals("Especial", result.getLastName());
    }
}
