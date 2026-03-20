package com.testing.course.service.section3;

import com.testing.course.model.Visit;
import com.testing.course.repository.VisitRepository;

/**
 * <h1>SERVICIO DE APOYO: Advanced Mockito</h1>
 * 
 * <p><b>Qué hace:</b> Reúne casos de uso avanzados para las funcionalidades más 
 * potentes de Mockito (v3.5 a v5+).</p>
 * 
 * <p><b>Por qué existe:</b> Demuestra soluciones a problemas de testabilidad complejos:</p>
 * <ul>
 *   <li><b>Mocked Construction:</b> Interceptar el operador 'new' (código legado).</li>
 *   <li><b>Answers API:</b> Respuestas dinámicas basadas en los argumentos de entrada.</li>
 *   <li><b>Lambda Matchers:</b> Validaciones de negocio ultra-precisas mediante <code>argThat</code>.</li>
 * </ul>
 * 
 * <p><b>Cómo se usa:</b> Es la clase de referencia para las lecciones L7, L8 y L9 de la Sección 3.</p>
 */
public class AdvancedService {

    private final VisitRepository visitRepository;

    public AdvancedService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * <b>CASO MOCK CONSTRUCTOR:</b> Intercepta un objeto creado localmente mediante 'new'.
     * <p>Sirve para testear código donde no se puede inyectar la dependencia.</p>
     */
    public String handleInternalCreation(Visit visit) {
        ExternalReportGenerator generator = new ExternalReportGenerator();
        return generator.generate(visit);
    }

    /**
     * <b>CASO ANSWERS:</b> Envía una visita a persistir y la devuelve.
     * <p>Ideal para practicar <code>AdditionalAnswers.returnsFirstArg()</code>.</p>
     * 
     * @param visit La visita que será procesada por el repositorio mockeado.
     * @return La visita supuestamente guardada.
     */
    public Visit saveAndLog(Visit visit) {
        return visitRepository.saveAndReturn(visit);
    }

    /**
     * <b>CASO LAMBDA MATCHERS:</b> Aplica reglas de negocio antes de guardar una visita.
     * <p>Permite demostrar aserciones finas con <code>argThat(v -> ...)</code>.</p>
     * 
     * @return true si la visita cumple las reglas (longitud > 5), false en caso contrario.
     */
    public boolean processVisitWithRules(Visit visit) {
        if (visit.getDescription() != null && visit.getDescription().length() > 5) {
            visitRepository.save(visit);
            return true;
        }
        return false;
    }
}
