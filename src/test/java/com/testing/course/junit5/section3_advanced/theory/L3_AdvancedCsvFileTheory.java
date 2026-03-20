package com.testing.course.junit5.section3_advanced.theory;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * <h1>TEORÍA: Tests Parametrizados con Fuentes Externas (@CsvFileSource)</h1>
 * 
 * <p>En aplicaciones reales, los conjuntos de datos de prueba pueden ser extensos. 
 * Mantenerlos dentro del código Java (@CsvSource) puede ensuciar la clase de test 
 * y dificultar el mantenimiento.</p>
 * 
 * <h2>Principios de @CsvFileSource:</h2>
 * <ul>
 *   <li><b>Separación de Preocupaciones:</b> Los datos residen en recursos externos (ficheros .csv), 
 *   mientras que el código se centra en la lógica de validación.</li>
 *   <li><b>Escalabilidad:</b> Facilita la adición de cientos de casos de prueba sin modificar el código.</li>
 *   <li><b>Colaboración:</b> Equipos de QA o analistas pueden editar los CSVs sin necesidad de conocer Java.</li>
 *   <li><b>Configuración:</b> Permite saltar cabeceras con <code>numLinesToSkip</code> y definir delimitadores personalizados.</li>
 * </ul>
 * 
 * <p><b>Ubicación:</b> Por defecto, JUnit busca los archivos en el classpath de test (habitualmente 
 * <code>src/test/resources</code>).</p>
 * 
 * @see org.junit.jupiter.params.provider.CsvFileSource
 */
@DisplayName("Teoría: CsvFileSource para datos externos")
@Tag("advanced")
class L3_AdvancedCsvFileTheory {

    private final OwnerService ownerService = new OwnerService();

    /**
     * TAREA DEMO: Uso de @CsvFileSource simplificado.
     * <p>Muestra cómo cargar datos desde un archivo CSV ubicado en resources. 
     * Se salta la primera línea que corresponde a las cabeceras.</p>
     * 
     * @param firstName Nombre leído del CSV.
     * @param lastName Apellido leído del CSV.
     */
    @ParameterizedTest(name = "[{index}] Verificando a {0} {1}")
    @CsvFileSource(resources = "/csv/theory_owners.csv", numLinesToSkip = 1)
    @DisplayName("🧪 Demo: Carga de datos desde fichero CSV")
    void csvFileSourceDemo(String firstName, String lastName) {
        // 1. Instanciamos el modelo con los datos del CSV
        Owner owner = new Owner(firstName, lastName);
        
        // 2. Act
        ownerService.save(owner);
        
        // 3. Assert
        Owner found = ownerService.findByLastName(lastName);
        assertNotNull(found, "El owner debería haberse guardado correctamente");
        assertEquals(firstName, found.getFirstName(), "El nombre debe coincidir con el del CSV");
    }
}
