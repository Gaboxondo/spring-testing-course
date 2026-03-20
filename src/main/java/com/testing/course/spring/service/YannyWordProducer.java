package com.testing.course.spring.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * <h1>IMPLEMENTACIÓN: YannyWordProducer</h1>
 * 
 * <p><b>Qué hace:</b> Implementa la voz de 'Yanny' para el sistema auditivo.</p>
 * 
 * <p><b>Mecanismo:</b> Solo se incluye en el contexto cuando el perfil 
 * 'yanny' está activado mediante <code>@ActiveProfiles("yanny")</code>.</p>
 */
@Component
@Profile("yanny")
public class YannyWordProducer implements WordProducer {
    @Override
    public String getWord() {
        return "Yanny";
    }
}
