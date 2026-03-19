package com.testing.course.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ElementCollection
    private Set<String> specialities = new HashSet<>();

    public Vet() {
    }

    public Vet(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Set<String> getSpecialities() { return specialities; }
    public void addSpeciality(String speciality) { this.specialities.add(speciality); }
}
