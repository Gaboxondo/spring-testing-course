package com.testing.course.model;

import java.time.LocalDate;

/**
 * <h1>MODELO: Entidad Pet (Mascota)</h1>
 * 
 * <p><b>Qué hace:</b> Representa a un animal doméstico registrado en la clínica.</p>
 * 
 * <p><b>Por qué existe:</b> Para vincular las visitas médicas a animales específicos 
 * y realizar un seguimiento de su historial de salud.</p>
 * 
 * <p><b>Cómo se usa:</b> Es un objeto ligero utilizado en verificaciones básicas 
 * de JUnit 5 y aserciones de estado.</p>
 */
public class Pet {
    private String name;
    private LocalDate birthDate;
    private String type;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
        this.birthDate = LocalDate.now();
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public LocalDate getBirthDate() { return birthDate; }
}
