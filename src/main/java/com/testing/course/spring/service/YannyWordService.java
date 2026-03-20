package com.testing.course.spring.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * <h1>YANNY PERFIL: YannyWordService</h1>
 * 
 * <p>Solo se activa cuando estamos en el perfil 'yanny'.</p>
 */
@Service
@Profile("yanny")
public class YannyWordService implements WordService {
    @Override
    public String getWord() {
        return "Yanny";
    }
}
