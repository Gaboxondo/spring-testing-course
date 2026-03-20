package com.testing.course.service.section2_spy;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>SERVICIO DE APOYO: Deep Dive en Spies</h1>
 * 
 * <p>Este servicio contiene elementos específicos para demostrar comportamientos 
 * "bajo el capó" de Mockito Spies, como:</p>
 * <ul>
 *   <li><b>Métodos Finales:</b> Para demostrar que no se pueden espiar.</li>
 *   <li><b>Estado Interno:</b> Para demostrar el mecanismo de copiado.</li>
 *   <li><b>Clase Abstracta:</b> Para demostrar cómo espiar sin implementación concreta.</li>
 * </ul>
 */
public abstract class SpyDeepDiveService {

    private final List<String> logs = new ArrayList<>();

    /**
     * Método real normal que afecta al estado interno.
     */
    public void recordLog(String message) {
        logs.add(message);
    }

    /**
     * Devuelve el número de logs registrados.
     */
    public int getLogCount() {
        return logs.size();
    }

    /**
     * <b>MÉTODO FINAL:</b> Mockito NO puede interceptar llamadas a este método.
     * Siempre ejecutará el código real.
     */
    public final String getSecurityToken() {
        return "REAL_SECURE_TOKEN_XYZ";
    }

    /**
     * <b>MÉTODO ABSTRACTO:</b> Demostraremos que Mockito puede espiar una 
     * clase abstracta y permitirnos mockear solo este método mientras
     * el resto de métodos reales (como recordLog) siguen funcionando.
     */
    public abstract String fetchExternalConfig();

    /**
     * Genera un reporte combinando lógica de métodos abstractos, finales y concretos.
     * <p>Este método sirve para probar el flujo completo en un Spy.</p>
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
