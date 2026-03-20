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
 * <h1>TEORÍA: Slices de Serialización (@JsonTest)</h1>
 * 
 * <p><b>Qué hace:</b> Configura aisladamente la infraestructura de Jackson 
 * (convertidores JSON) para validar cómo se estructuran nuestros objetos en la red.</p>
 * 
 * <p><b>Por qué existe:</b> En arquitecturas basadas en APIs REST, el contrato JSON 
 * es sagrado. Este test garantiza que los cambios en el código Java no rompan 
 * accidentalmente la estructura esperada por los clientes front-end o móviles.</p>
 * 
 * <h2>JacksonTester:</h2>
 * <p>Herramienta fluida que permite aserciones mediante <b>JsonPath</b>, facilitando 
 * la navegación por nodos JSON complejos sin necesidad de comparaciones de cadenas rígidas.</p>
 */
@JsonTest
@DisplayName("Sección 2 - L5: Serialización y Deserialización JSON")
class L5_JsonTestTheory {

    @Autowired
    private JacksonTester<Owner> json;

    /**
     * <h2>DEMO: Conversión de Java a JSON payload</h2>
     * <p>Validamos que los campos se mapean a los nombres de claves correctos 
     * cumpliendo con los estándares CamelCase o lo especificado en @JsonProperty.</p>
     */
    @Test
    @DisplayName("🧪 Demo 7: Verificación de path JSON-Object")
    void testSerialization() throws IOException {
        Owner owner = new Owner("Paco", "Jones");
        
        assertThat(json.write(owner)).hasJsonPathStringValue("@.firstName");
        assertThat(json.write(owner)).extractingJsonPathStringValue("@.firstName").isEqualTo("Paco");
    }

    /**
     * <h2>DEMO: Mapeo de JSON entrante a Objeto Java</h2>
     * <p>Simulamos la llegada de un payload JSON y verificamos que Spring es 
     * capaz de reconstruir el objeto Owner fielmente.</p>
     */
    @Test
    @DisplayName("🧪 Demo 8: Deserialización de payload raw")
    void testDeserialization() throws IOException {
        String content = "{\"firstName\":\"Paco\",\"lastName\":\"Jones\"}";
        Owner result = json.parse(content).getObject();
        
        assertThat(result.getFirstName()).isEqualTo("Paco");
    }
}
