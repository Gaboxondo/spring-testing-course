package com.testing.course.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>CONFIGURACIÓN: HearingConfig</h1>
 * 
 * <p><b>Qué hace:</b> Define la estrategia de escaneo de componentes para el 
 * sub-proyecto de demostración de Spring Context.</p>
 * 
 * <p><b>Por qué existe:</b> Actúa como el punto de entrada para que <code>@ContextConfiguration</code> 
 * sepa qué clases debe convertir en Beans gestionados por el contenedor de Spring.</p>
 */
@Configuration
@ComponentScan(basePackages = "com.testing.course.spring")
public class HearingConfig {
}
