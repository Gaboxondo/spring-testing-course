package com.testing.course.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class IndexController {

    @GetMapping({"", "/", "/index", "/index.html"})
    public String index() {
        return "index";
    }

    @GetMapping("/oups")
    public String oupsHandler() {
        throw new RuntimeException("Error inesperado en la Clínica");
    }

    /**
     * Manejador de excepciones local para este controlador.
     * Permite que Spring (y MockMvc) traduzcan la excepción a un código de estado HTTP 500.
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleRuntimeException(RuntimeException ex) {
        // En un caso real, aquí se loguearía el error.
    }
}
