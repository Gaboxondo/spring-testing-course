package com.testing.course.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <h1>Utilidades de Fecha</h1>
 * 
 * <p>Clase con métodos estáticos para demostrar el mockeo de métodos 
 * estáticos con Mockito 3.4+.</p>
 */
public class DateUtils {

    /**
     * Devuelve la fecha y hora actual en un formato específico.
     * <p>Este método es difícil de testear de forma determinista sin <code>mockStatic</code>.</p>
     * 
     * @return String con la fecha actual.
     */
    public static String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    /**
     * Valida si un timestamp es de hoy.
     * 
     * @param timestamp El timestamp a validar.
     * @return true si es de hoy, false en caso contrario.
     */
    public static boolean isToday(String timestamp) {
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return timestamp != null && timestamp.startsWith(today);
    }
}
