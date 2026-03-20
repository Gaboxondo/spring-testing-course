package com.testing.course.mockito.section2_spy.solutions;

import com.testing.course.service.section2_spy.SpyDeepDiveService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * <h1>SOLUCIÓN: Domina las Peculiaridades de los Spies</h1>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - S4: Solución Reto Deep Dive Spy")
class S4_SpyDeepDiveSolution {

    @Test
    @DisplayName("🧪 Solución Reto 1: Validar el efecto del copiado")
    void challengeCopying() {
        // 1. Crea una lista real 'myItems' y añade "A"
        List<String> myItems = new ArrayList<>();
        myItems.add("A");
        
        // 2. Crea un spy 'mySpy' sobre 'myItems'
        List<String> mySpy = spy(myItems);

        // 3. Añade "B" a la lista ORIGINAL 'myItems'
        myItems.add("B");

        // 4. Haz un ASSERT que demuestre que 'mySpy' NO contiene "B" (size=1)
        assertEquals(1, mySpy.size());
        assertFalse(mySpy.contains("B"));

        // 5. Añade "C" al SPY 'mySpy'
        mySpy.add("C");

        // 6. Haz un ASSERT que demuestre que 'myItems' NO contiene "C" (size=2)
        assertEquals(2, myItems.size()); // A y B
        assertTrue(myItems.contains("C"));
    }

    @Test
    @DisplayName("🧪 Solución Reto 2: Spy sobre SpyDeepDiveService")
    void challengeAbstract() {
        // 1. Crea un spy de SpyDeepDiveService (abstracto) usando CALLS_REAL_METHODS
        SpyDeepDiveService serviceSpy = mock(SpyDeepDiveService.class, withSettings()
                .useConstructor()
                .defaultAnswer(CALLS_REAL_METHODS));

        // 2. Mockea el método abstracto fetchExternalConfig() para que devuelva "RETO_OK"
        doReturn("RETO_OK").when(serviceSpy).fetchExternalConfig();

        // 3. Ejecuta generateReport() y verifica que el resultado contiene "RETO_OK"
        String result = serviceSpy.generateReport();
        
        assertTrue(result.contains("RETO_OK"));
        verify(serviceSpy).fetchExternalConfig();
    }
}
