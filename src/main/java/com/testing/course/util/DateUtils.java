package com.testing.course.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <h1>UTILIDAD: DateUtils (Manejo de Fechas)</h1>
 * 
 * <p><b>Qué hace:</b> Proporciona métodos estáticos globales para el formateo 
 * y validación de fechas en la aplicación.</p>
 * 
 * <p><b>Por qué existe:</b> Actúa como un helper centralizado para evitar la 
 * duplicación de patrones de fecha (yyyy-MM-dd) en múltiples controladores y servicios.</p>
 * 
 * <p><b>Cómo se usa:</b> Es la clase objetivo para demostrar <code>mockStatic</code> 
 * de Mockito, permitiendo forzar el valor de <code>now()</code> en los tests.</p>
 */
public class DateUtils {

    /**
     * Devuelve la fecha y hora actual en el formato estándar del sistema.
     * 
     * @return String con el timestamp formateado como 'yyyy-MM-dd HH:mm:ss'.
     */
    public static String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    /**
     * Determina si una fecha proporcionada en formato String corresponde al día de hoy.
     * 
     * @param timestamp La cadena de fecha a validar.
     * @return true si la fecha coincide con la actual del sistema, false en caso contrario.
     */
    public static boolean isToday(String timestamp) {
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return timestamp != null && timestamp.startsWith(today);
    }
}
