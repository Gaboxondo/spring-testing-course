package com.testing.course.spring.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * <h1>IMPLEMENTACIÓN: LaurelWordProducer</h1>
 * 
 * <p><b>Qué hace:</b> Implementa la voz de 'Laurel' para el sistema auditivo.</p>
 * 
 * <p><b>Mecanismo:</b> Es la elección por defecto (<code>@Primary</code>) en todo el 
 * sub-proyecto de demostración de Spring Context. Al no tener perfil, siempre 
 * está disponible en el contenedor de Spring.</p>
 */
@Component
@Primary
public class LaurelWordProducer implements WordProducer {
    @Override
    public String getWord() {
        return "Laurel";
    }
}
