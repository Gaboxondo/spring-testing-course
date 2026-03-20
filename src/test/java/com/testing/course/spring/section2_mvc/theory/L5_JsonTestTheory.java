package com.testing.course.spring.section2_mvc.theory;

import com.testing.course.model.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>TEORÍA: Slices de Testing - @JsonTest</h1>
 * 
 * <p>Spring Boot ofrece anotaciones "slice" que cargan solo una 
 * parte del contexto de la aplicación, haciéndolos mucho más rápidos 
 * que un test completo de integración.</p>
 * 
 * <h2>Principios Clave:</h2>
 * <ul>
 *   <li><b>Contexto Reducido:</b> <code>@JsonTest</code> solo configura la 
 *   infraestructura de serialización/deserialización JSON (p.ej., Jackson).</li>
 *   <li><b>JacksonTester:</b> Herramienta que facilita las aserciones fluídas 
 *   sobre el contenido JSON (usando AssertJ internamente).</li>
 *   <li><b>Aislamiento:</b> Ideal para validar que los DTOs se mapean 
 *   correctamente ante reglas complejas de anotaciones Jackson.</li>
 * </ul>
 * 
 * <p><b>¿Cuándo usarlo?</b> Cuando necesites asegurar que tus objetos se transforman 
 * en el JSON esperado por otros clientes, o que deserializas correctamente 
 * lo que recibes vía API.</p>
 */
@JsonTest
@DisplayName("Teoría: Serialización JSON con @JsonTest")
class L5_JsonTestTheory {

    @Autowired
    private JacksonTester<Owner> json;

    /**
     * Demo de serialización: De objeto Java a JSON string.
     * <p>Probamos que los campos del objeto <code>Owner</code> terminan en el 
     * lugar adecuado del JSON.</p>
     */
    @Test
    @DisplayName("🧪 Probando Serialización de Owner")
    void testSerialization() throws IOException {
        Owner owner = new Owner("Paco", "Jones");
        
        // AssertJ (assertThat) + JacksonTester
        assertThat(json.write(owner)).hasJsonPathStringValue("@.firstName");
        assertThat(json.write(owner)).extractingJsonPathStringValue("@.firstName").isEqualTo("Paco");
        assertThat(json.write(owner)).extractingJsonPathStringValue("@.lastName").isEqualTo("Jones");
    }

    /**
     * Demo de deserialización: De JSON string a objeto Java.
     * <p>Verificamos que el mapeo inverso funciona correctamente.</p>
     */
    @Test
    @DisplayName("🧪 Probando Deserialización de Owner")
    void testDeserialization() throws IOException {
        String content = "{\"firstName\":\"Paco\",\"lastName\":\"Jones\"}";
        
        Owner result = json.parse(content).getObject();
        
        assertThat(result.getFirstName()).isEqualTo("Paco");
        assertThat(result.getLastName()).isEqualTo("Jones");
    }
}
