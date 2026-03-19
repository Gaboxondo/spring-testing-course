package com.gaboxondo.testing.model;

import java.time.LocalDate;

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
