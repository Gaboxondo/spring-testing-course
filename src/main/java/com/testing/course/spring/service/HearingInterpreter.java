package com.testing.course.spring.service;

import org.springframework.stereotype.Service;

/**
 * <h1>SERVICIO: HearingInterpreter (Intérprete Auditivo)</h1>
 * 
 * <p><b>Qué hace:</b> Procesa y devuelve lo que el sistema "escucha" basándose 
 * en un productor de palabras inyectado.</p>
 * 
 * <p><b>Por qué existe:</b> Sirve como el Bean principal para demostrar la 
 * <b>Inyección de Dependencias (DI)</b> de Spring. Permite ver cómo Spring elige 
 * entre diferentes implementaciones de <code>WordProducer</code>.</p>
 * 
 * <p><b>Cómo se usa:</b> Es el objetivo del <code>@Autowired</code> en la mayoría 
 * de los tests de la sección de Spring Context.</p>
 */
@Service
public class HearingInterpreter {
    private final WordProducer wordProducer;

    public HearingInterpreter(WordProducer wordProducer) {
        this.wordProducer = wordProducer;
    }

    /**
     * Interpreta la palabra generada por el productor actual.
     * 
     * @return String con el mensaje interpretado.
     */
    public String whatDidIHear() {
        return "Escuché: " + wordProducer.getWord();
    }
}
