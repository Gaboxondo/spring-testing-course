package com.testing.course.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Clase de ejemplo para testear inyección de propiedades masiva.
 * 
 * La anotación @ConfigurationProperties agrupa propiedades con prefijo común.
 */
@Component
@ConfigurationProperties(prefix = "external.service")
public class ExternalServiceConfig {

    private String apiKey;
    private String url;
    private int timeout;

    // Getters and Setters (NECESARIOS para Spring)
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public int getTimeout() { return timeout; }
    public void setTimeout(int timeout) { this.timeout = timeout; }
}
