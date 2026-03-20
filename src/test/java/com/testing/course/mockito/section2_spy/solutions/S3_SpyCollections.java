package com.testing.course.mockito.section2_spy.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * <h1>SOLUCIÓN: Espionaje de Colecciones (Verificación de flujos)</h1>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - S3: Solución de Espionaje de Listas")
class S3_SpyCollections {

    @Test
    @DisplayName("🧪 Solución: Vigilancia de Inserción en Lista con Spy Manual")
    void testCollectionSpying() {
        // 1. Crear instancia y spy manual
        List<String> list = new ArrayList<>();
        List<String> spyList = spy(list);

        // 2. Act: Añadimos elementos
        spyList.add("A");
        spyList.add("B");
        spyList.add("C");

        // 3. Stub parcial de size() sobre el spy
        doReturn(100).when(spyList).size();

        // 4. Verification de interacciones
        verify(spyList).add("A");
        verify(spyList).add("B");
        verify(spyList).add("C");

        // 5. Assert: Comprobar el valor del stub
        assertEquals(100, spyList.size(), "Debería haber devuelto 100 por el stub parcial.");
        
        // El contenido real de la lista sigue ahí (aunque hayamos mockeado un método)
        // pero cuidado: si usáramos spyList.get(0) sin mockearlo, devolvería "A".
    }
}
