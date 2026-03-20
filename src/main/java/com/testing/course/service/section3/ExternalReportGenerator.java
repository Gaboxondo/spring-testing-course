package com.testing.course.service.section3;

import com.testing.course.model.Visit;
import java.util.UUID;

/**
 * <h1>SERVICIO DE APOYO: ExternalReportGenerator</h1>
 * 
 * <p><b>Qué hace:</b> Genera identificadores y reportes externos para visitas médicas.</p>
 * 
 * <p><b>Por qué existe:</b> Sirve como ejemplo de una clase secundaria que se 
 * instancia internamente mediante <code>new</code> dentro de un servicio principal, 
 * siendo el centro del test de <b>Mocked Construction</b> de Mockito.</p>
 * 
 * <p><b>Cómo se usa:</b> Es instanciada en <code>AdvancedService.handleInternalCreation</code>. 
 * En los tests, se intercepta su constructor para verificar que el servicio principal 
 * interactúa correctamente con este generador "oculto".</p>
 */
public class ExternalReportGenerator {

    private final String reportId;

    public ExternalReportGenerator() {
        this.reportId = UUID.randomUUID().toString();
    }

    /**
     * Genera un reporte basado en los datos de la visita.
     * 
     * @param visit Información de la visita a procesar.
     * @return String con el reporte estructurado.
     */
    public String generate(Visit visit) {
        return "ID [" + reportId + "] - Reporte para: " + visit.getDescription();
    }

    /**
     * Obtiene el identificador único del reporte generado.
     */
    public String getReportId() {
        return reportId;
    }
}
