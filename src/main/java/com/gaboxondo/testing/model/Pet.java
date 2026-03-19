package com.gaboxondo.testing.model;

import java.time.LocalDate;

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
