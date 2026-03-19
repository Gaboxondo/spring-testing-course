package com.testing.course.mockito.section2_advanced.theory;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Sección 2 - L13: Mocks Parciales (@Spy) vs @Mock.
 * 
 * Es fundamental entender cuándo usar uno u otro:
 * - @Mock: Crea una cáscara vacía. Todos sus métodos devuelven null, 0 o false por defecto.
 * - @Spy: Envuelve una instancia REAL. Llama al código real SI NO has programado nada.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - L13: Mocks Parciales (@Spy vs @Mock)")
class L5_PartialMockTheory {

    @Spy
    OwnerService ownerServiceSpy;

    /**
     * MOCK PARCIAL (Partial Mocking)
     * 
     * Se usa cuando quieres probar un método real de una clase, pero ese método 
     * llama internamente a OTRO método de la MISMA clase que quieres isolar.
     * 
     * RECUERDA: Si usamos @Mock sobre OwnerService, no podríamos probar save() porque 
     * save() estaría totalmente vacío. Al usar @Spy, el código de save() es REAL.
     */
    @Test
    @DisplayName("🧪 Probando comportamiento parcial")
    void testPartialMocking() {
        Owner owner = new Owner("Mascota", "Cita");
        
        // El método REAL save() de OwnerService llama a validateOwner().
        // Mockeamos PARCIALMENTE validateOwner para que no lance error (o asuma OK).
        
        doNothing().when(ownerServiceSpy).validateOwner(any());

        // Llama a save() -> Ejecuta el código REAL (porque es un Spy).
        ownerServiceSpy.save(owner);
        
        // Validamos que se llamó a la validación MOCKEADA.
        verify(ownerServiceSpy).validateOwner(any());
        
        // Al ser código real (save() del servicio), el contador de la lista 'owners' sube.
        // Si fuera un @Mock, getOwnerCount() devolvería 0 siempre.
        assertEquals(1, ownerServiceSpy.getOwnerCount(), "El contador aumenta porque el código de save() es REAL");
    }
}

