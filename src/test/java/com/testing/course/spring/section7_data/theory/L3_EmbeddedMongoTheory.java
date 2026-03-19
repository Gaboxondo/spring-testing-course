package com.testing.course.spring.section7_data.theory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Sección 7 - L5: Testeando MongoDB (Embebido o con Slices).
 * 
 * Al igual que con JPA, Spring Boot ofrece @DataMongoTest.
 * 
 * OPCIONES PARA MONGODB:
 * 1. MONGODB EMBEDDED: Se suele añadir 'de.flapdoodle.embed:de.flapdoodle.embed.mongo'
 *    en el pom.xml. Spring levantará un Mongo real en memoria para el test.
 * 
 * 2. TESTCONTAINERS: (Recomendado hoy día). Levanta un contenedor Docker 
 *    con Mongo real. Es más lento pero 100% fiel a producción.
 * 
 * 3. MOCKING (@MockBean): Si solo queremos probar un Service y no nos importa 
 *    Mongo, mockeamos el MongoRepository como vimos en L2.
 */
// @DataMongoTest // Descomentar si se tiene la dependencia de Mongo
@DisplayName("Sección 7 - L5: Conceptos de MongoDB")
class L3_EmbeddedMongoTheory {

    @Test
    @DisplayName("🧪 Teoría Documental")
    void explainMongoTesting() {
        // En este curso nos centramos en JPA/H2, pero las bases son iguales:
        // Se inyecta el Repository y se usa @DataMongoTest para aislar la capa.
        assertTrue(true);
    }
}

