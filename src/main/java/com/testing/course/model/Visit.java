package com.testing.course.model;

import java.time.LocalDate;

/**
 * <h1>MODELO: Entidad Visit</h1>
 * 
 * <p><b>Qué hace:</b> Representa una visita veterinaria realizada por una mascota.</p>
 * 
 * <p><b>Por qué existe:</b> Para mantener un registro cronológico de las revisiones, 
 * diagnósticos y tratamientos realizados a cada mascota de la clínica.</p>
 * 
 * <p><b>Cómo se usa:</b> Es instanciada por el servicio de visitas y se asocia 
 * obligatoriamente a un objeto <code>Pet</code>.</p>
 */
public class Visit {
    private String description;
    private LocalDate date;
    private Pet pet;

    public Visit(String description, Pet pet) {
        this.description = description;
        this.pet = pet;
        this.date = LocalDate.now();
    }

    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }
    public Pet getPet() { return pet; }
}
