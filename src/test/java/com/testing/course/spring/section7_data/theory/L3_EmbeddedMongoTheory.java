package com.testing.course.spring.section7_data.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <h1>TEORÍA: Estrategias para Bases de Datos NoSQL</h1>
 * 
 * <p><b>Qué hace:</b> Describe las herramientas de Spring para testear MongoDB u 
 * otros sistemas documentales, similares a @DataJpaTest.</p>
 * 
 * <p><b>Por qué existe:</b> Las aplicaciones modernas a menudo usan bases de datos 
 * heterogéneas. Spring proporciona abstracciones similares (<code>@DataMongoTest</code>) 
 * para garantizar la uniformidad en el testing independientemente de la tecnología.</p>
 */
@DisplayName("Sección 7 - L5: Conceptuación de MongoDB en Testing")
class L3_EmbeddedMongoTheory {

    @Test
    @DisplayName("🧪 Nota Técnica: MongoDB y Slices")
    void explainMongoTesting() {
        // En este curso priorizamos JPA/SQL, pero las bases son gemelas:
        // @DataMongoTest activa el escaneo de documentos y repositorios mongo.
        assertTrue(true);
    }
}
