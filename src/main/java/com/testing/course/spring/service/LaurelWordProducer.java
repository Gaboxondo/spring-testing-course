package com.testing.course.spring.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * <h1>IMPLEMENTACIÓN: LaurelWordProducer</h1>
 * 
 * <p><b>Qué hace:</b> Implementa la voz de 'Laurel' para el sistema auditivo.</p>
 * 
 * <p><b>Mecanismo:</b> Está marcada como <code>@Primary</code> para ser la elección 
 * por defecto. Su perfil <code>@Profile("!yanny")</code> asegura que esté activa 
 * siempre que el perfil alternativo 'yanny' NO esté presente.</p>
 */
@Component
@Primary
@Profile("!yanny") // Se activa por defecto SIEMPRE que no estemos en modo Yanny
public class LaurelWordProducer implements WordProducer {
    @Override
    public String getWord() {
        return "Laurel";
    }
}
