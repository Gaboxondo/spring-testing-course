package com.testing.course.service.section3;

import com.testing.course.model.Visit;
import java.util.UUID;

/**
 * <h1>SERVICIO DE APOYO: Clases Auxiliares para Mockito Avanzado</h1>
 * 
 * <p>Esta es una clase de utilidad que será instanciada internamente por 
 * <code>AdvancedService</code> para demostrar el mockeo de constructores.</p>
 */
public class ExternalReportGenerator {

    private final String reportId;

    public ExternalReportGenerator() {
        this.reportId = UUID.randomUUID().toString();
    }

    /**
     * Genera un reporte basado en una visita.
     */
    public String generate(Visit visit) {
        // Lógica compleja imaginaria
        return "ID [" + reportId + "] - Reporte para: " + visit.getDescription();
    }

    public String getReportId() {
        return reportId;
    }
}
