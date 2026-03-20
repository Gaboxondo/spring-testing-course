package com.testing.course.junit5.section3_advanced.exercises;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>EJERCICIO: Gestión de Datos Externos con @CsvFileSource</h1>
 * 
 * <p>Objetivo: Validar que el sistema procesa correctamente múltiples registros 
 * complejos desde un fichero CSV externo.</p>
 * 
 * <h2>Requisitos del ejercicio:</h2>
 * <ol>
 *   <li>Cargar datos desde <code>/csv/exercise_owners.csv</code>.</li>
 *   <li>Saltar la línea de cabecera.</li>
 *   <li>Instanciar un <code>Owner</code> con todos los campos disponibles (firstName, lastName, city, telephone).</li>
 *   <li>Guardar el owner en <code>OwnerService</code>.</li>
 *   <li>Verificar que todos los campos coinciden exactamente con la fuente de datos.</li>
 *   <li>Añadir una validación de negocio: El número de teléfono no debe ser nulo ni vacío.</li>
 * </ol>
 */
@DisplayName("Ejercicio 6: Parameterized con CSV Externo")
@Tag("exercise")
public class EX6_AdvancedCsvFileExercise {

    private final OwnerService ownerService = new OwnerService();

    /**
     * TAREA: Implementar un test parametrizado que cargue el fichero 
     * 'exercise_owners.csv' y valide la integridad de los datos inyectados.
     * 
     * <p>El CSV tiene 4 columnas: firstName, lastName, city, telephone.</p>
     */
    @ParameterizedTest(name = "[{index}] Procesando: {0} {1} de {2}")
    @Disabled("Deshabilitado: Implementar lógica del ejercicio en S6")
    @CsvFileSource(resources = "/csv/exercise_owners.csv", numLinesToSkip = 1)
    @DisplayName("🧪 Test: Validación Masiva de Owners")
    void testMassiveOwnerLoad(String firstName, String lastName, String city, String telephone) {
        // TODO: Implementar lógica de guardado y aserciones múltiples.
        // 1. Crear Owner y setear campos city y telephone.
        // 2. Guardar en ownerService.
        // 3. Recuperar y validar integridad total de campos.
        // 4. Validar que el telefono no sea nulo.
    }
}
