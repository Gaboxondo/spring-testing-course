package com.testing.course.controller;

import com.testing.course.model.Vet;
import com.testing.course.repository.VetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping("/api/vets")
public class VetRestController {

    private final VetRepository vetRepository;

    public VetRestController(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @GetMapping({"", "/"})
    public Collection<Vet> getAllVets() {
        return vetRepository.findAll();
    }
}
