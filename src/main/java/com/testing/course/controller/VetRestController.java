package com.testing.course.controller;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

/**
 * <h1>CONTROLADOR: VetRestController (REST API)</h1>
 * 
 * <p><b>Qué hace:</b> Expone los datos de los veterinarios a través de una API RESTful en formato JSON.</p>
 * 
 * <p><b>Por qué existe:</b> Permite la integración con clientes móviles o aplicaciones 
 * modernas de front-end que requieren datos crudos en lugar de páginas HTML.</p>
 * 
 * <p><b>Cómo se usa:</b> Se testea habitualmente con <code>testRestTemplate</code> o 
 * <code>MockMvc</code> configurando el <code>MediaType.APPLICATION_JSON</code>.</p>
 */
@RestController
@RequestMapping("/api/vets")
public class VetRestController {

    private final VetRepository vetRepository;

    public VetRestController(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    /**
     * Recupera todos los veterinarios para el endpoint base.
     * 
     * @return Colección de veterinarios serializados a JSON.
     */
    @GetMapping({"", "/"})
    public Collection<Vet> getAllVets() {
        return vetRepository.findAll();
    }
}
