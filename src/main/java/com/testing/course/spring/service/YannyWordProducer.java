package com.testing.course.spring.service;

import org.springframework.stereotype.Component;

/**
 * <h1>IMPLEMENTACIÓN: YannyWordProducer</h1>
 * 
 * <p><b>Qué hace:</b> Implementa la voz de 'Yanny' para el sistema auditivo.</p>
 * 
 * <p><b>Mecanismo:</b> Está disponible de forma global en el contexto para 
 * permitir demostraciones de <code>@Qualifier</code> en clases como 
 * <code>L2_PrimaryQualifierTheory</code>.</p>
 */
@Component("yannyWordProducer")
public class YannyWordProducer implements WordProducer {
    @Override
    public String getWord() {
        return "Yanny";
    }
}
