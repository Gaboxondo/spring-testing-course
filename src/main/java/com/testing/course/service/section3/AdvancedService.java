package com.testing.course.service.section3;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;

import java.util.Collection;

/**
 * <h1>SERVICIO DE APOYO: Advanced Mockito</h1>
 * 
 * <p>Este servicio contiene elementos para demostrar funcionalidades 
 * avanzadas de Mockito, como:</p>
 * <ul>
 *   <li><b>Mocked Construction:</b> El método <code>handleInternalCreation</code> instancia un generador.</li>
 *   <li><b>Answers / returnsFirstArg:</b> Se usa en combinación con el repositorio de visitas.</li>
 *   <li><b>Lambda Matchers:</b> Validaciones complejas de visitas en el método <code>processSpecialVisit</code>.</li>
 * </ul>
 */
public class AdvancedService {

    private final VisitRepository visitRepository;

    public AdvancedService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * MOCK CONSTRUCTOR CASE: Instanciación interna de un generador.
     * <p>Sin inyección de dependencias, ¿cómo interceptamos la creación?</p>
     */
    public String handleInternalCreation(Visit visit) {
        // ERROR DE DISEÑO TÍPICO: Instanciación interna (difícil de testear)
        ExternalReportGenerator generator = new ExternalReportGenerator();
        return generator.generate(visit);
    }

    /**
     * ANSWERS CASE: Guarda una visita y la devuelve para ser procesada.
     */
    public Visit saveAndLog(Visit visit) {
        // Imagina que el repositorio ahora devuelve el objeto guardado
        // (Simularemos esto con AdditionalAnswers.returnsFirstArg())
        // visitRepository.save(visit); // actualmente es void!
        
        // Simulo un método que devuelva el Visit (para el demo de Answers)
        // visitRepository.findById(1L); 
        
        return visit; // Simplemente un placeholder
    }

    /**
     * LAMBDA MATCHERS CASE: Procesa visitas que cumplen condiciones complejas.
     * <p>Permite demostrar argThat(visit -> ...).</p>
     */
    public boolean processVisitWithRules(Visit visit) {
        if (visit.getDescription() != null && visit.getDescription().length() > 5) {
            // Internamente, el servicio decide si llamar al repo según reglas
            visitRepository.save(visit);
            return true;
        }
        return false;
    }
}
