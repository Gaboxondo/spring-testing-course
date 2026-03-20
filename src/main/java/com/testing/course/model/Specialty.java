package com.testing.course.model;

/**
 * <h1>MODELO: Entidad Specialty (Especialidad)</h1>
 * 
 * <p><b>Qué hace:</b> Define el área de especialización médica de un veterinario.</p>
 * 
 * <p><b>Por qué existe:</b> Para clasificar a los facultativos según su formación 
 * (ej: Cirugía, Radiología) y facilitar la búsqueda de especialistas.</p>
 * 
 * <p><b>Cómo se usa:</b> Es un objeto de valor sencillo utilizado en colecciones 
 * dentro de la entidad <code>Vet</code>.</p>
 */
public class Specialty {
    private String name;

    public Specialty(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
