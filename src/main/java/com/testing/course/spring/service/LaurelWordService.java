package com.testing.course.spring.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * <h1>LAUREL PERFIL: LaurelWordService</h1>
 * 
 * <p>Solo se activa cuando NO estamos en el perfil 'yanny'.</p>
 */
@Service
@Profile("!yanny")
public class LaurelWordService implements WordService {
    @Override
    public String getWord() {
        return "Laurel";
    }
}
