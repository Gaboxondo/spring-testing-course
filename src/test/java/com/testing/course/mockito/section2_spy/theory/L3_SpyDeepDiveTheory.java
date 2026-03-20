package com.testing.course.mockito.section2_spy.theory;

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
 * <h1>TEORÍA: Deep Dive en Mockito Spies</h1>
 * 
 * <p>En esta lección cubrimos detalles críticos del funcionamiento interno de los Spies 
 * que a menudo causan confusión en desarrolladores Java.</p>
 * 
 * <h2>1. El Mecanismo de Copiado (Shadow Copies)</h2>
 * <p>Cuando usas <code>spy(objetoReal)</code>, Mockito crea una <b>copia</b> del objeto. 
 * Cualquier cambio hecho en el objeto original DESPUÉS de crear el spy NO se reflejará 
 * en el spy, y viceversa. Esto es vital para depurar tests donde el estado parece no cambiar.</p>
 * 
 * <h2>2. Espiando Clases Abstractas</h2>
 * <p>A veces queremos testear la lógica de una clase abstracta sin crear una subclase manual 
 * (test double). Mockito permite usar <code>spy(AbstractClass.class)</code> para instanciarla 
 * y mockear sus métodos abstractos manteniendo el código real de los concretos.</p>
 * 
 * <h2>3. El Problema de los Métodos 'final'</h2>
 * <p>Aunque Mockito moderno permite mockear métodos final, el comportamiento con Spies 
 * puede ser errático si no se entiende que Mockito intercepta la llamada. Si el método 
 * es final, Mockito no puede sobrescribirlo de forma tradicional mediante herencia.</p>
 * 
 * <h2>4. ¿Cuándo NO usar Spies? (Code Smell)</h2>
 * <p>La propia documentación de Mockito advierte que el uso frecuente de spies es un 
 * "code smell". Indica que la clase tiene demasiadas responsabilidades o que no se está 
 * usando correctamente la inyección de dependencias.</p>
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Sección 2 - L3: Funcionamiento Interno y Casos Especiales")
class L3_SpyDeepDiveTheory {

    /**
     * <h2>CASO 1: Demostración del Mecanismo de Copiado (Shadow Memory)</h2>
     * 
     * <p><b>Qué hace:</b> Muestra que al hacer <code>spy(real)</code>, Mockito clona los campos 
     * en una nueva instancia. La instancia original y el spy son objetos físicamente distintos 
     * en la memoria (heap).</p>
     * 
     * <p><b>Por qué es importante:</b> Es uno de los errores más comunes. El alumno suele 
     * pensar que el spy es una "piel" sobre el objeto original que reacciona a cambios en él. 
     * Si mutas el objeto original después de crear el spy, el spy mantendrá la 'foto' del 
     * estado que tenía al nacer.</p>
     * 
     * <p><b>Cómo se usa:</b> Siempre crea el spy <b>después</b> de que el objeto real tenga 
     * el estado inicial deseado, o interactúa únicamente con el spy durante el test.</p>
     */
    @Test
    @DisplayName("🧪 Demo 1: El Spy NO es el mismo objeto (Copia)")
    void testCopyingMechanism() {
        List<String> realList = new ArrayList<>();
        realList.add("Item 1");

        // Creamos el spy sobre el estado actual (contiene Item 1)
        List<String> spyList = spy(realList);

        // Modificamos el ORIGINAL
        realList.add("Item 2");

        // El SPY no se entera del cambio en el original
        assertEquals(1, spyList.size(), "El spy debería tener 1 elemento (el estado al momento de crearlo)");
        assertEquals(2, realList.size(), "La lista original tiene 2 elementos");
        
        // Modificamos el SPY
        spyList.add("Item 3");
        
        // El ORIGINAL no se entera del cambio en el spy
        assertEquals(2, spyList.size()); // Item 1 + Item 3
        assertEquals(2, realList.size()); // Item 1 + Item 2
    }

    /**
     * <h2>CASO 2: Espiando una Clase Abstracta sin subclase</h2>
     * 
     * <p><b>Qué hace:</b> Permite a Mockito instanciar una clase abstracta directamente 
     * llamando a su constructor y permitiendo 'rellenar' los huecos de sus métodos abstractos 
     * mediante stubbing.</p>
     * 
     * <p><b>Por qué es importante:</b> Evita tener que crear clases 'Dummy' o 'TestFake' 
     * manuales solo para testear la lógica de una clase base abstracta.</p>
     * 
     * <p><b>Cómo se usa:</b> Se requiere usar <code>mock(Abstract.class, withSettings()...)</code> 
     * y el setting <code>CALLS_REAL_METHODS</code> para que Mockito sepa que el spy 
     * debe comportarse como tal.</p>
     */
    @Test
    @DisplayName("🧪 Demo 2: Spy sobre Clase Abstracta")
    void testAbstractSpy() {
        // Mockito instancia la clase abstracta por nosotros
        SpyDeepDiveService serviceSpy = mock(SpyDeepDiveService.class, withSettings()
                .useConstructor()
                .defaultAnswer(CALLS_REAL_METHODS));

        // Programamos el comportamiento del método abstracto
        doReturn("CONFIG_MOCK").when(serviceSpy).fetchExternalConfig();

        // Llamamos a un método REAL de la clase abstracta que usa el configurado
        String report = serviceSpy.generateReport();

        assertTrue(report.contains("CONFIG:CONFIG_MOCK"));
        assertTrue(report.contains("REAL_SECURE_TOKEN_XYZ")); // Llamó al método final real
        
        // Verificamos que se ejecutó la lógica real del método recordLog (concreto en la abstracta)
        assertEquals(1, serviceSpy.getLogCount());
    }

    /**
     * CASO 3: Métodos Finales en Spies.
     * <p>En Mockito 5+, los métodos final pueden mockearse, pero por defecto 
     * en un Spy se ejecutan tal cual. Hay que tener cuidado con efectos secundarios.</p>
     */
    @Test
    @DisplayName("🧪 Demo 3: Interacción con métodos Final")
    void testFinalMethods() {
        // Obtenemos una implementación concreta para el spy
        SpyDeepDiveService serviceSpy = mock(SpyDeepDiveService.class, withSettings()
                .defaultAnswer(CALLS_REAL_METHODS));

        // Intentamos verificar el método final
        String token = serviceSpy.getSecurityToken();
        
        assertEquals("REAL_SECURE_TOKEN_XYZ", token);
        verify(serviceSpy).getSecurityToken(); // Esto funciona en Mockito moderno
    }

    /**
     * CASO 4: Inyección de Mocks en Spies (@Spy + @InjectMocks).
     * <p>A veces queremos que Mockito inyecte dependencias reales o mocks 
     * DENTRO de un objeto que también estamos espiando.</p>
     * <br><i>Nota:</i> Esto se suele usar en tests de integración ligeros.
     */
    @Test
    @DisplayName("🧪 Demo 4: El aviso de 'Code Smell'")
    void testCodeSmellAdvice() {
       /*
        * DOCUMENTACIÓN OFICIAL: "Regular use of spies suggests that your code 
        * needs refactoring." 
        * 
        * ¿Por qué? 
        * Si necesitas espiar private methods o internal state frecuentemente,
        * probablemente tu clase está haciendo demasiado (Violación de SRP).
        */
       assertTrue(true, "Consejo: Si usas muchos spies, ¡refactoriza!");
    }
}
