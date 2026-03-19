package com.testing.course.model;

import java.util.HashSet;
import java.util.Set;

public class Vet {
    private String firstName;
    private String lastName;
    private Set<String> specialities = new HashSet<>();

    public Vet(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Set<String> getSpecialities() { return specialities; }
    public void addSpeciality(String speciality) { this.specialities.add(speciality); }
}
