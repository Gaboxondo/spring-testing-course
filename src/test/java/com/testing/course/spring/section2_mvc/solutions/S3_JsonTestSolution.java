package com.testing.course.spring.section2_mvc.solutions;

import com.testing.course.model.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>SOLUCIÓN 3: Serialización JSON</h1>
 * 
 * <p>Esta es la solución implementada para el ejercicio 3 
 * usando <code>@JsonTest</code> y <code>JacksonTester</code>.</p>
 */
@JsonTest
@DisplayName("Solución 3: Serialización de Objetos a JSON")
class S3_JsonTestSolution {

    @Autowired
    private JacksonTester<Owner> json;

    /**
     * TAREA RESUELTA: Aserción fluída sobre JSON.
     * <p>Muestra cómo encadenar aserciones de JacksonTester.</p>
     */
    @Test
    void testSerializationCorrectness() throws IOException {
        Owner owner = new Owner("Eduardo", "Gallego");
        
        // El JacksonTester permite escribir aserciones JSON path de forma sencilla
        assertThat(json.write(owner))
            .hasJsonPathStringValue("@.firstName", "Eduardo")
            .hasJsonPathStringValue("@.lastName", "Gallego");
    }
}
