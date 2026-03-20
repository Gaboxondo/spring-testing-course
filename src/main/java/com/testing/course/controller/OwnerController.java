package com.testing.course.controller;

import com.testing.course.model.Owner;
import com.testing.course.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

/**
 * <h1>CONTROLADOR: OwnerController (Web MVC)</h1>
 * 
 * <p><b>Qué hace:</b> Gestiona las peticiones HTTP relacionadas con la interfaz web de propietarios.</p>
 * 
 * <p><b>Por qué existe:</b> Actúa como el controlador de entrada para el flujo de creación 
 * y búsqueda de dueños de mascotas mediante plantillas HTML (Thymeleaf o similar).</p>
 * 
 * <p><b>Cómo se usa:</b> Es el objetivo principal de los tests con <b>MockMvc</b>. 
 * Permite probar validaciones de formularios y redirecciones sin levantar un navegador.</p>
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * Configuración del Binder para proteger campos sensibles como el ID.
     */
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Muestra el formulario de búsqueda de propietarios.
     */
    @GetMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", new Owner(null, null));
        return "owners/findOwners";
    }

    /**
     * Procesa la creación de un nuevo dueño validando los campos obligatorios.
     */
    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        } else {
            ownerService.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }
}
