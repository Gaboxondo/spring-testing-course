package com.testing.course.junit5.section3_advanced.solutions;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>SOLUCIÓN: Gestión de Datos Externos con @CsvFileSource</h1>
 * 
 * <p>Demuestra la carga de un CSV con múltiples columnas y la validación 
 * completa de la integridad de los datos inyectados para cada fila del fichero.</p>
 * 
 * <h2>Puntos Clave:</h2>
 * <ul>
 *   <li>Uso de <code>resources = "/csv/exercise_owners.csv"</code> para cargar el fichero externo.</li>
 *   <li>Uso de <code>numLinesToSkip = 1</code> para ignorar la cabecera del CSV.</li>
 *   <li>Aserciones múltiples para garantizar la integridad completa del objeto <code>Owner</code>.</li>
 *   <li>Mapeo directo de 4 parámetros desde el CSV al método de test.</li>
 * </ul>
 */
@DisplayName("Solución 6: Parameterized con CSV Externo")
@Tag("solution")
public class S6_AdvancedCsvFileSolution {

    private final OwnerService ownerService = new OwnerService();

    /**
     * TAREA SOLUCIONADA: Carga el fichero 'exercise_owners.csv' (con cabecera) 
     * y valida cada campo inyectado.
     * 
     * @param firstName Nombre del Owner.
     * @param lastName Apellido del Owner.
     * @param city Ciudad del Owner.
     * @param telephone Teléfono de contacto.
     */
    @ParameterizedTest(name = "[{index}] Procesando: {0} {1} de {2}")
    @CsvFileSource(resources = "/csv/exercise_owners.csv", numLinesToSkip = 1)
    @DisplayName("🧪 Test Solución: Validación Integridad Completa")
    void testMassiveOwnerLoad(String firstName, String lastName, String city, String telephone) {
        // 1. Configuramos el modelo con los datos del CSV
        Owner owner = new Owner(firstName, lastName);
        owner.setCity(city);
        owner.setTelephone(telephone);
        
        // 2. Ejecutar Guardado
        ownerService.save(owner);
        
        // 3. Recuperar y Validar Integridad Total
        Owner found = ownerService.findByLastName(lastName);
        assertAll("Verificación de Integridad de Campos",
            () -> assertNotNull(found, "El owner debería haberse guardado correctamente"),
            () -> assertEquals(firstName, found.getFirstName(), "El nombre no coincide"),
            () -> assertEquals(lastName, found.getLastName(), "El apellido no coincide"),
            () -> assertEquals(city, found.getCity(), "La ciudad no coincide"),
            () -> assertEquals(telephone, found.getTelephone(), "El teléfono no coincide"),
            () -> assertFalse(found.getTelephone().isEmpty(), "El teléfono no puede ser una cadena vacía")
        );
    }
}
