package com.testing.course.mockito.section2_spy.exercises;

import com.testing.course.service.section2_spy.SpyDeepDiveService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * <h1>EJERCICIO: Domina las Peculiaridades de los Spies</h1>
 * 
 * <p>En este reto, aplicarás los conceptos aprendidos sobre el "shadow copying", 
 * spying sobre clases abstractas y métodos finales.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - EX4: Reto Deep Dive Spy")
class EX4_SpyDeepDiveExercise {

    /**
     * RETO 1: El Dilema del Estado Sincronizado.
     * <p>Demuestra que entiendes la diferencia entre la instancia real y el spy.</p>
     */
    @Test
    @Disabled("Ejercicio no resuelto")
    @DisplayName("🧪 Reto 1: Validar el efecto del copiado (Shadow Copy)")
    void challengeCopying() {
        // 1. Crea una lista real 'myItems' y añade "A"
        // TODO: Tu código aquí
        
        // 2. Crea un spy 'mySpy' sobre 'myItems'
        // TODO: Tu código aquí

        // 3. Añade "B" a la lista ORIGINAL 'myItems'
        // TODO: Tu código aquí

        // 4. Haz un ASSERT que demuestre que 'mySpy' NO contiene "B" (size=1)
        // TODO: Tu código aquí

        // 5. Añade "C" al SPY 'mySpy'
        // TODO: Tu código aquí

        // 6. Haz un ASSERT que demuestre que 'myItems' NO contiene "C" (size=2)
        // TODO: Tu código aquí
        
        // fail("Ejercicio no resuelto - Elimina esto y completa los TODO");
    }

    /**
     * RETO 2: Espiando la Abstracción.
     * <p>Usa Mockito para espiar una clase abstracta sin usar subclases.</p>
     */
    @Test
    @Disabled("Ejercicio no resuelto")
    @DisplayName("🧪 Reto 2: Spy sobre SpyDeepDiveService")
    void challengeAbstract() {
        // 1. Crea un spy de SpyDeepDiveService (abstracto) usando CALLS_REAL_METHODS
        // TODO: Tu código aquí

        // 2. Mockea el método abstracto fetchExternalConfig() para que devuelva "RETO_OK"
        // TODO: Tu código aquí

        // 3. Ejecuta generateReport() y verifica que el resultado contiene "RETO_OK"
        // TODO: Tu código aquí
        
        // fail("Ejercicio no resuelto - Elimina esto y completa los TODO");
    }
}
