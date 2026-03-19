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
 * Sección 7 - L2: Simulando la BBDD con @MockBean.
 * 
 * ¿Y si mi aplicación usa MongoDB o una BBDD cloud pesada y lenta?
 * No siempre queremos H2. A veces solo queremos testear la lógica 
 * del SERVICE simulando lo que devuelve el REPOSITORY.
 * 
 * @MockBean permite inyectar un Mock de Mockito EN EL CONTEXTO de Spring.
 * Esto sustituye el bean real de la BBDD por un simulacro controlado.
 */
@SpringBootTest
@DisplayName("Sección 7 - L2: Mockeando Repositorios")
class L2_MockBeanRepositoryTheory {

    @MockBean
    OwnerRepository ownerRepository; // Inyecta un mock en el contexto de Spring.

    @Autowired
    OwnerService ownerService; // Spring inyectará el mock arriba declarado dentro de este service.

    @Test
    @DisplayName("🧪 Testear Service simulando respuesta del Repository")
    void testServiceWithMockedRepo() {
        // GIVEN: El Repo simulará que ha encontrado a "Ruiz"
        Owner simulatedOwner = new Owner("Paco", "Ruiz");
        when(ownerRepository.findByLastName("Ruiz")).thenReturn(Optional.of(simulatedOwner));

        // WHEN: El Service hace su trabajo
        Owner result = ownerService.findByLastName("Ruiz");

        // THEN: Los asserts comprueban que el service recibió el dato del mock
        assertEquals("Paco", result.getFirstName());
    }
}
