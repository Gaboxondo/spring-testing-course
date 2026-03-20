package com.testing.course.spring.section2_mvc.exercises;

import com.testing.course.model.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>EJERCICIO 3: Serialización JSON</h1>
 * 
 * <p>El objetivo es implementar un test que use <code>@JsonTest</code> 
 * para validar la serialización de un objeto <code>Owner</code>.</p>
 * 
 * <p><b>Por qué existe:</b> Para practicar aserciones fluidas 
 * sobre fragmentos de JSON y asegurar el cumplimiento de la API.</p>
 * 
 * <p><b>Instrucciones:</b> 
 * 1. Quitar el @Disabled.
 * 2. Autowirear el <code>JacksonTester<Owner></code>.
 * 3. Validar que el campo <code>firstName</code> del objeto es el esperado en el JSON.</p>
 */
@JsonTest
@Disabled("Ejercicio de JSON Testing pendiente de resolver")
@DisplayName("Ejercicio: Serialización de Objetos a JSON")
class EX3_JsonTestExercise {

    @Autowired
    private JacksonTester<Owner> json;

    /**
     * TAREA: Implementa la aserción de serialización.
     * <p>Usa <code>json.write(obj)</code> y <code>hasJsonPathStringValue</code>.</p>
     */
    @Test
    void testCurrentTimestampIsForced() throws IOException {
        Owner owner = new Owner("Eduardo", "Gallego");
        
        // TODO: Validar que el JSON tiene el campo firstName con valor 'Eduardo'
        // assertThat(json.write(owner))...
    }
}
