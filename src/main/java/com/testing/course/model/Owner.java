package com.testing.course.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>MODELO: Entidad Owner (Propietario)</h1>
 * 
 * <p><b>Qué hace:</b> Representa al cliente de la clínica, dueño de una o varias mascotas.</p>
 * 
 * <p><b>Por qué existe:</b> Es la entidad central para la gestión de datos de contacto, 
 * direcciones de facturación y propiedad de mascotas en el sistema.</p>
 * 
 * <p><b>Cómo se usa:</b> Ampliamente utilizada en tests de controladores de Spring MVC 
 * y en aserciones complejas de validación con Bean Validation (@NotEmpty).</p>
 */
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String firstName;
    
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    
    @ElementCollection
    private List<String> pets = new ArrayList<>();

    // Requerido por JPA
    public Owner() {
    }

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public List<String> getPets() { return pets; }
}
