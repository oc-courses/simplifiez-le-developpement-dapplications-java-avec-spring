package org.example.demo.ticket.webapp.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;


/**
 * Classe de configuration de l'application REST
 *
 * @author lgu
 */
@ApplicationPath("/")
public class RestApplication extends ResourceConfig {

    /**
     * Constructeur par défaut.
     */
    public RestApplication() {
        packages("org.example.demo.ticket.webapp.rest");
    }
}
