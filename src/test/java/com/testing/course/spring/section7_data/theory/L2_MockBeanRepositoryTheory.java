package com.testing.course.spring.section7_data.theory;

import com.testing.course.model.Owner;
import com.testing.course.repository.OwnerRepository;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * <h1>TEORÍA: Aislamiento de Capas (@MockBean en Repositorios)</h1>
 * 
 * <p><b>Qué hace:</b> Sustituye el repositorio real de la base de datos por un 
 * mock de Mockito dentro del ApplicationContext global de Spring.</p>
 * 
 * <p><b>Por qué existe:</b> No siempre queremos una base de datos real (ni siquiera H2). 
 * A veces solo queremos testear la lógica del SERVICIO simulando el escenario 
 * de datos que necesitemos (ej: si el repo devuelve nulo, si lanza error de timeout, etc).</p>
 */
@SpringBootTest
@DisplayName("Sección 7 - L2: Control de Datos mediante MockBean")
class L2_MockBeanRepositoryTheory {

    @MockBean
    private OwnerRepository ownerRepository; 

    @Autowired
    private OwnerService ownerService; 

    /**
     * <h2>DEMO: Inyección de Mock en Servicio real</h2>
     * <p>Programamos el mock del repositorio para devolver a "Ruiz" y validamos 
     * que el servicio lo recibe y procesa correctamente.</p>
     */
    @Test
    @DisplayName("🧪 Demo 12: Simulación de flujo de datos (Service -> Repo Mock)")
    void testServiceWithMockedRepo() {
        Owner simulatedOwner = new Owner("Paco", "Ruiz");
        when(ownerRepository.findByLastName("Ruiz")).thenReturn(Optional.of(simulatedOwner));

        Owner result = ownerService.findByLastName("Ruiz");

        assertEquals("Paco", result.getFirstName());
    }
}
