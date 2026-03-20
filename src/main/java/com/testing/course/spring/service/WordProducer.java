package com.testing.course.spring.service;

/**
 * <h1>INTERFAZ: WordProducer (Productor de Palabras)</h1>
 * 
 * <p><b>Qué hace:</b> Define el contrato para generar una palabra o sonido.</p>
 * 
 * <p><b>Por qué existe:</b> Es la base para demostrar el polimorfismo en Spring 
 * (Laurel vs Yanny) y el uso de <code>@Primary</code>, <code>@Qualifier</code> 
 * y <code>@Profile</code>.</p>
 */
public interface WordProducer {
    /**
     * Obtiene la palabra específica de la implementación.
     */
    String getWord();
}
