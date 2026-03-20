package com.testing.course.service.section2_spy;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>SERVICIO DE APOYO: Deep Dive en Spies</h1>
 * 
 * <p><b>Qué hace:</b> Contiene elementos técnicos para demostrar el comportamiento 
 * interno "bajo el capó" de los Mockito Spies.</p>
 * 
 * <p><b>Por qué existe:</b> Facilita la comprensión de conceptos avanzados como:</p>
 * <ul>
 *   <li><b>Métodos Finales:</b> Demostrar que no son interceptables tradicionalmente.</li>
 *   <li><b>Estado Interno:</b> Clave para entender el mecanismo de copiado (sombras).</li>
 *   <li><b>Clase Abstracta:</b> Permite espiar sin necesidad de una implementación real.</li>
 * </ul>
 * 
 * <p><b>Cómo se usa:</b> Objeto central de la lección <code>L3_SpyDeepDiveTheory</code>. 
 * Se instancia habitualmente con <code>mock(SpyDeepDiveService.class, CALLS_REAL_METHODS)</code>.</p>
 */
public abstract class SpyDeepDiveService {

    private final List<String> logs = new ArrayList<>();

    /**
     * Método real normal que afecta al estado interno (mutación).
     */
    public void recordLog(String message) {
        logs.add(message);
    }

    /**
     * Devuelve el número de logs registrados para aserciones de estado.
     */
    public int getLogCount() {
        return logs.size();
    }

    /**
     * <b>MÉTODO FINAL:</b> Mockito NO puede interceptar fácilmente llamadas a este método 
     * en implementaciones heredadas por proxy clásico.
     */
    public final String getSecurityToken() {
        return "REAL_SECURE_TOKEN_XYZ";
    }

    /**
     * <b>MÉTODO ABSTRACTO:</b> Usado para demostrar que Mockito puede 'rellenar' 
     * métodos sin cuerpo manteniendo la lógica de los concretos.
     */
    public abstract String fetchExternalConfig();

    /**
     * Genera un reporte combinando lógica de métodos abstractos, finales y concretos.
     * 
     * @return String con el reporte generado.
     */
    public String generateReport() {
        String config = fetchExternalConfig();
        String token = getSecurityToken();
        recordLog("Report generated with config: " + config);
        return "REPORT-TOKEN:" + token + "-CONFIG:" + config;
    }
}
