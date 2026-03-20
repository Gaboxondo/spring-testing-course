package com.testing.course.mockito.section2_spy.exercises;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>EJERCICIO: Espionaje de Colecciones (Verificación de flujos)</h1>
 * 
 * <p>Objetivo: Aprender a usar <code>Mockito.spy()</code> sobre una colección real 
 * para vigilar el flujo de inserción de datos en un proceso de transformación.</p>
 * 
 * <h2>Requisitos del ejercicio:</h2>
 * <ol>
 *   <li>Crea una instancia real de <code>ArrayList&lt;String&gt;</code>.</li>
 *   <li>Crea un <b>Spy</b> sobre esa instancia usando <code>spy(lista)</code>.</li>
 *   <li>Añade los elementos "A", "B" y "C" a la lista a través del Spy.</li>
 *   <li>Añade un cuarto elemento "MOCK" pero haciendo que la lista diga que 
 *   contiene 100 elementos (Stub parcial de <code>size()</code> solo tras 
 *   añadir el cuarto).</li>
 *   <li>Verifica que el método <code>add</code> con "A", "B" y "C" se llamó al 
 *   menos una vez.</li>
 *   <li>Verifica con <code>assertEquals</code> que <code>size()</code> devuelve 100.</li>
 * </ol>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - EX3: Espionaje de Listas Reales")
public class EX3_SpyCollections {

    @Test
    @Disabled("Deshabilitado: Implementar lógica en la solución S3")
    @DisplayName("🧪 Test: Vigilancia de Inserción en Lista")
    void testCollectionSpying() {
        // TAREA: Implementar el espionaje y control parcial de una lista real
    }
}
